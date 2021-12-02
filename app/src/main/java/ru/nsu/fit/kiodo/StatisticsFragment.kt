package ru.nsu.fit.kiodo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import ru.nsu.fit.kiodo.databinding.FragmentTrainingListBinding
import ru.nsu.fit.kiodo.ui.fragment.TrainingListFragment

//todo
class StatisticsFragment : Fragment() {

    private lateinit var binding: FragmentTrainingListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTrainingListBinding.inflate(inflater, container, false)



        return inflater.inflate(R.layout.fragment_statistics, container, false)
    }
}