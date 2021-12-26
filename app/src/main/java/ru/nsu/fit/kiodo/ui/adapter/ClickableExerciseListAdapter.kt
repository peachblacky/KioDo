package ru.nsu.fit.kiodo.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.nsu.fit.kiodo.databinding.ItemExerciseBinding
import ru.nsu.fit.kiodo.domain.model.ExerciseModel

class ClickableExerciseListAdapter(
    private val onClick: (ExerciseModel) -> Unit
) : RecyclerView.Adapter<ClickableExerciseItem>() {

    var exercises: List<ExerciseModel> = emptyList()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClickableExerciseItem {
        val binding =
            ItemExerciseBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ClickableExerciseItem(binding, onClick)
    }

    override fun onBindViewHolder(holder: ClickableExerciseItem, position: Int) {
        holder.bind(exercises[position])
    }

    override fun getItemCount() = exercises.size
}