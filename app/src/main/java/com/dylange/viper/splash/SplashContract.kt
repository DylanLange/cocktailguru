package com.dylange.viper.splash

import android.os.Handler
import com.dylange.viper.base.BaseContract

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