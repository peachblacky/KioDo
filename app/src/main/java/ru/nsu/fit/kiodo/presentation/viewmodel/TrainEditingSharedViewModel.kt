package ru.nsu.fit.kiodo.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.nsu.fit.kiodo.domain.model.ExerciseModel
import ru.nsu.fit.kiodo.domain.usecase.SaveTrainingUseCase

class TrainEditingSharedViewModel(
    private val saveTrainingUseCase: SaveTrainingUseCase
) : ViewModel() {

    var trainingName: String = ""
    var restBetweenExercises: Int = 0
    var restBetweenRepeats: Int = 0

    private val _selectedExercises: MutableLiveData<List<ExerciseModel>> = MutableLiveData()
    val selectedExercises: LiveData<List<ExerciseModel>> get() = _selectedExercises

    private val _allExercises: MutableLiveData<List<ExerciseModel>> = MutableLiveData()
    val allexercises: LiveData<List<ExerciseModel>> get() = _allExercises

    fun saveTraining() {
        viewModelScope.launch {
            saveTrainingUseCase(trainingName, restBetweenExercises, selectedExercises.value!!)
        }
    }

    fun selectExercise(selectedExercise: ExerciseModel) {
        _selectedExercises.value =
            selectedExercises.value ?: emptyList<ExerciseModel>() + selectedExercise
    }
}