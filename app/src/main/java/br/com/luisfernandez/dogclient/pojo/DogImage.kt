package br.com.luisfernandez.dogclient.pojo

import android.os.Parcel
import android.os.Parcelable

data class DogImage(
        val imageUrl: String
) : Parcelable {
    constructor(parcel: Parcel) : this(parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(imageUrl)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DogImage> {
        override fun createFromParcel(parcel: Parcel): DogImage {
            return DogImage(parcel)
        }

        override fun newArray(size: Int): Array<DogImage?> {
            return arrayOfNulls(size)
        }
    }
}