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
	fun searchCocktailsByName(@Query("s") name: String): Single<CocktailList>

	@GET("/search.php")
	fun getIngredientByName(@Query("i") name: String): Single<CocktailList>

	@GET("/lookup.php")
	fun getCocktailById(@Query("i") id: String): Single<CocktailList>

	@GET("/filter.php")
	fun getCocktailsByIngredient(@Query("i") ingredient: String): Single<CocktailList>

	@GET("/filter.php")
	fun getCocktailsByGlass(@Query("g") glass: String): Single<CocktailList>

	@GET("/filter.php")
	fun getCocktailsByCategory(@Query("c") category: String): Single<CocktailList>

	@GET("/filter.php")
	fun getCocktailsByAlcoholLevel(@Query("a") alcoholLevel: String): Single<CocktailList>

}