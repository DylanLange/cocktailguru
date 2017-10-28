package com.dylange.cocktailguru.main

import android.os.Bundle
import android.util.Log
import com.dylange.cocktailguru.data.Cocktail

/**
 * Created by dylanlange on 27/10/17.
 */

class MainPresenter(override val mView: MainContract.View,
                    override val mInteractor: MainContract.Interactor): MainContract.Presenter {

	override fun onCreateCalled(savedInstanceState: Bundle?, extras: Bundle?) {
		mInteractor.getRandomCocktail(this::randomCocktailReceived, this::randomCocktailGetFailed)
	}

	override fun onDestroyCalled() {

	}

	override fun onSaveInstanceStateCalled(outState: Bundle?) {

	}

	override fun onResumeCalled() {

	}

	override fun onPauseCalled() {

	}

	override fun randomCocktailReceived(cocktail: Cocktail) {
		Log.d("DYL", cocktail.toString())
	}

	override fun randomCocktailGetFailed(throwable: Throwable) {
		throwable.printStackTrace()
	}

}