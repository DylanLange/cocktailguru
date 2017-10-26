package com.dylange.viper.login

import com.dylange.viper.data.DataManager

/**
 * Created by dylanlange on 27/10/17.
 */

class LoginInteractor(val mDataManager: DataManager): LoginContract.Interactor {

	override fun attemptLogin(successCallback: () -> Unit, failureCallback: () -> Unit) {
		TODO()
	}

}