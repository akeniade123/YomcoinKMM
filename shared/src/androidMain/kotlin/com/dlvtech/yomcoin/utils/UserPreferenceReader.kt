package com.dlvtech.yomcoin.utils


import android.content.Context
import android.content.SharedPreferences

/**
 * Multi platform implementation of a User preference / defaults reader
 * to store and read simple objects in user's settings.
 *
 * iOS: iOSMain/utils/
 * Android: androidMain/utils/
 */
actual class UserPreferenceReader actual constructor() {
    /**
     * Reads string for given key.
     * If key not found, it returns null
     *
     * @param key Key / Id of the value that shall be read.
     * @return Found string or nil
     */


   // context: Context


   // private val sharedPreferences: SharedPreferences =
      //  Androidx.context.getSharedPreferences("cmp-sample", Context.MODE_PRIVATE)



    /*
  //  val sharedPreferences by lazy { getSharedPreferences("main", Context.MODE_PRIVATE) }

    val sharedPreferences: SharedPreferences = this.getSharedPreferences("main",Context.MODE_PRIVATE)

    val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE)

     */

    actual fun readString(key: String): String? {
        return null
      //  return sharedPreferences.getString(key, null)
    }


    /**
     * Stores given string for provided key.
     *
     * @param key Key / Id of the value that shall be stored.
     * @param value The value that shall be stored.
     */



    actual fun storeString(key: String, value: String?) {

        /*

        if(value == null) {
            sharedPreferences
                .edit()
                .remove(key)
                .apply()
        } else {
            sharedPreferences
                .edit()
                .putString(key, value)
                .apply()
        }

         */
    }


    /*

     */


    /*
    // MARK: - Private properties -

    private val sharedPreferences: SharedPreferences =
      Android.context.getSharedPreferences("cmp-sample", Context.MODE_PRIVATE)

    // MARK: - Actual implementations -

    /**
     * Reads string for given key.
     * If key not found, it returns null
     *
     * @param key Key / Id of the value that shall be read.
     * @return Found string or nil
     */
    actual fun readString(key: String): String? {
       return sharedPreferences.getString(key, null)
    }

    /**
     * Stores given string for provided key.
     *
     * @param key Key / Id of the value that shall be stored.
     * @param value The value that shall be stored.
     */
    actual fun storeString(key: String, value: String?) {
        if(value == null) {
            sharedPreferences
                .edit()
                .remove(key)
                .apply()
        } else {
            sharedPreferences
                .edit()
                .putString(key, value)
                .apply()
        }
    }
     */


}