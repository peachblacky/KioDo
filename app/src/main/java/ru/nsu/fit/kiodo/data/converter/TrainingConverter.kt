package ru.nsu.fit.kiodo.data.converter

import ru.nsu.fit.kiodo.data.model.exercise.Exercise
import ru.nsu.fit.kiodo.data.model.training.Training
import ru.nsu.fit.kiodo.data.model.training.TrainingWithExercises
import ru.nsu.fit.kiodo.domain.model.ExerciseModel
import ru.nsu.fit.kiodo.domain.model.TrainingModel

class TrainingConverter : Converter<TrainingWithExercises, TrainingModel> {

    override fun convertToO(from: TrainingWithExercises): TrainingModel =
        TrainingModel(
            from.training.trainingName,
            from.training.restBetweenExercises,
            from.training.numberCompleted,
            from.exercises.map { exerciseModel ->
                ExerciseModel(
                    exerciseModel.exerciseName,
                    exerciseModel.repeats,
                    exerciseModel.restBetweenRepeats,
                    exerciseModel.equipment,
                    exerciseModel.description,
                    exerciseModel.numberCompleted
                )
            }
        )

    override fun convertToI(from: TrainingModel): TrainingWithExercises =
        TrainingWithExercises(
            Training(
                from.trainingName,
                from.restBetweenExercises,
                from.numberCompleted
            ),
            from.exercises.map {
                Exercise(
                    it.exerciseName,
                    it.repeats,
                    it.restBetweenRepeats,
                    it.equipment,
                    it.description,
                    it.numberCompleted
                )
            }
        )
}