package com.dylange.cocktailguru.data

import com.dylange.cocktailguru.app.COCKTAIL_BASE_URL
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by dylanlange on 27/10/17.
 */
interface RemoteContract {
	fun getRandomCocktail(): Single<Cocktail.ListWrapper>
	fun searchCocktailsByName(name: String): Single<Cocktail.ListWrapper>
	fun getIngredientByName(name: String): Single<Cocktail.ListWrapper>
	fun getCocktailById(id: String): Single<Cocktail.ListWrapper>
	fun getCocktailsByIngredient(ingredient: String): Single<Cocktail.ListWrapper>
	fun getCocktailsByGlass(glass: String): Single<Cocktail.ListWrapper>
	fun getCocktailsByCategory(category: String): Single<Cocktail.ListWrapper>
	fun getCocktailsByAlcoholLevel(alcoholLevel: String): Single<Cocktail.ListWrapper>

	fun getCategoryList(): Single<Category.ListWrapper>
	fun getAlcoholicLevelList(): Single<AlcoholicLevel.ListWrapper>
	fun getGlassList(): Single<Glass.ListWrapper>
	fun getIngredientList(): Single<Ingredient.ListWrapper>
}

class RemoteDataEntity(private val mCocktailRemote: CocktailRemoteService): RemoteContract {

	companion object {
		private var mGson = GsonBuilder().setLenient().create()
		@JvmStatic private var mInstance: RemoteDataEntity? = null
		@JvmStatic fun getInstance()= mInstance ?: RemoteDataEntity(getCocktailRemote())

		private fun getCocktailRemote(): CocktailRemoteService {
			val client: OkHttpClient =
					OkHttpClient.Builder()
//				            .cache(cache)
//							.addInterceptor(TokenRefreshInterceptor())
							.connectTimeout(30, TimeUnit.SECONDS)
							.readTimeout(30, TimeUnit.SECONDS)
							.build()
			val retrofit: Retrofit =
					getRetrofitBuilder(client, Gson())
							.baseUrl(COCKTAIL_BASE_URL)
							.build()


			return retrofit.create<CocktailRemoteService>(CocktailRemoteService::class.java)
		}

		private fun getRetrofitBuilder(client: OkHttpClient, gson: Gson): Retrofit.Builder =
				Retrofit.Builder()
						.addConverterFactory(GsonConverterFactory.create(gson))
						.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
						.client(client)
	}

	override fun getRandomCocktail(): Single<Cocktail.ListWrapper> =
			sub(mCocktailRemote.getRandomCocktail())

	override fun searchCocktailsByName(name: String): Single<Cocktail.ListWrapper> =
			sub(mCocktailRemote.searchCocktailsByName(name))

	override fun getIngredientByName(name: String): Single<Cocktail.ListWrapper> =
			sub(mCocktailRemote.getIngredientByName(name))

	override fun getCocktailById(id: String): Single<Cocktail.ListWrapper> =
			sub(mCocktailRemote.getCocktailById(id))

	override fun getCocktailsByIngredient(ingredient: String): Single<Cocktail.ListWrapper> =
			sub(mCocktailRemote.getCocktailsByIngredient(ingredient))

	override fun getCocktailsByGlass(glass: String): Single<Cocktail.ListWrapper> =
			sub(mCocktailRemote.getCocktailsByGlass(glass))

	override fun getCocktailsByCategory(category: String): Single<Cocktail.ListWrapper> =
			sub(mCocktailRemote.getCocktailsByCategory(category))

	override fun getCocktailsByAlcoholLevel(alcoholLevel: String): Single<Cocktail.ListWrapper> =
			sub(mCocktailRemote.getCocktailsByAlcoholLevel(alcoholLevel))

	override fun getCategoryList(): Single<Category.ListWrapper> =
			sub(mCocktailRemote.getCategoryList())

	override fun getAlcoholicLevelList(): Single<AlcoholicLevel.ListWrapper> =
			sub(mCocktailRemote.getAlcoholicLevelList())

	override fun getGlassList(): Single<Glass.ListWrapper> =
			sub(mCocktailRemote.getGlassList())

	override fun getIngredientList(): Single<Ingredient.ListWrapper> =
			sub(mCocktailRemote.getIngredientList())

	private fun <T> sub(single: Single<T>): Single<T> =
			single
			.subscribeOn(Schedulers.io())
			.observeOn(AndroidSchedulers.mainThread())
			.compose {
				it.onErrorResumeNext {
					Single.error<T>(it)
				}
			}

}