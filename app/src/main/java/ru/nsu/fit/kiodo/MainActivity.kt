package ru.nsu.fit.kiodo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.nsu.fit.kiodo.databinding.ActivityMainBinding

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