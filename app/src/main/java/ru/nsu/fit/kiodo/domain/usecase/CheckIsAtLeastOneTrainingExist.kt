package ru.nsu.fit.kiodo.domain.usecase

import ru.nsu.fit.kiodo.domain.repository.TrainingRepository

class CheckIsAtLeastOneTrainingExist(
    private val repository: TrainingRepository
) {

    suspend operator fun invoke(): Boolean =
        repository.hasAtLeastOneTraining()

}