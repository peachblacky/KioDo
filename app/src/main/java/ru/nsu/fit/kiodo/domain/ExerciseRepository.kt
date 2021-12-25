package ru.nsu.fit.kiodo.domain

import ru.nsu.fit.kiodo.domain.model.ExerciseModel

interface ExerciseRepository {

    suspend fun saveExercise(exerciseModel: ExerciseModel)
}