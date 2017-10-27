package com.dylange.cocktailguru.main

import com.dylange.cocktailguru.base.BaseContract
import com.dylange.cocktailguru.data.Cocktail

/**
 * Created by dylanlange on 27/10/17.
 */

interface MainContract {

	interface View: BaseContract.View {

	}

	interface Presenter: BaseContract.Presenter {

	}

	interface Interactor: BaseContract.Interactor {
		fun getRandomCocktail(success: (Cocktail) -> Unit,
		                      failure: (Throwable) -> Unit)
	}

}