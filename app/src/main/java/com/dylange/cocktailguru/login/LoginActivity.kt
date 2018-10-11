package com.dylange.cocktailguru.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.dylange.cocktailguru.R
import com.dylange.cocktailguru.base.BaseActivity
import com.dylange.cocktailguru.data.DataManager
import com.dylange.cocktailguru.main.MainActivity

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