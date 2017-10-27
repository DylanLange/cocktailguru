package com.dylange.cocktailguru.data

/**
 * Created by dylanlange on 27/10/17.
 */

interface DataManagerContract: RemoteContract {

	val mRemoteData: RemoteDataEntity
	val mLocalData: LocalDataEntity

}