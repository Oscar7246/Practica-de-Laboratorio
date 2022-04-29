package com.naldana.dummydictionary.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.naldana.dummydictionary.data.model.Word

@Dao
interface  SynonymDao {
    @Query("SELECT w.term, w.definition, w.is_fav FROM synonym_table as st INNER JOIN WORD_TABLE as w ON w.term == st.synonym_term WHERE st.term = term")
    fun  getAllWords(): LiveData<List<Word>>

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertWord(word: Word)

    @Update
    suspend fun updateWord(word: Word)

    @Delete
    suspend fun deleteWord(word: Word)
}