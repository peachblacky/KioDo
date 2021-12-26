package ru.nsu.fit.kiodo.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.nsu.fit.kiodo.R
import ru.nsu.fit.kiodo.databinding.FragmentTrainingListBinding
import ru.nsu.fit.kiodo.presentation.viewmodel.TrainingListViewModel
import ru.nsu.fit.kiodo.ui.adapter.TrainingListAdapter


class TrainingListFragment : Fragment() {

    private var _binding: FragmentTrainingListBinding? = null
    private val binding: FragmentTrainingListBinding get() = _binding!!
    private val adapter = TrainingListAdapter { navigateToTraining(it) }

    private val viewModel: TrainingListViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTrainingListBinding.inflate(inflater, container, false)

        initListeners()

        return binding.root
    }

    private fun initListeners() {
        with(binding) {
            trainingRecyclerView.adapter = adapter
            newTrainingButton.setOnClickListener { navigateToTrainEditing() }
            topAppBar.setOnMenuItemClickListener { onMenuItemSelected(it) }
        }
        viewModel.trainings.observe(viewLifecycleOwner) { trainings ->
            binding.emptyTrainingText.isGone = trainings.isNotEmpty()
            adapter.trainings = trainings
        }
        viewModel.getAllTrainings()
    }

    private fun navigateToTrainEditing(trainingName: String? = null) {
        val bundle = Bundle()
        bundle.putString(TrainEditingFragment.trainingNameKey, trainingName)
        parentFragmentManager.beginTransaction()
            .replace(R.id.main_container, TrainEditingFragment::class.java, bundle)
            .addToBackStack(null)
            .commit()
    }

    private fun navigateToStatisticsScreen() {
        parentFragmentManager.beginTransaction()
            .replace(R.id.main_container, StatisticsFragment())
            .addToBackStack(null)
            .commit()
    }

    private fun onMenuItemSelected(menuItem: MenuItem): Boolean =
        when (menuItem.itemId) {
            R.id.profile -> {
                navigateToStatisticsScreen()
                true
            }
            else -> false
        }

    private fun navigateToTraining(trainingName: String) {
        val bundle = Bundle()
        bundle.putString(TrainingFragment.trainingNameKey, trainingName)
        parentFragmentManager.beginTransaction()
            .replace(R.id.main_container, TrainingFragment::class.java, bundle)
            .addToBackStack(null)
            .commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}