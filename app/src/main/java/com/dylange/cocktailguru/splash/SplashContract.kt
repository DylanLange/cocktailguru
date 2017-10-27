package com.dylange.cocktailguru.splash

import android.os.Handler
import com.dylange.cocktailguru.base.BaseContract

/**
 * Created by dylanlange on 27/10/17.
 */

interface SplashContract {

	interface View: BaseContract.View {
		val mHandler: Handler
		fun animateLogo()
		fun goToMain()
		fun goToLogin()
	}

	interface Presenter: BaseContract.Presenter {

	}

	interface Interactor: BaseContract.Interactor {
		fun isLoggedIn(): Boolean
	}

}