package com.dylange.cocktailguru.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.ViewPager
import android.view.ViewGroup
import com.dylange.cocktailguru.R
import com.dylange.cocktailguru.base.BaseActivity
import com.dylange.cocktailguru.data.DataManager
import com.dylange.cocktailguru.main.random.RandomFragment
import com.dylange.cocktailguru.main.search.SearchFragment
import kotlinx.android.synthetic.main.activity_main.*

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
		viewpager.adapter = ViewPagerAdapter(supportFragmentManager)
		viewpager.offscreenPageLimit = 1

		viewpager.addOnPageChangeListener(object: ViewPager.OnPageChangeListener {
			override fun onPageScrollStateChanged(state: Int) { }
			override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) { }
			override fun onPageSelected(position: Int) {
				bottom_nav.selectedItemId = when(position) {
					0 -> R.id.action_random
					1 -> R.id.action_search
					else -> R.id.action_random
				}
			}
		})

		bottom_nav.setOnNavigationItemSelectedListener {
			bottom_nav.menu.getItem(0).icon = resources.getDrawable(R.drawable.ic_trophy_inactive)
			bottom_nav.menu.getItem(1).icon = resources.getDrawable(R.drawable.ic_search_inactive)
			when (it.itemId) {
				R.id.action_random -> {
					viewpager.setCurrentItem(0, true)
					title = resources.getString(R.string.tab_name_1)
					it.icon = resources.getDrawable(R.drawable.ic_search_active)
				}
				R.id.action_search -> {
					viewpager.setCurrentItem(1, true)
					title = resources.getString(R.string.tab_name_2)
					it.icon = resources.getDrawable(R.drawable.ic_trophy_active)
				}
			}
			supportInvalidateOptionsMenu()
			true
		}
	}

	class ViewPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

		val NUM_PAGES: Int = 2
		lateinit var mRandomFragment: RandomFragment
		lateinit var mSearchFragment: SearchFragment

		override fun instantiateItem(container: ViewGroup?, position: Int): Any {
			when (position) {
				0 -> {
					mRandomFragment = super.instantiateItem(container, position) as RandomFragment
					return mRandomFragment
				}
				1 -> {
					mSearchFragment = super.instantiateItem(container, position) as SearchFragment
					return mSearchFragment
				}
				else -> return super.instantiateItem(container, position)
			}
		}

		override fun getItem(position: Int): Fragment? {
			if (position == 0) {
				return RandomFragment.newInstance()
			} else if (position == 1) {
				return SearchFragment.newInstance()
			} else {
				return null
			}
		}

		override fun getCount(): Int {
			return NUM_PAGES
		}

	}

}
