package ru.nsu.fit.kiodo.model

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.nsu.fit.kiodo.model.dao.ExerciseDao
import ru.nsu.fit.kiodo.model.dao.TrainingDao
import ru.nsu.fit.kiodo.model.data.exercise.Exercise
import ru.nsu.fit.kiodo.model.data.exercise.ExerciseWithTrainings
import ru.nsu.fit.kiodo.model.data.training.Training
import ru.nsu.fit.kiodo.model.data.training.TrainingWithExercises
import ru.nsu.fit.kiodo.model.data.xref.TrainingExerciseXRef

@Database(entities = [Exercise::class, ExerciseWithTrainings::class,
                        Training::class, TrainingWithExercises::class,
                        TrainingExerciseXRef::class],
            version = 1)
abstract class KioDoDatabase : RoomDatabase() {
    abstract fun exerciseDao() : ExerciseDao
    abstract fun trainingDao() : TrainingDao
}