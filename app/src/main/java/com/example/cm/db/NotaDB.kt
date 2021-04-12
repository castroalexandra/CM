package com.example.cm.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.cm.dao.NotaDao
import com.example.cm.entities.Nota
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = arrayOf(Nota::class), version = 1, exportSchema = false)
public abstract class NotaDB : RoomDatabase() {

        abstract fun notaDao(): NotaDao

        private class WordDatabaseCallback(
            private val scope: CoroutineScope
        ) : RoomDatabase.Callback(){
            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                INSTANCE?.let{ database ->
                    scope.launch {
                        var notaDao = database.notaDao()
                    }

                }
            }
        }

        companion object {
            // Singleton prevents multiple instances of database opening at the
            // same time.
            @Volatile
            private var INSTANCE: NotaDB? = null

            fun getDatabase(context: Context, scope:CoroutineScope): NotaDB {
                // if the INSTANCE is not null, then return it,
                // if it is, then create the database
                val tempInstance = INSTANCE
                if (tempInstance != null) {
                    return tempInstance
                }
                synchronized(this){
                    val instance = Room.databaseBuilder(
                        context.applicationContext,
                        NotaDB::class.java,
                        "notas_database"
                    )
                        .addCallback(WordDatabaseCallback(scope))
                        .build()

                    INSTANCE = instance
                    return instance
            }
        }
    }
}