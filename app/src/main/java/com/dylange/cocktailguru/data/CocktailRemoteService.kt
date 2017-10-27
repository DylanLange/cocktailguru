package com.dylange.cocktailguru.data

import retrofit2.http.GET
import retrofit2.http.Query
import rx.Single

/**
 * Created by dylanlange on 27/10/17.
 */

interface CocktailRemoteService: RemoteContract {

	@GET("/random.php")
	override fun getRandomCocktail(): Single<Cocktail>

	@GET("/search.php")
	override fun searchCocktailsByName(@Query("s") name: String): Single<Cocktail.ListWrapper>

	@GET("/search.php")
	override fun getIngredientByName(@Query("i") name: String): Single<Cocktail.ListWrapper>

	@GET("/lookup.php")
	override fun getCocktailById(@Query("i") id: String): Single<Cocktail.ListWrapper>

	@GET("/filter.php")
	override fun getCocktailsByIngredient(@Query("i") ingredient: String): Single<Cocktail.ListWrapper>

	@GET("/filter.php")
	override fun getCocktailsByGlass(@Query("g") glass: String): Single<Cocktail.ListWrapper>

	@GET("/filter.php")
	override fun getCocktailsByCategory(@Query("c") category: String): Single<Cocktail.ListWrapper>

	@GET("/filter.php")
	override fun getCocktailsByAlcoholLevel(@Query("a") alcoholLevel: String): Single<Cocktail.ListWrapper>

	@GET("/list.php?c=list")
	override fun getCategoryList(): Single<Category.ListWrapper>

	@GET("/list.php?a=list")
	override fun getAlcoholicLevelList(): Single<AlcoholicLevel.ListWrapper>

	@GET("/list.php?g=list")
	override fun getGlassList(): Single<Glass.ListWrapper>

	@GET("/list.php?i=list")
	override fun getIngredientList(): Single<Ingredient.ListWrapper>

}