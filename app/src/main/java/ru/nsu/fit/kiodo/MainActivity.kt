package ru.nsu.fit.kiodo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.nsu.fit.kiodo.model.KioDoDatabase
import ru.nsu.fit.kiodo.model.data.exercise.Exercise
import ru.nsu.fit.kiodo.model.data.training.Training
import ru.nsu.fit.kiodo.model.data.training.TrainingWithExercises

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //TESTING SECTION
        CoroutineScope(Dispatchers.IO).launch {
            val db =
                Room.databaseBuilder(applicationContext, KioDoDatabase::class.java, "kiodo-db")
                    .build()

            val exercises1 = listOf(
                Exercise(
                    "PushUp",
                    1,
                    1,
                    "Floor",
                    "One Exercise",
                    0
                ),
                Exercise(
                    "PullUp",
                    5,
                    1,
                    "Bar",
                    "Two Exercise",
                    0
                ),
                Exercise(
                    "Squat",
                    9,
                    1,
                    "Floor",
                    "Three Exercise",
                    0
                ),
                Exercise(
                    "JumpingJack",
                    30,
                    1,
                    "Ass",
                    "Four Exercise",
                    0
                )
            )

            val exercises2 = listOf(
                Exercise(
                    "Running",
                    5,
                    1,
                    "Bar",
                    "Two Exercise",
                    0
                ),
                Exercise(
                    "JumpingJack",
                    30,
                    1,
                    "Ass",
                    "Four Exercise",
                    0
                )
            )

            val training1 = Training(
                    "First train",
                    5,
                    0
                )
            val training2 = Training(
                "Second train",
                7,
                0
            )

            db.trainingDao().insertTrainingsWithExercises(
                listOf(
                    TrainingWithExercises(
                        training1,
                        exercises1
                    ),
                    TrainingWithExercises(
                        training2,
                        exercises2
                    )
                )
            )
            val foundTrainWithExes = db.trainingDao().getAllTrains()
            Log.d("train_find_1", foundTrainWithExes.toString())
        }
        //END OF TESTING SECTION
    }

}