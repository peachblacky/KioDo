package ru.nsu.fit.kiodo.domain.model

data class ExerciseModel(
    val exerciseName: String,
    val repeats: Int,
    val restBetweenRepeats: Int,
    val equipment: String?,
    val description: String?,
    val numberCompleted: Int
)
