package com.dylange.cocktailguru.base

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.annotation.ColorRes
import android.support.annotation.DimenRes
import android.support.annotation.DrawableRes
import android.support.annotation.StringRes

/**
 * Created by dylanlange on 27/10/17.
 */

interface BaseContract {

	interface View {
		val mPresenter: Presenter
		fun showProgressDialog()
		fun hideProgressDialog()
		fun showStandardDialog(title: String,
		                       body: String,
		                       posBtnText: String,
		                       posBtnOnClick: (() -> Unit)?,
		                       negBtnText: String?,
		                       negBtnOnClick: (() -> Unit)?,
		                       icon: Drawable?)
		fun handleError(error: Throwable)
		fun getStr(@StringRes stringId: Int): String
		fun getDim(@DimenRes dimenId: Int): Float
		fun getCol(@ColorRes colorId: Int): Int
		fun getDraw(@DrawableRes drawableId: Int): Drawable
	}

	interface Interactor {

	}

	interface Presenter {
		val mView: View
		val mInteractor: Interactor
		fun onResumeCalled()
		fun onPauseCalled()
		fun onSaveInstanceStateCalled(outState: Bundle?)
	}

	interface ActivityPresenter: Presenter {
		fun onCreateCalled(savedInstanceState: Bundle?, extras: Bundle?)
		fun onDestroyCalled()
	}

	interface FragmentPresenter: Presenter {
		fun onViewCreatedCalled(savedInstanceState: Bundle?)
		fun onDestroyViewCalled()
	}

}