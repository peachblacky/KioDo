package ru.nsu.fit.kiodo.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.koin.core.component.KoinComponent
import ru.nsu.fit.kiodo.databinding.ExerciseItemBinding
import ru.nsu.fit.kiodo.domain.model.ExerciseModel

class NextExercisesAdapter : RecyclerView.Adapter<NextExercisesViewHolder>(), KoinComponent {

    var exercises: List<ExerciseModel> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NextExercisesViewHolder {
        val binding = ExerciseItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return NextExercisesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NextExercisesViewHolder, position: Int) {
        val exercise = exercises[position]

        holder.bind(exercise)
    }

    override fun getItemCount(): Int = exercises.size
}