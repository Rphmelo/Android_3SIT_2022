package br.com.fiap.checkpointcorrecao.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


const val STUDENT_DATABASE_NAME = "student_database"

@Database(entities = [StudentInfo::class], version = 1)
abstract class StudentDatabase: RoomDatabase(){

    abstract fun studentDao(): StudentDAO

    companion object {
        @Volatile
        private var INSTANCE: StudentDatabase? = null

        fun getDatabase(context: Context): StudentDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    StudentDatabase::class.java,
                    STUDENT_DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}