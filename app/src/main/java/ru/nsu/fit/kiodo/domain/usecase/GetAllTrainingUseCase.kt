package ru.nsu.fit.kiodo.domain.usecase

import ru.nsu.fit.kiodo.domain.repository.TrainingRepository
import ru.nsu.fit.kiodo.domain.model.TrainingModel

class GetAllTrainingUseCase(
    private val repository: TrainingRepository
) {
    suspend operator fun invoke(): List<TrainingModel> =
        repository.getAllTrainings()
}