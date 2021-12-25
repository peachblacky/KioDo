package ru.nsu.fit.kiodo.ui.fragments

import android.os.Bundle
import android.view.*
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import ru.nsu.fit.kiodo.R
import ru.nsu.fit.kiodo.databinding.FragmentTrainingBinding

class TrainingFragment : Fragment() {

    private lateinit var binding: FragmentTrainingBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
//        val view : View = inflater.inflate(R.layout.fragment_training, container, false)
//        progressBar = view.findViewById(R.id.training_p_par)
        binding = FragmentTrainingBinding.inflate(inflater, container, false)

        binding.nextExerciseButton

        return binding.root
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.upper_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.back -> {
//                todo return back action
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}