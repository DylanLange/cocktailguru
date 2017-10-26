package com.dylange.viper.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.dylange.viper.R
import com.dylange.viper.base.BaseActivity
import com.dylange.viper.main.MainActivity

/**
 * Created by dylanlange on 27/10/17.
 */

class SplashActivity: BaseActivity() {

	private val mHandler = Handler()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_splash)
		mHandler.postDelayed(
				{
					startActivity(Intent(this@SplashActivity, MainActivity::class.java))
				},
				1500)
		//TODO: maybe add in some cool anims
	}

}