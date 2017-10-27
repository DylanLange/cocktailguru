package com.dylange.cocktailguru.data

/**
 * Created by dylanlange on 27/10/17.
 */

class LocalDataEntity {

	companion object {
		private var mInstance: LocalDataEntity? = null
		@JvmStatic fun getInstance(): LocalDataEntity {
			return mInstance ?: LocalDataEntity()
		}
	}

}