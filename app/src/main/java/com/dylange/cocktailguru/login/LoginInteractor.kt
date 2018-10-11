package com.dylange.cocktailguru.login

import com.dylange.cocktailguru.data.DataManagerContract

/**
 * Created by dylanlange on 27/10/17.
 */

class LoginInteractor(val mDataManager: DataManagerContract): LoginContract.Interactor {

	override fun attemptLogin(successCallback: () -> Unit, failureCallback: () -> Unit) {
		TODO()
	}

}