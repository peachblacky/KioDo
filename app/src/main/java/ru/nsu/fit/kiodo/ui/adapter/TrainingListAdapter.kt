package ru.nsu.fit.kiodo.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.nsu.fit.kiodo.R
import ru.nsu.fit.kiodo.databinding.TrainingItemBinding
import ru.nsu.fit.kiodo.domain.model.TrainingModel

class TrainingListAdapter : RecyclerView.Adapter<TrainingViewHolder>() {

    var trainings = listOf<TrainingModel>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrainingViewHolder {
        val itemBinding =
            TrainingItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return TrainingViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: TrainingViewHolder, position: Int) {
        holder.bind(trainings[position])
    }

    override fun getItemCount() = trainings.size
}