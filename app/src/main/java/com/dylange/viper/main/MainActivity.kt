package com.dylange.viper.main

import android.os.Bundle
import com.dylange.viper.R
import com.dylange.viper.base.BaseActivity
import com.dylange.viper.data.DataManager

class MainActivity : BaseActivity(), MainContract.View {

	override val mPresenter: MainContract.Presenter = MainPresenter(this, MainInteractor(DataManager))

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
	}
}
