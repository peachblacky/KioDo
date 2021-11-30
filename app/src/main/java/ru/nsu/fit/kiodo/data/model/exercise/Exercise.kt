package ru.nsu.fit.kiodo.data.model.exercise

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exercise")
data class Exercise(
    @PrimaryKey val exerciseName: String,
    @ColumnInfo val repeats: Int,
    @ColumnInfo val restBetweenRepeats: Int,
    @ColumnInfo val equipment: String?,
    @ColumnInfo val description: String?,
    @ColumnInfo val numberCompleted: Int
)