package com.dylange.cocktailguru.main

import android.os.Bundle

/**
 * Created by dylanlange on 27/10/17.
 */

class MainPresenter(override val mView: MainContract.View,
                    override val mInteractor: MainContract.Interactor): MainContract.Presenter {

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

}