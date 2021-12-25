package ru.nsu.fit.kiodo.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import ru.nsu.fit.kiodo.databinding.TrainingItemBinding
import ru.nsu.fit.kiodo.domain.model.TrainingModel

class TrainingViewHolder(
    private val binding: TrainingItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(training: TrainingModel) {
        with(binding) {
            trainingName.text = training.trainingName
            countOfExercises.text = training.exercises.size.toString()
        }
    }

}