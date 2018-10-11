package com.dylange.cocktailguru.main

import com.dylange.cocktailguru.data.Cocktail
import com.dylange.cocktailguru.data.DataManagerContract

/**
 * Created by dylanlange on 27/10/17.
 */

class MainInteractor(val mDataManager: DataManagerContract): MainContract.Interactor {

	override fun getRandomCocktail(success: (Cocktail) -> Unit, failure: (Throwable) -> Unit) {
		mDataManager.getRandomCocktail().subscribe(
				{ success(it.drinks.first()) },
				{ failure(it) }
		)
	}

}