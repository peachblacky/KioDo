package ru.nsu.fit.kiodo.model.data.exercise

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import ru.nsu.fit.kiodo.model.data.training.Training
import ru.nsu.fit.kiodo.model.data.xref.TrainingExerciseXRef

data class ExerciseWithTrainings(
    @Embedded val exercise : Exercise,
    @Relation(
        parentColumn = "exerciseName",
        entityColumn = "trainingName",
        associateBy = Junction(TrainingExerciseXRef::class)
    )
    val exercises : List<Training>
)
