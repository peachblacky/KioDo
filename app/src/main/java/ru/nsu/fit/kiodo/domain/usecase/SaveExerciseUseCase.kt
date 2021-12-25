package ru.nsu.fit.kiodo.domain.usecase

import ru.nsu.fit.kiodo.domain.ExerciseRepository
import ru.nsu.fit.kiodo.domain.model.ExerciseModel

class SaveExerciseUseCase(
    private val repository: ExerciseRepository
) {

    suspend operator fun invoke(exercise: ExerciseModel) {
        repository.saveExercise(exercise)
    }

}