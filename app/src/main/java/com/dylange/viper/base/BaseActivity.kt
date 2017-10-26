package com.dylange.viper.base

import android.graphics.drawable.Drawable
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity

/**
 * Created by dylanlange on 27/10/17.
 */

open class BaseActivity: AppCompatActivity(), BaseContract.View {

	override val mPresenter: BaseContract.Presenter
		get() = TODO("not implemented")//overridden in every view

	private val mStandardDialog: AlertDialog? = null
	private val mProgressDialog: AlertDialog? = null

	override fun showStandardDialog(title: String,
	                                body: String,
	                                posBtnText: String,
	                                posBtnOnClick: (() -> Unit)?,
	                                negBtnText: String?,
	                                negBtnOnClick: (() -> Unit)?,
	                                icon: Drawable?) {

		//TODO

	}

	override fun handleError(error: Throwable) {

	}

	override fun showProgressDialog() {

	}

	override fun hideProgressDialog() {

	}

	override fun getStr(stringId: Int): String = resources.getString(stringId)

	override fun getDim(dimenId: Int): Float = resources.getDimension(dimenId)

	override fun getCol(colorId: Int): Int = resources.getColor(colorId)

	override fun getDraw(drawableId: Int): Drawable = resources.getDrawable(drawableId)

}