package com.dylange.cocktailguru.main.random

import com.dylange.cocktailguru.base.BaseFragment
import com.dylange.cocktailguru.data.DataManager

/**
 * Created by dylanlange on 30/10/17.
 */

class RandomFragment: BaseFragment(), RandomContract.View {

	override val mPresenter: RandomContract.Presenter = RandomPresenter(this, RandomInteractor(DataManager))



}