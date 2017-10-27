package com.dylange.cocktailguru.main

import android.os.Bundle
import android.util.Log
import com.dylange.cocktailguru.app.COCKTAIL_BASE_URL

/**
 * Created by dylanlange on 27/10/17.
 */

class MainPresenter(override val mView: MainContract.View,
                    override val mInteractor: MainContract.Interactor): MainContract.Presenter {

	override fun onCreateCalled(savedInstanceState: Bundle?, extras: Bundle?) {
		Log.d("COCKTAIL_BASE_URL", COCKTAIL_BASE_URL)
		mInteractor.getRandomCocktail(
				{
					Log.d("DYL", it.toString())
				},
				{
					it.printStackTrace()
				}
		)
	}

	override fun onDestroyCalled() {

	}

	override fun onSaveInstanceStateCalled(outState: Bundle?) {

	}

	override fun onResumeCalled() {

	}

	override fun onPauseCalled() {

	}

}