package com.naldana.dummydictionary.repository
import androidx.lifecycle.MutableLiveData
import com.naldana.dummydictionary.data.dao.AntonymDao
import com.naldana.dummydictionary.data.dao.SynonymDao
import com.naldana.dummydictionary.data.dao.WordDao
import com.naldana.dummydictionary.data.model.Word

class DictionaryRepository(
    private val worDoa: WordDao,
    val synonymDao: SynonymDao,
    val antonymDao: AntonymDao
){
    fun getAllWords() = worDoa.getAllWords()

    suspend fun addWord(word:)
}
