package com.dylange.cocktailguru.data

import com.dylange.cocktailguru.app.API_KEY
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by dylanlange on 27/10/17.
 */

interface CocktailRemoteService {

	@GET("/api/json/v1/$API_KEY/random.php")
	fun getRandomCocktail(): Single<Cocktail.ListWrapper>

	@GET("/api/json/v1/$API_KEY/search.php")
	fun searchCocktailsByName(@Query("s") name: String): Single<Cocktail.ListWrapper>

	@GET("/api/json/v1/$API_KEY/search.php")
	fun getIngredientByName(@Query("i") name: String): Single<Cocktail.ListWrapper>

	@GET("/api/json/v1/$API_KEY/lookup.php")
	fun getCocktailById(@Query("i") id: String): Single<Cocktail.ListWrapper>

	@GET("/api/json/v1/$API_KEY/filter.php")
	fun getCocktailsByIngredient(@Query("i") ingredient: String): Single<Cocktail.ListWrapper>

	@GET("/api/json/v1/$API_KEY/filter.php")
	fun getCocktailsByGlass(@Query("g") glass: String): Single<Cocktail.ListWrapper>

	@GET("/api/json/v1/$API_KEY/filter.php")
	fun getCocktailsByCategory(@Query("c") category: String): Single<Cocktail.ListWrapper>

	@GET("/api/json/v1/$API_KEY/filter.php")
	fun getCocktailsByAlcoholLevel(@Query("a") alcoholLevel: String): Single<Cocktail.ListWrapper>

	@GET("/api/json/v1/$API_KEY/list.php?c=list")
	fun getCategoryList(): Single<Category.ListWrapper>

	@GET("/api/json/v1/$API_KEY/list.php?a=list")
	fun getAlcoholicLevelList(): Single<AlcoholicLevel.ListWrapper>

	@GET("/api/json/v1/$API_KEY/list.php?g=list")
	fun getGlassList(): Single<Glass.ListWrapper>

	@GET("/api/json/v1/$API_KEY/list.php?i=list")
	fun getIngredientList(): Single<Ingredient.ListWrapper>

}