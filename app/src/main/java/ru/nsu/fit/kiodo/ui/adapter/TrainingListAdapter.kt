package ru.nsu.fit.kiodo.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.nsu.fit.kiodo.R
import ru.nsu.fit.kiodo.domain.model.Training

class TrainingListAdapter : RecyclerView.Adapter<TrainingViewHolder>() {

    var trainings = listOf<Training>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrainingViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.training_item, parent)

        return TrainingViewHolder(layout)
    }

    override fun onBindViewHolder(holder: TrainingViewHolder, position: Int) {
        
    }

    override fun getItemCount() = trainings.size
}