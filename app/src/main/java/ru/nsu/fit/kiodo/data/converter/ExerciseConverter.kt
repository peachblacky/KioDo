package ru.nsu.fit.kiodo.data.converter

import ru.nsu.fit.kiodo.data.model.exercise.Exercise
import ru.nsu.fit.kiodo.domain.model.ExerciseModel

class ExerciseConverter : Converter<Exercise, ExerciseModel> {
    override fun convertToO(from: Exercise): ExerciseModel =
        ExerciseModel(
            from.exerciseName,
            from.repeats,
            from.restBetweenRepeats,
            from.equipment,
            from.description,
            from.numberCompleted
        )

    override fun convertToI(from: ExerciseModel): Exercise =
        Exercise(
            from.exerciseName,
            from.repeats,
            from.restBetweenRepeats,
            from.equipment,
            from.description,
            from.numberCompleted
        )
}