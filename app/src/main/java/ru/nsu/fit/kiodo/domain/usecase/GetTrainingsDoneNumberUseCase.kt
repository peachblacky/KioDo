package ru.nsu.fit.kiodo.domain.usecase

import ru.nsu.fit.kiodo.domain.repository.TrainingRepository

class GetTrainingsDoneNumberUseCase(
    private val repository: TrainingRepository
) {

    suspend operator fun invoke(): Int =
        repository.getAllTrainings().sumOf { it.numberCompleted }

}