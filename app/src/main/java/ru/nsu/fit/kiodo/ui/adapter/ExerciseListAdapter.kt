package ru.nsu.fit.kiodo.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.nsu.fit.kiodo.databinding.ExerciseItemBinding
import ru.nsu.fit.kiodo.domain.model.ExerciseModel

class ExerciseListAdapter : RecyclerView.Adapter<ExerciseItemViewHolder>() {

    var exercises: List<ExerciseModel> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseItemViewHolder {
        val binding = ExerciseItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ExerciseItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ExerciseItemViewHolder, position: Int) {
        val exercise = exercises[position]

        holder.bind(exercise)
    }

    override fun getItemCount(): Int = exercises.size
}