package ru.nsu.fit.kiodo.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.nsu.fit.kiodo.data.dao.ExerciseDao
import ru.nsu.fit.kiodo.data.model.exercise.Exercise
import ru.nsu.fit.kiodo.domain.ExerciseRepository
import ru.nsu.fit.kiodo.domain.model.ExerciseModel

class ExerciseRepositoryImpl(
    private val exerciseDao: ExerciseDao
) : ExerciseRepository {
    override suspend fun saveExercise(exerciseModel: ExerciseModel) = withContext(Dispatchers.IO) {
        val ex = Exercise(
            exerciseModel.exerciseName,
            exerciseModel.repeats,
            exerciseModel.restBetweenRepeats,
            exerciseModel.equipment,
            exerciseModel.description,
            exerciseModel.numberCompleted
        )
        exerciseDao.insertExercises(listOf(ex))
    }
}