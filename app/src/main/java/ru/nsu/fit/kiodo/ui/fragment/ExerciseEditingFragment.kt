package ru.nsu.fit.kiodo.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.koin.android.ext.android.inject
import ru.nsu.fit.kiodo.presentation.viewmodel.ExerciseEditingViewModel
import ru.nsu.fit.kiodo.databinding.FragmentExerciseEditingBinding

class ExerciseEditingFragment : Fragment() {

    private var _binding: FragmentExerciseEditingBinding? = null
    private val binding: FragmentExerciseEditingBinding get() = _binding!!

    private val viewModel: ExerciseEditingViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentExerciseEditingBinding.inflate(inflater, container, false)

        return binding.root
    }

}