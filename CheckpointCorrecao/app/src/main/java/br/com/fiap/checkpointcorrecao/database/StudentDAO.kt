package br.com.fiap.checkpointcorrecao.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StudentDAO {
    @Query("SELECT * FROM $STUDENT_INFO_TABLE_NAME ORDER BY name ASC")
    fun getAll(): List<StudentInfo>

    @Insert
    fun insert(vararg studentInfo: StudentInfo)

}