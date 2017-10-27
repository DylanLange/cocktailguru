package com.dylange.cocktailguru.data

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

/**
 * Created by dylanlange on 27/10/17.
 */

data class Category(
		@SerializedName("strCategory")
		val name: String
) : Parcelable {
	data class ListWrapper(val categories: List<Category>)

	constructor(source: Parcel) : this(
			source.readString()
	)

	override fun describeContents() = 0

	override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
		writeString(name)
	}

	companion object {
		@JvmField
		val CREATOR: Parcelable.Creator<Category> = object : Parcelable.Creator<Category> {
			override fun createFromParcel(source: Parcel): Category = Category(source)
			override fun newArray(size: Int): Array<Category?> = arrayOfNulls(size)
		}
	}
}

data class AlcoholicLevel(
		@SerializedName("strCategory")
		val name: String
) : Parcelable {
	data class ListWrapper(val alcoholicLevels: List<AlcoholicLevel>)

	constructor(source: Parcel) : this(
			source.readString()
	)

	override fun describeContents() = 0

	override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
		writeString(name)
	}

	companion object {
		@JvmField
		val CREATOR: Parcelable.Creator<AlcoholicLevel> = object : Parcelable.Creator<AlcoholicLevel> {
			override fun createFromParcel(source: Parcel): AlcoholicLevel = AlcoholicLevel(source)
			override fun newArray(size: Int): Array<AlcoholicLevel?> = arrayOfNulls(size)
		}
	}
}

data class Glass(
		@SerializedName("strCategory")
		val name: String
) : Parcelable {
	data class ListWrapper(val glasses: List<Glass>)

	constructor(source: Parcel) : this(
			source.readString()
	)

	override fun describeContents() = 0

	override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
		writeString(name)
	}

	companion object {
		@JvmField
		val CREATOR: Parcelable.Creator<Glass> = object : Parcelable.Creator<Glass> {
			override fun createFromParcel(source: Parcel): Glass = Glass(source)
			override fun newArray(size: Int): Array<Glass?> = arrayOfNulls(size)
		}
	}
}

data class Ingredient(
		@SerializedName("strCategory")
		val name: String
) : Parcelable {
	data class ListWrapper(val ingredients: List<Ingredient>)

	constructor(source: Parcel) : this(
			source.readString()
	)

	override fun describeContents() = 0

	override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
		writeString(name)
	}

	companion object {
		@JvmField
		val CREATOR: Parcelable.Creator<Ingredient> = object : Parcelable.Creator<Ingredient> {
			override fun createFromParcel(source: Parcel): Ingredient = Ingredient(source)
			override fun newArray(size: Int): Array<Ingredient?> = arrayOfNulls(size)
		}
	}
}

data class Cocktail(
		@SerializedName("strDrink")
		val name: String,

		@SerializedName("strDrinkThumb")
		val imageUrl: String,

		@SerializedName("idDrink")
		val id: Int
) : Parcelable {

	data class ListWrapper(val drinks: List<Cocktail>)

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