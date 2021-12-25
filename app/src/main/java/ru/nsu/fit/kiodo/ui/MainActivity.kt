package ru.nsu.fit.kiodo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.nsu.fit.kiodo.databinding.ActivityMainBinding
import ru.nsu.fit.kiodo.presentation.viewmodel.MainViewModel
import ru.nsu.fit.kiodo.ui.fragment.TrainingListFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        supportFragmentManager.beginTransaction()
            .replace(binding.mainContainer.id, TrainingListFragment())
            .commit()
    }
}