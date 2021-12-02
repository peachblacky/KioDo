package ru.nsu.fit.kiodo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import ru.nsu.fit.kiodo.databinding.ActivityMainBinding
import ru.nsu.fit.kiodo.ui.fragment.TrainingListFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigationView.setOnItemSelectedListener { handleItemSelected(it) }

        supportFragmentManager.beginTransaction()
            .replace(binding.container.id, TrainingListFragment())
            .commit()
    }

    private fun handleItemSelected(item: MenuItem): Boolean =
        when (item.itemId) {
            R.id.trainings -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, TrainingListFragment())
                    .commit()
                true
            }
            R.id.statistics -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, StatisticsFragment())
                    .commit()
                true
            }
            else -> false
        }
}