package ru.nsu.fit.kiodo.domain.usecase

import ru.nsu.fit.kiodo.domain.repository.TrainingRepository
import ru.nsu.fit.kiodo.domain.model.ExerciseModel

class GetExercisesListUseCase(
    private val repository: TrainingRepository
) {
    suspend operator fun invoke(name: String): List<ExerciseModel> =
        repository.getTraining(name).exercises
}