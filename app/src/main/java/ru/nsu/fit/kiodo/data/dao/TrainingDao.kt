package ru.nsu.fit.kiodo.data.dao

import androidx.room.*
import ru.nsu.fit.kiodo.data.model.exercise.Exercise
import ru.nsu.fit.kiodo.data.model.training.Training
import ru.nsu.fit.kiodo.data.model.training.TrainingWithExercises
import ru.nsu.fit.kiodo.data.model.xref.TrainingExerciseXRef

@Dao
interface TrainingDao {

    @Transaction
    @Query("SELECT * FROM training")
    fun getAllTrains(): List<TrainingWithExercises>

    @Query("SELECT * FROM training WHERE trainingName LIKE :name LIMIT 1")
    fun findByName(name: String): Training

    @Transaction
    @Query("SELECT * FROM training WHERE trainingName LIKE :name LIMIT 1")
    fun getTrainingWithExercises(name: String): TrainingWithExercises

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTrainings(trainings: List<Training>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertExercises(exercises: List<Exercise>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertXRef(trainingExercisesXRefs: List<TrainingExerciseXRef>)

    @Transaction
    fun insertTrainingsWithExercises(trainingWithExercises: List<TrainingWithExercises>) {
        insertExercises(trainingWithExercises.flatMap { it.exercises })
        insertTrainings(trainingWithExercises.map { it.training })
        insertXRef(trainingWithExercises.flatMap { twe ->
            twe.exercises.map { exercise ->
                TrainingExerciseXRef(twe.training.trainingName, exercise.exerciseName)
            }
        })
    }

    @Delete
    fun delete(training: Training)
}