package ru.nsu.fit.kiodo.model.data.training

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import ru.nsu.fit.kiodo.model.data.xref.TrainingExerciseXRef
import ru.nsu.fit.kiodo.model.data.exercise.Exercise

data class TrainingWithExercises(
    @Embedded val training : Training,
    @Relation(
        parentColumn = "trainingName",
        entityColumn = "exerciseName",
        associateBy = Junction(TrainingExerciseXRef::class)
    )
    val exercises : List<Exercise>
)
