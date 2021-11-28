package ru.nsu.fit.kiodo.model.dao

import androidx.room.*
import ru.nsu.fit.kiodo.model.data.exercise.Exercise
import ru.nsu.fit.kiodo.model.data.training.Training
import ru.nsu.fit.kiodo.model.data.exercise.ExerciseWithTrainings

@Dao
interface ExerciseDao {

    @Query("SELECT * FROM exercise")
    fun getAll(): List<Exercise>

    @Query("SELECT * FROM exercise WHERE exerciseName LIKE :name LIMIT 1")
    fun findByName(name: String): Exercise

    @Transaction
    @Query("SELECT * FROM exercise WHERE exerciseName LIKE :name LIMIT 1")
    fun getExerciseWithTrainings(name: String): ExerciseWithTrainings

    @Insert
    fun insertTrainings(trainings: List<Training>)

    @Insert
    fun insertExercises(exercises: List<Exercise>)

    @Transaction
    fun insertExercisesWithTrainings(exercisesWithTrainings: List<ExerciseWithTrainings>) {
        insertTrainings(exercisesWithTrainings.flatMap { it.trainings })
        insertExercises(exercisesWithTrainings.map { it.exercise })
    }

    @Delete
    fun delete(exercise: Exercise)
}