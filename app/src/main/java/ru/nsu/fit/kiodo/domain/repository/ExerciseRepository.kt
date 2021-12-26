package ru.nsu.fit.kiodo.domain.repository

import ru.nsu.fit.kiodo.domain.model.ExerciseModel

interface ExerciseRepository {

    suspend fun saveExercise(exerciseModel: ExerciseModel)

    suspend fun incrementNumberCompleted(name: String)

    suspend fun getAllExercises(): List<ExerciseModel>

    suspend fun getFavoriteExercise(): ExerciseModel
}