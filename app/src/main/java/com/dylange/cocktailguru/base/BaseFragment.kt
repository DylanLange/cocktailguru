package com.dylange.cocktailguru.base

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View

/**
 * Created by dylanlange on 27/10/17.
 */

open class BaseFragment : Fragment(), BaseContract.View {

	override val mPresenter: BaseContract.FragmentPresenter
		get() = TODO("not implemented")//overridden in every view

	override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		mPresenter.onViewCreatedCalled(savedInstanceState)
	}

	override fun onDestroyView() {
		super.onDestroyView()
		mPresenter.onDestroyViewCalled()
	}

	override fun onSaveInstanceState(outState: Bundle?) {
		super.onSaveInstanceState(outState)
		mPresenter.onSaveInstanceStateCalled(outState)
	}

	override fun onResume() {
		super.onResume()
		mPresenter.onResumeCalled()
	}

	override fun onPause() {
		super.onPause()
		mPresenter.onPauseCalled()
	}

	override fun showStandardDialog(title: String,
	                                body: String,
	                                posBtnText: String,
	                                posBtnOnClick: (() -> Unit)?,
	                                negBtnText: String?,
	                                negBtnOnClick: (() -> Unit)?,
	                                icon: Drawable?) {
		(activity as BaseActivity).showStandardDialog(title, body, posBtnText, posBtnOnClick, negBtnText, negBtnOnClick, icon)
	}

	override fun handleError(error: Throwable) = (activity as BaseActivity).handleError(error)

	override fun showProgressDialog() = (activity as BaseActivity).showProgressDialog()

	override fun hideProgressDialog() = (activity as BaseActivity).hideProgressDialog()

	override fun getStr(stringId: Int): String = resources.getString(stringId)

	override fun getDim(dimenId: Int): Float = resources.getDimension(dimenId)

	override fun getCol(colorId: Int): Int = resources.getColor(colorId)

	override fun getDraw(drawableId: Int): Drawable = resources.getDrawable(drawableId)

}