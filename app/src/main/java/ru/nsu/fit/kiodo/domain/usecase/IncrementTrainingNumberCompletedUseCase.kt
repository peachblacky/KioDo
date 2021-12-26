package ru.nsu.fit.kiodo.domain.usecase

import ru.nsu.fit.kiodo.domain.TrainingRepository

class IncrementTrainingNumberCompletedUseCase(
    private val repository: TrainingRepository
) {
    suspend operator fun invoke(name: String) {
        repository.incrementNumberCompleted(name)
    }
}