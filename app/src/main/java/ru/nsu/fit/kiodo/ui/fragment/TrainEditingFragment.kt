package ru.nsu.fit.kiodo.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import ru.nsu.fit.kiodo.R
import ru.nsu.fit.kiodo.databinding.FragmentTrainEditingBinding
import ru.nsu.fit.kiodo.presentation.viewmodel.TrainEditingSharedViewModel
import ru.nsu.fit.kiodo.ui.adapter.ExerciseListAdapter

class TrainEditingFragment : Fragment() {

    companion object {
        const val trainingNameKey = "TRAININGNAMEKEY"
    }

    private var _binding: FragmentTrainEditingBinding? = null
    private val binding: FragmentTrainEditingBinding get() = _binding!!

    private val adapter = ExerciseListAdapter()
    private val viewModel: TrainEditingSharedViewModel by sharedViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTrainEditingBinding.inflate(inflater, container, false)

        if (savedInstanceState == null) {
            arguments?.let {
                viewModel.trainingName = it.getString(TrainingFragment.trainingNameKey) ?: ""
            }
        } else {
            viewModel.trainingName =
                savedInstanceState.getString(TrainingFragment.trainingNameKey) ?: ""
        }
        with(binding) {
            if (viewModel.trainingName != "") {
                editTrainingName.setText(viewModel.trainingName)
                editTrainingName.isEnabled = false
                addExerciseButton.isClickable = true
            }
            trainEditingRecyclerView.adapter = adapter
        }


        initListeners();

        viewModel.exercises.observe(viewLifecycleOwner) { exercises ->
            adapter.exercises = exercises
        }

        return binding.root
    }

    private fun initListeners() {
        with(binding) {
            //todo navigation
//            addExerciseButton.
            editTrainingName.addTextChangedListener {
                if (editTrainingName.text.toString().isNotBlank()) {
                    addExerciseButton.isClickable = true
                }
            }
            topAppBar.setOnMenuItemClickListener { onMenuItemSelected(it) }
            topAppBar.setNavigationOnClickListener { parentFragmentManager.popBackStack() }
        }
    }

    private fun onMenuItemSelected(menuItem: MenuItem): Boolean =
        when (menuItem.itemId) {
            R.id.done -> {
                viewModel.saveTraining()
                true
            }
            else -> false
        }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(TrainingFragment.trainingNameKey, viewModel.trainingName)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null;
    }
}