package com.example.cm.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.cm.entities.Nota

@Dao
interface NotaDao {
    @Query("SELECT * from nota_tabela")
    fun getNotas(): LiveData<List<Nota>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(nota: Nota)

    @Query("DELETE FROM nota_tabela")
    suspend fun deleteAll()

    @Query("DELETE FROM nota_tabela where id == :idNota")
    suspend fun deleteNota(idNota: Int)

    @Query("UPDATE nota_tabela SET conteudo=:conteudo WHERE id == :idNota")
    suspend fun updateNota(idNota: Int, conteudo: String)

}