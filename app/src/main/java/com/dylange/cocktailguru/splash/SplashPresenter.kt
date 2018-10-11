package com.dylange.cocktailguru.splash

import android.os.Bundle

/**
 * Created by dylanlange on 27/10/17.
 */

class SplashPresenter(override val mView: SplashContract.View,
                      override val mInteractor: SplashContract.Interactor): SplashContract.Presenter {

	override fun onCreateCalled(savedInstanceState: Bundle?, extras: Bundle?) {
		if(mInteractor.isLoggedIn()) {
			mView.goToMain()
		} else {
			mView.goToLogin()
		}
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