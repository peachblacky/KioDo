package ru.nsu.fit.kiodo.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.content.ClipData.Item
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.nsu.fit.kiodo.domain.model.ExerciseModel
import ru.nsu.fit.kiodo.domain.usecase.SaveTrainingUseCase

class TrainEditingSharedViewModel(
    private val saveTrainingUseCase: SaveTrainingUseCase
) : ViewModel() {
    val selected = MutableLiveData<Item>()

    fun select(item: Item) {
        selected.value = item
    }

    var trainingName: String = ""
    var restBetweenExercises : Int = 0
    var restBetweenRepeats : Int = 0
    private val _exercises: MutableLiveData<List<ExerciseModel>> = MutableLiveData()
    val exercises: LiveData<List<ExerciseModel>> get() = _exercises

    fun saveTraining() {
        viewModelScope.launch {
            saveTrainingUseCase(trainingName, restBetweenExercises, exercises.value!!)
        }
    }
}