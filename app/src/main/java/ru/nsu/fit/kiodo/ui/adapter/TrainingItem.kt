package ru.nsu.fit.kiodo.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import ru.nsu.fit.kiodo.databinding.ItemTrainingBinding
import ru.nsu.fit.kiodo.domain.model.TrainingModel

class TrainingItem(
    private val binding: ItemTrainingBinding,
    private val onClick: (String) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(training: TrainingModel) {
        with(binding) {
            trainingName.text = training.trainingName
            countOfExercises.text = training.exercises.size.toString()
            card.setOnClickListener { onClick(training.trainingName) }
        }
    }

}