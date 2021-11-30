package ru.nsu.fit.kiodo.data.model.xref

import androidx.room.Entity

@Entity(primaryKeys = ["trainingName", "exerciseName"])
data class TrainingExerciseXRef(
    val trainingName : String,
    val exerciseName : String
)
