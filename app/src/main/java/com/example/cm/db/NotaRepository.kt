package com.example.cm.db

import androidx.lifecycle.LiveData
import com.example.cm.dao.NotaDao
import com.example.cm.entities.Nota

class NotaRepository(private val notaDao: NotaDao) {

    // Room executes all queries on a separate thread.
    // Observed Flow will notify the observer when the data has changed.
    val allNotas: LiveData<List<Nota>> = notaDao.getNotas()

    // By default Room runs suspend queries off the main thread, therefore, we don't need to
    // implement anything else to ensure we're not doing long running database work
    // off the main thread.

    suspend fun insert(nota: Nota) {
        notaDao.insert(nota)
    }
    suspend fun deleteNota(idNota: Int) {
        notaDao.deleteNota(idNota)
    }
    suspend fun updateNota(idNota: Int, conteudo: String) {
        notaDao.updateNota(idNota, conteudo)
    }
}