package com.dylange.viper.login

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

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_login)
	}

	override fun goToMain() = startActivity(MainActivity.getIntent(this))

}