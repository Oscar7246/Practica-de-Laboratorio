package com.naldana.dummydictionary.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.naldana.dummydictionary.data.model.Word

@Dao
interface  AntonymDao {
    @Query("SELECT w.term, w.definition, w.is_fav FROM antonym_table as at INNER JOIN WORD_TABLE as w ON w.term == at.antonym_term WHERE at.term = term")
    fun  getAllWords(): LiveData<List<Word>>

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertWord(word: Word)

    @Update
    suspend fun updateWord(word: Word)

    @Delete
    suspend fun deleteWord(word: Word)
}