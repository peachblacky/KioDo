package ru.nsu.fit.kiodo.domain.usecase

import ru.nsu.fit.kiodo.domain.repository.ExerciseRepository

class IncrementExerciseNumberCompletedUseCase(
    private val repository: ExerciseRepository
) {
    suspend operator fun invoke(name: String) {
        repository.incrementNumberCompleted(name)
    }
}