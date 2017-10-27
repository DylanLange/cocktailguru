package com.dylange.cocktailguru.data

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

/**
 * Created by dylanlange on 27/10/17.
 */

data class Cocktail(
		@SerializedName("strDrink")
		val name: String,

		@SerializedName("strDrinkThumb")
		val imageUrl: String,

		@SerializedName("idDrink")
		val id: Int
) : Parcelable {
	constructor(source: Parcel) : this(
			source.readString(),
			source.readString(),
			source.readInt()
	)

	override fun describeContents() = 0

	override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
		writeString(name)
		writeString(imageUrl)
		writeInt(id)
	}

	companion object {
		@JvmField
		val CREATOR: Parcelable.Creator<Cocktail> = object : Parcelable.Creator<Cocktail> {
			override fun createFromParcel(source: Parcel): Cocktail = Cocktail(source)
			override fun newArray(size: Int): Array<Cocktail?> = arrayOfNulls(size)
		}
	}
}

data class CocktailList(val drinks: List<Cocktail>)