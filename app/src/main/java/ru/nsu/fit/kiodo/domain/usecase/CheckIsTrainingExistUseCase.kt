package ru.nsu.fit.kiodo.domain.usecase

import ru.nsu.fit.kiodo.domain.repository.TrainingRepository

class CheckIsTrainingExistUseCase(
    private val repository: TrainingRepository
) {
    suspend operator fun invoke(name: String) = repository.hasTraining(name)
}