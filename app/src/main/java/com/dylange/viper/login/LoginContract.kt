package com.dylange.viper.login

import com.dylange.viper.base.BaseContract

/**
 * Created by dylanlange on 27/10/17.
 */

interface LoginContract {

	interface View: BaseContract.View {
		fun goToMain()
	}

	interface Presenter: BaseContract.Presenter {
		fun loginBtnClicked()
		fun loginSucceeded()
		fun loginFailed()
	}

	interface Interactor: BaseContract.Interactor {
		fun attemptLogin(successCallback: () -> Unit,
		                 failureCallback: () -> Unit)
	}

}