package com.dylange.viper.splash

import com.dylange.viper.data.DataManagerContract

/**
 * Created by dylanlange on 27/10/17.
 */

class SplashInteractor(val mDataManager: DataManagerContract): SplashContract.Interactor {

	override fun isLoggedIn(): Boolean {
		return true//TODO: add logic here for auth token checking
	}

}