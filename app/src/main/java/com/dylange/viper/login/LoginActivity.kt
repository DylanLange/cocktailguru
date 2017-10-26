package com.dylange.viper.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.dylange.viper.R
import com.dylange.viper.base.BaseActivity
import com.dylange.viper.data.DataManager
import com.dylange.viper.main.MainActivity

/**
 * Created by dylanlange on 27/10/17.
 */

class LoginActivity: BaseActivity(), LoginContract.View {

	override val mPresenter: LoginContract.Presenter = LoginPresenter(this, LoginInteractor(DataManager))

	companion object {
		@JvmStatic fun getIntent(context: Context): Intent {
			return Intent(context, LoginActivity::class.java)
		}
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_login)
	}

	override fun goToMain() = startActivity(MainActivity.getIntent(this))

}