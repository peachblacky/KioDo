package ru.nsu.fit.kiodo.domain.usecase

import ru.nsu.fit.kiodo.domain.ExerciseRepository

class GetAllExercisesUseCase(
    private val repository: ExerciseRepository
) {

    suspend operator fun invoke() =
        repository.getAllExercises()

}