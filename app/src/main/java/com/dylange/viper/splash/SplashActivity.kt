package com.dylange.viper.splash

import android.os.Bundle
import android.os.Handler
import com.dylange.viper.R
import com.dylange.viper.base.BaseActivity
import com.dylange.viper.data.DataManager
import com.dylange.viper.login.LoginActivity
import com.dylange.viper.main.MainActivity

/**
 * Created by dylanlange on 27/10/17.
 */

private const val SPLASH_DELAY_DURATION: Long = 1500

class SplashActivity: BaseActivity(), SplashContract.View {

	override val mPresenter: SplashContract.Presenter = SplashPresenter(this, SplashInteractor(DataManager))
	override val mHandler = Handler()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_splash)
	}

	override fun animateLogo() {

	}

	override fun goToMain() {
		mHandler.postDelayed(
				{
					startActivity(MainActivity.getIntent(this@SplashActivity))
				},
				SPLASH_DELAY_DURATION
		)
	}

	override fun goToLogin() {
		mHandler.postDelayed(
				{
					startActivity(LoginActivity.getIntent(this@SplashActivity))
				},
				SPLASH_DELAY_DURATION
		)
	}

}