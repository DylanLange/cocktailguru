package com.dylange.cocktailguru.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.dylange.cocktailguru.R
import com.dylange.cocktailguru.base.BaseActivity
import com.dylange.cocktailguru.data.DataManager

class MainActivity : BaseActivity(), MainContract.View {

	companion object {
		@JvmStatic fun getIntent(context: Context): Intent {
			return Intent(context, MainActivity::class.java)
		}
	}

	override val mPresenter: MainContract.Presenter = MainPresenter(this, MainInteractor(DataManager))

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
	}
}
