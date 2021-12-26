package ru.nsu.fit.kiodo.domain.usecase

import ru.nsu.fit.kiodo.domain.model.ExerciseModel
import ru.nsu.fit.kiodo.domain.repository.ExerciseRepository

class GetFavoriteExerciseUseCase(
    private val repository: ExerciseRepository
) {

    suspend operator fun invoke(): ExerciseModel =
        repository.getFavoriteExercise()

}