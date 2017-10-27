package com.dylange.cocktailguru.data

import io.reactivex.Single


/**
 * Created by dylanlange on 27/10/17.
 */

object DataManager: DataManagerContract {

	override val mRemoteData: RemoteDataEntity = RemoteDataEntity.getInstance()
	override val mLocalData: LocalDataEntity = LocalDataEntity.getInstance()

	override fun getRandomCocktail(): Single<Cocktail.ListWrapper> =
			mRemoteData.getRandomCocktail()

	override fun searchCocktailsByName(name: String): Single<Cocktail.ListWrapper> =
			mRemoteData.searchCocktailsByName(name)

	override fun getIngredientByName(name: String): Single<Cocktail.ListWrapper> =
			mRemoteData.getIngredientByName(name)

	override fun getCocktailById(id: String): Single<Cocktail.ListWrapper> =
			mRemoteData.getCocktailById(id)

	override fun getCocktailsByIngredient(ingredient: String): Single<Cocktail.ListWrapper> =
			mRemoteData.getCocktailsByIngredient(ingredient)

	override fun getCocktailsByGlass(glass: String): Single<Cocktail.ListWrapper> =
			mRemoteData.getCocktailsByGlass(glass)

	override fun getCocktailsByCategory(category: String): Single<Cocktail.ListWrapper> =
			mRemoteData.getCocktailsByCategory(category)

	override fun getCocktailsByAlcoholLevel(alcoholLevel: String): Single<Cocktail.ListWrapper> =
			mRemoteData.getCocktailsByAlcoholLevel(alcoholLevel)

	override fun getCategoryList(): Single<Category.ListWrapper> =
			mRemoteData.getCategoryList()

	override fun getAlcoholicLevelList(): Single<AlcoholicLevel.ListWrapper> =
			mRemoteData.getAlcoholicLevelList()

	override fun getGlassList(): Single<Glass.ListWrapper> =
			mRemoteData.getGlassList()

	override fun getIngredientList(): Single<Ingredient.ListWrapper> =
			mRemoteData.getIngredientList()

}