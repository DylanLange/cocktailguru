package com.dylange.cocktailguru.data

import com.dylange.cocktailguru.app.COCKTAIL_BASE_URL
import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import rx.Single
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import java.util.concurrent.TimeUnit

/**
 * Created by dylanlange on 27/10/17.
 */
class RemoteDataEntity(private val mCocktailRemote: CocktailRemoteService) {

	companion object {
		private var mGson = Gson()
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

	fun getRandomCocktail(): Single<Cocktail> =
			sub(mCocktailRemote.getRandomCocktail())

	fun searchCocktailsByName(name: String): Single<CocktailList> =
			sub(mCocktailRemote.searchCocktailsByName(name))

	fun getIngredientByName(name: String): Single<CocktailList> =
			sub(mCocktailRemote.getIngredientByName(name))

	fun getCocktailById(id: String): Single<CocktailList> =
			sub(mCocktailRemote.getCocktailById(id))

	fun getCocktailsByIngredient(ingredient: String): Single<CocktailList> =
			sub(mCocktailRemote.getCocktailsByIngredient(ingredient))

	fun getCocktailsByGlass(glass: String): Single<CocktailList> =
			sub(mCocktailRemote.getCocktailsByGlass(glass))

	fun getCocktailsByCategory(category: String): Single<CocktailList> =
			sub(mCocktailRemote.getCocktailsByCategory(category))

	fun getCocktailsByAlcoholLevel(alcoholLevel: String): Single<CocktailList> =
			sub(mCocktailRemote.getCocktailsByAlcoholLevel(alcoholLevel))

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