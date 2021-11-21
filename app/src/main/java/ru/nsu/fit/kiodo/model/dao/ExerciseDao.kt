package ru.nsu.fit.kiodo.model.dao

import androidx.room.*
import ru.nsu.fit.kiodo.model.data.exercise.Exercise
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
    fun saveAll(vararg exercises: Exercise)

    @Delete
    fun delete(exercise: Exercise)
}