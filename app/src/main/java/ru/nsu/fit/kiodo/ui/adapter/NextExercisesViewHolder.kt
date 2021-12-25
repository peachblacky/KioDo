package ru.nsu.fit.kiodo.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import ru.nsu.fit.kiodo.databinding.ExerciseItemBinding
import ru.nsu.fit.kiodo.domain.model.ExerciseModel

class NextExercisesViewHolder(
    private val binding: ExerciseItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(exercise: ExerciseModel) {
        with(binding) {
            exerciseNameTextView.text = exercise.exerciseName
        }
    }
}