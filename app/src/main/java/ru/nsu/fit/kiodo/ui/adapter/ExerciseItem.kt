package ru.nsu.fit.kiodo.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import ru.nsu.fit.kiodo.databinding.ItemExerciseBinding

import ru.nsu.fit.kiodo.domain.model.ExerciseModel

class ExerciseItem(
    private val binding: ItemExerciseBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(exercise: ExerciseModel) {
        with(binding) {
            exerciseName.text = exercise.exerciseName
            equipmentList.text = exercise.equipment
        }
    }
}