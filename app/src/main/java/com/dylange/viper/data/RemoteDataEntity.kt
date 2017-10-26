package com.dylange.viper.data

/**
 * Created by dylanlange on 27/10/17.
 */
class RemoteDataEntity {

	companion object {
		private var mInstance: RemoteDataEntity? = null
		@JvmStatic fun getInstance(): RemoteDataEntity {
			return mInstance ?: RemoteDataEntity()
		}
	}

}