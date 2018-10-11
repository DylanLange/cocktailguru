package com.dylange.cocktailguru.splash

import com.dylange.cocktailguru.data.DataManagerContract

/**
 * Created by dylanlange on 27/10/17.
 */

class SplashInteractor(val mDataManager: DataManagerContract): SplashContract.Interactor {

	override fun isLoggedIn(): Boolean {
		return true//TODO: add logic here for auth token checking
	}

}