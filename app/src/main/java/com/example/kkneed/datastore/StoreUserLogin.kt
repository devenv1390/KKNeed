package com.example.kkneed.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class StoreUserLogin(private val context: Context) {
    // to make sure there is only one instance
    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("UserLogin")
        val USER_Login_KEY = booleanPreferencesKey("user_login")
    }

    // to get the email
    val getLogin: Flow<Boolean?> = context.dataStore.data
        .map { preferences ->
            preferences[USER_Login_KEY] ?: false
        }

    // to save the email
    suspend fun saveLogin(boolean: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[USER_Login_KEY] = boolean
        }
    }
}