package com.dylange.cocktailguru.login

import android.os.Bundle

/**
 * Created by dylanlange on 27/10/17.
 */

class LoginPresenter(override val mView: LoginContract.View,
                     override val mInteractor: LoginContract.Interactor): LoginContract.Presenter {

	override fun onCreateCalled(savedInstanceState: Bundle?, extras: Bundle?) {

	}

	override fun onDestroyCalled() {

	}

	override fun onSaveInstanceStateCalled(outState: Bundle?) {

	}

	override fun onResumeCalled() {

	}

	override fun onPauseCalled() {

	}

	override fun loginBtnClicked() = mInteractor.attemptLogin(this::loginSucceeded, this::loginFailed)

	override fun loginSucceeded() {
		mView.goToMain()
	}

	override fun loginFailed(/*TODO: pass through error here in whatever form it may be*/) {
		mView.handleError(Throwable("Login Failed"))
	}

}