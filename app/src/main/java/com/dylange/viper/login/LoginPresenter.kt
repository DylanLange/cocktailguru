package com.dylange.viper.login

import android.os.Bundle

/**
 * Created by dylanlange on 27/10/17.
 */

class LoginPresenter(override val mView: LoginContract.View,
                     override val mInteractor: LoginContract.Interactor): LoginContract.Presenter {

	override fun onCreateCalled(savedInstanceState: Bundle?, extras: Bundle) {

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