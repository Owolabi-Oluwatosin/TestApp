package com.dan.testapp.preferences

import android.content.Context
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(name = "user_preferences")

class DataStore(context: Context) {
    private val dataStore = context.dataStore

    val token: Flow<String?> = dataStore.data.map { preferences ->
        preferences[KEY_TOKEN]
    }

    suspend fun setToken(token: String) {
        dataStore.edit { preferences ->
            preferences[KEY_TOKEN] = token
        }
    }

    companion object {
        private val KEY_TOKEN = stringPreferencesKey("key_token")
    }
}
