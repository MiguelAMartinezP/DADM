package com.example.myapplication

import android.os.Parcel
import android.os.Parcelable
import kotlin.random.Random

/**
 * User Class
 * Contains the most relevant information utilised to identify a player, employs the parcelable
 * interface so that it can be passed as an argument through intents.
 * @param Name: String .
 * @param Password: String.
 * @constructor Sets the users password and name as well as a random hashcode which will allow for
 * repeated names.
 */
data class User(val name: String, val password: String) : Parcelable {
     // Generamos un hashcode cuando el objeto es creado

    // El constructor que recibe el Parcel debe extraer los valores
    /**
     * Inherited constructor required by the parcelable logic.
     */
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "", // name
        parcel.readString() ?: ""  // password
    )

    /**
     * Shows relevant information to be taken account of when handling the parcel.
     * @Return relevant information to be stored inside the parcel, 0 if none.
     */
    override fun describeContents(): Int {
        return 0 // Generalmente se devuelve 0, a menos que haya algún tipo especial de contenido en el Parcelable
    }

    /**
     * Similar to the toString method but for parcels
     */
    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(this.name)
        dest.writeString(this.password) // Guardamos el hashcode también
    }

    /**
     * Creation of the parcel object
     */
    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel) // Usamos el constructor que toma el Parcel
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size) // Devolvemos un array de objetos User
        }
    }
}
