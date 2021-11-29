package ru.nsu.fit.kiodo.model.dao

import androidx.room.*
import ru.nsu.fit.kiodo.model.data.exercise.Exercise
import ru.nsu.fit.kiodo.model.data.training.Training
import ru.nsu.fit.kiodo.model.data.exercise.ExerciseWithTrainings
import ru.nsu.fit.kiodo.model.data.xref.TrainingExerciseXRef

@Dao
interface ExerciseDao {

    @Transaction
    @Query("SELECT * FROM exercise")
    fun getAllExercises(): List<Exercise>

    @Query("SELECT * FROM exercise WHERE exerciseName LIKE :name LIMIT 1")
    fun findByName(name: String): Exercise

    @Transaction
    @Query("SELECT * FROM exercise WHERE exerciseName LIKE :name LIMIT 1")
    fun getExerciseWithTrainings(name: String): ExerciseWithTrainings

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTrainings(trainings: List<Training>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertExercises(exercises: List<Exercise>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertXRef(trainingExercisesXRefs: List<TrainingExerciseXRef>)

    @Transaction
    fun insertExercisesWithTrainings(exercisesWithTrainings: List<ExerciseWithTrainings>) {
        insertTrainings(exercisesWithTrainings.flatMap { it.trainings })
        insertExercises(exercisesWithTrainings.map { it.exercise })
        insertXRef(exercisesWithTrainings.flatMap { ewt ->
            ewt.trainings.map { training ->
                TrainingExerciseXRef(training.trainingName, ewt.exercise.exerciseName)
            }
        })
    }

    @Delete
    fun delete(exercise: Exercise)
}