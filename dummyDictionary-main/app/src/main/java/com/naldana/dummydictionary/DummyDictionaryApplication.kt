package com.naldana.dummydictionary

import android.app.Application
import com.naldana.dummydictionary.data.DummyDictionaryDatabase

class DummyDictionaryApplication: Application() {
    val dataBase by lazy {
        DummyDictionaryDatabase.getInstance(this)
    }
}