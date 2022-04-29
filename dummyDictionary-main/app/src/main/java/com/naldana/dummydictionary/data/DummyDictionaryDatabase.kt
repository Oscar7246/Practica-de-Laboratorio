package com.naldana.dummydictionary.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.naldana.dummydictionary.data.dao.AntonymDao
import com.naldana.dummydictionary.data.dao.SynonymDao
import com.naldana.dummydictionary.data.dao.WordDao
import com.naldana.dummydictionary.data.model.Antonym
import com.naldana.dummydictionary.data.model.Synonym
import com.naldana.dummydictionary.data.model.Word
import java.security.AccessControlContext

@Database(
    entities = [Word::class, Antonym::class, Synonym::class],
    version = 1,
    exportSchema = false
)
abstract class DummyDictionaryDatabase :  RoomDatabase() {
    abstract  fun  WordDao(): WordDao
    abstract  fun SynonymDao():SynonymDao
    abstract fun AntonymDao():AntonymDao

    companion object {
        @Volatile
        private var INSTANCE: DummyDictionaryDatabase? = null

        fun getInstance(context: Context): DummyDictionaryDatabase{
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DummyDictionaryDatabase::class.java,
                    "dic_database"
                ).build()
                INSTANCE = instance
                //return instance
                instance
            }
        }
    }

}

