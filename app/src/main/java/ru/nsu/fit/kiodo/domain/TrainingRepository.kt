package ru.nsu.fit.kiodo.domain

import ru.nsu.fit.kiodo.domain.model.TrainingModel

interface TrainingRepository {

    suspend fun getTraining(name: String) : TrainingModel

    suspend fun saveTraining(trainingModel: TrainingModel)

    suspend fun addExerciseToTraining(trainingName: String, exerciseName: String)

    suspend fun getAllTrainings(): List<TrainingModel>

    suspend fun incrementNumberCompleted(name: String)

}