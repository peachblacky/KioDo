package ru.nsu.fit.kiodo.domain.model

data class TrainingModel(
    val trainingName: String,
    val restBetweenExercises: Int,
    val numberCompleted: Int,
    val exercises : List<ExerciseModel>
)