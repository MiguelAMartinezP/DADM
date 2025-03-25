package com.example.myapplication

import android.os.Parcel
import android.os.Parcelable
import kotlin.random.Random

data class User(val name: String, val password: String) : Parcelable {
    val hashcode: String = "#${Random.nextInt(0, 9)}" // Generamos un hashcode cuando el objeto es creado

    // El constructor que recibe el Parcel debe extraer los valores
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "", // name
        parcel.readString() ?: ""  // password
    )

    // Implementación de describeContents
    override fun describeContents(): Int {
        return 0 // Generalmente se devuelve 0, a menos que haya algún tipo especial de contenido en el Parcelable
    }

    // Guardamos los valores en el Parcel
    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(this.name)
        dest.writeString(this.password)
        dest.writeString(this.hashcode)  // Guardamos el hashcode también
    }

    // Creación del objeto Parcelable
    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel) // Usamos el constructor que toma el Parcel
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size) // Devolvemos un array de objetos User
        }
    }
}
