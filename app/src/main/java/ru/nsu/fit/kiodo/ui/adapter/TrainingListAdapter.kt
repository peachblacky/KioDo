package ru.nsu.fit.kiodo.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.nsu.fit.kiodo.databinding.ItemTrainingBinding
import ru.nsu.fit.kiodo.domain.model.TrainingModel

class TrainingListAdapter(
    private val onClick: (String) -> Unit
) : RecyclerView.Adapter<TrainingItem>() {

    var trainings = listOf<TrainingModel>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrainingItem {
        val itemBinding =
            ItemTrainingBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return TrainingItem(itemBinding, onClick)
    }

    override fun onBindViewHolder(holder: TrainingItem, position: Int) {
        holder.bind(trainings[position])
    }

    override fun getItemCount() = trainings.size
}