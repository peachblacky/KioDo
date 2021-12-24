package ru.nsu.fit.kiodo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.nsu.fit.kiodo.databinding.ActivityMainBinding
import ru.nsu.fit.kiodo.ui.fragment.TrainingListFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .replace(binding.container.id, TrainingListFragment())
            .commit()
    }
}