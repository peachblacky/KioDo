package ru.nsu.fit.kiodo.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.nsu.fit.kiodo.databinding.FragmentTrainingListBinding


class TrainingListFragment : Fragment() {

    private lateinit var binding: FragmentTrainingListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTrainingListBinding.inflate(inflater, container, false)

        return binding.root
    }
}