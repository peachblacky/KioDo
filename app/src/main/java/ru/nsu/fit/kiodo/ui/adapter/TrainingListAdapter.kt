package ru.nsu.fit.kiodo.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.nsu.fit.kiodo.R
import ru.nsu.fit.kiodo.domain.model.TrainingModel

class TrainingListAdapter : RecyclerView.Adapter<NextExercisesViewHolder>() {

    var trainings = listOf<TrainingModel>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NextExercisesViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.training_item, parent)

        return NextExercisesViewHolder(layout)
    }

    override fun onBindViewHolder(holder: NextExercisesViewHolder, position: Int) {
        
    }

    override fun getItemCount() = trainings.size
}