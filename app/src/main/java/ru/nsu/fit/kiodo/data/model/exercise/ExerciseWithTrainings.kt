package ru.nsu.fit.kiodo.data.model.exercise

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import ru.nsu.fit.kiodo.data.model.training.Training
import ru.nsu.fit.kiodo.data.model.xref.TrainingExerciseXRef

data class ExerciseWithTrainings(
    @Embedded val exercise : Exercise,
    @Relation(
        parentColumn = "exerciseName",
        entityColumn = "trainingName",
        associateBy = Junction(TrainingExerciseXRef::class)
    )
    val trainings : List<Training>
)
