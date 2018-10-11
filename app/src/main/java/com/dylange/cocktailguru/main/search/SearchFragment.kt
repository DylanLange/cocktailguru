package com.dylange.cocktailguru.main.search

import com.dylange.cocktailguru.base.BaseFragment
import com.dylange.cocktailguru.data.DataManager

/**
 * Created by dylanlange on 30/10/17.
 */

class SearchFragment : BaseFragment(), SearchContract.View {

	override val mPresenter: SearchContract.Presenter = SearchPresenter(this, SearchInteractor(DataManager))

	companion object {
		@JvmStatic fun newInstance() = SearchFragment()
	}

}