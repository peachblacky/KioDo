package ru.nsu.fit.kiodo.model.dao

import androidx.room.*
import ru.nsu.fit.kiodo.model.data.exercise.Exercise
import ru.nsu.fit.kiodo.model.data.exercise.ExerciseWithTrainings
import ru.nsu.fit.kiodo.model.data.training.Training
import ru.nsu.fit.kiodo.model.data.training.TrainingWithExercises

@Dao
interface TrainingDao {

    @Query("SELECT * FROM training")
    fun getAll(): List<Training>

    @Query("SELECT * FROM training WHERE trainingName LIKE :name LIMIT 1")
    fun findByName(name: String): Training

    @Transaction
    @Query("SELECT * FROM training WHERE trainingName LIKE :name LIMIT 1")
    fun getTrainingWithExercises(name: String): TrainingWithExercises

    @Insert
    fun insertTrainings(trainings: List<Training>)

    @Insert
    fun insertExercises(exercises: List<Exercise>)

    @Transaction
    fun insertExercisesWithTrainings(trainingWithExercises: List<TrainingWithExercises>) {
        insertExercises(trainingWithExercises.flatMap { it.exercises })
        insertTrainings(trainingWithExercises.map { it.training })
    }

    @Delete
    fun delete(training: Training)
}