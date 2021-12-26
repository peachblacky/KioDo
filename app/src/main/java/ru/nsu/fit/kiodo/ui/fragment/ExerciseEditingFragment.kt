package ru.nsu.fit.kiodo.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isGone
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.FragmentManager
import io.ktor.utils.io.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.nsu.fit.kiodo.R
import ru.nsu.fit.kiodo.presentation.viewmodel.ExerciseEditingViewModel
import ru.nsu.fit.kiodo.databinding.FragmentExerciseEditingBinding
import ru.nsu.fit.kiodo.presentation.viewmodel.TrainEditingSharedViewModel

class ExerciseEditingFragment : Fragment() {

    private var _binding: FragmentExerciseEditingBinding? = null
    private val binding: FragmentExerciseEditingBinding get() = _binding!!

    private val viewModel: ExerciseEditingViewModel by viewModel()
    private val sharedViewModel: TrainEditingSharedViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentExerciseEditingBinding.inflate(inflater, container, false)

        initTextListeners()
        initButtons()
        return binding.root
    }

    private fun initTextListeners() {
        with(binding) {
            exerciseNameEditText.addTextChangedListener {
                viewModel.exerciseName = exerciseNameEditText.text.toString()
            }
            exerciseRepeatsEditText.addTextChangedListener {
                viewModel.numberOfRepeats = exerciseRepeatsEditText.text.toString().toInt()
            }
            exerciseRestEditText.addTextChangedListener {
                viewModel.restBetweenRepeats = exerciseRestEditText.text.toString().toInt()
            }
            exerciseEquipmentEditText.addTextChangedListener {
                viewModel.equipment = exerciseEquipmentEditText.text.toString()
            }
            exerciseDescriptionEditText.addTextChangedListener {
                viewModel.description = exerciseDescriptionEditText.text.toString()
            }
        }
    }

    private fun initButtons() {
        with(binding) {
            topAppBar.setNavigationOnClickListener { navigateBack() }
            topAppBar.setOnMenuItemClickListener { onMenuItemClickListener(it) }
        }
    }

    private fun navigateBack() {
        parentFragmentManager.popBackStack()
    }

    private fun navigateToTrainEditing() {
        parentFragmentManager.popBackStack(TrainEditingFragment.backstack, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }

    private fun onMenuItemClickListener(menuItem: MenuItem): Boolean =
        when (menuItem.itemId) {
            R.id.done -> {
                saveExercise()
                true
            }
            else -> false
        }

    private fun saveExercise() {
        if (viewModel.saveExercise()) {
            sharedViewModel.selectExercise(viewModel.getExercise())
            binding.progressCircular.isGone = false
            viewModel.isSaved.observe(viewLifecycleOwner) {
                if (it) {
                    navigateToTrainEditing()
                } else {
                    showInvalidExerciseDataToast()
                }
            }
        } else {
            showInvalidExerciseDataToast()
        }
    }

    private fun showInvalidExerciseDataToast() =
        Toast.makeText(
            requireContext(),
            getString(R.string.invalid_exercise_data),
            Toast.LENGTH_SHORT
        ).show()
}