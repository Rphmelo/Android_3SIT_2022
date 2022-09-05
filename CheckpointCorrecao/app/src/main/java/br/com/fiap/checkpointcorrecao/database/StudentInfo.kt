package br.com.fiap.checkpointcorrecao.database

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

const val STUDENT_INFO_TABLE_NAME = "student"

@Entity(tableName = STUDENT_INFO_TABLE_NAME)
data class StudentInfo(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    @NonNull @ColumnInfo val name: String,
    @NonNull @ColumnInfo val rm: String,
    @NonNull @ColumnInfo val grade: String
)