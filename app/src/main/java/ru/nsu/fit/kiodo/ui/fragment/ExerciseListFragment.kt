package ru.nsu.fit.kiodo.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import ru.nsu.fit.kiodo.R
import ru.nsu.fit.kiodo.databinding.FragmentExerciseListBinding
import ru.nsu.fit.kiodo.domain.model.ExerciseModel
import ru.nsu.fit.kiodo.presentation.viewmodel.TrainEditingSharedViewModel
import ru.nsu.fit.kiodo.ui.adapter.ClickableExerciseListAdapter


class ExerciseListFragment : Fragment() {


    private var _binding: FragmentExerciseListBinding? = null
    private val binding: FragmentExerciseListBinding get() = _binding!!

    private val adapter = ClickableExerciseListAdapter { addExerciseToTraining(it) }
    private val viewModel: TrainEditingSharedViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentExerciseListBinding.inflate(inflater, container, false)

        with(binding) {
            exerciseRecyclerView.adapter = adapter
        }

        initListeners()

        viewModel.loadExercises()
        viewModel.allExercises.observe(viewLifecycleOwner) { allExercises ->
            adapter.exercises = allExercises
        }

        return binding.root
    }

    private fun initListeners() {
        with(binding) {
            topAppBar.setNavigationOnClickListener { parentFragmentManager.popBackStack() }
            newExerciseButton.setOnClickListener { navigateToExerciseEditing() }
        }
    }

    private fun navigateToExerciseEditing() {
        parentFragmentManager.beginTransaction()
            .replace(R.id.main_container, ExerciseEditingFragment())
            .addToBackStack(TrainEditingFragment.backstack)
            .commit()
    }

    private fun addExerciseToTraining(exercise: ExerciseModel) {
        viewModel.selectExercise(exercise)
        parentFragmentManager.popBackStack()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}