package com.dylange.viper.data

/**
 * Created by dylanlange on 27/10/17.
 */

object DataManager: DataManagerContract {

	override val mRemoteData: RemoteDataEntity = RemoteDataEntity.getInstance()
	override val mLocalData: LocalDataEntity = LocalDataEntity.getInstance()

}