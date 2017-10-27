package com.dylange.cocktailguru.data

import retrofit2.http.GET
import retrofit2.http.Query
import rx.Single

/**
 * Created by dylanlange on 27/10/17.
 */

interface CocktailRemoteService {

	@GET("/random.php")
	fun getRandomCocktail(): Single<Cocktail>

	@GET("/search.php")
	fun searchCocktailsByName(@Query("s") name: String): Single<Cocktail.ListWrapper>

	@GET("/search.php")
	fun getIngredientByName(@Query("i") name: String): Single<Cocktail.ListWrapper>

	@GET("/lookup.php")
	fun getCocktailById(@Query("i") id: String): Single<Cocktail.ListWrapper>

	@GET("/filter.php")
	fun getCocktailsByIngredient(@Query("i") ingredient: String): Single<Cocktail.ListWrapper>

	@GET("/filter.php")
	fun getCocktailsByGlass(@Query("g") glass: String): Single<Cocktail.ListWrapper>

	@GET("/filter.php")
	fun getCocktailsByCategory(@Query("c") category: String): Single<Cocktail.ListWrapper>

	@GET("/filter.php")
	fun getCocktailsByAlcoholLevel(@Query("a") alcoholLevel: String): Single<Cocktail.ListWrapper>

	@GET("/list.php?c=list")
	fun getCategoryList(): Single<Category.ListWrapper>

	@GET("/list.php?a=list")
	fun getAlcoholicLevelList(): Single<AlcoholicLevel.ListWrapper>

	@GET("/list.php?g=list")
	fun getGlassList(): Single<Glass.ListWrapper>

	@GET("/list.php?i=list")
	fun getIngredientList(): Single<Ingredient.ListWrapper>

}