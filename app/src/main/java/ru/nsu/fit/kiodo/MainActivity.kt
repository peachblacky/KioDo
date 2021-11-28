package ru.nsu.fit.kiodo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.nsu.fit.kiodo.model.KioDoDatabase
import ru.nsu.fit.kiodo.model.data.exercise.Exercise

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Dispatchers.IO).launch {
            val db =
                Room.databaseBuilder(applicationContext, KioDoDatabase::class.java, "kiodo-db")
                    .build()
            db.exerciseDao().insertExercises(
                listOf(
                    Exercise(
                        "PushUp",
                        1,
                        1,
                        null,
                        null,
                        0
                    )
                )
            )
        }
    }

}