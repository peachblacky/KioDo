package ru.nsu.fit.kiodo.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.nsu.fit.kiodo.domain.model.ExerciseModel
import ru.nsu.fit.kiodo.domain.usecase.GetAllExercisesUseCase
import ru.nsu.fit.kiodo.domain.usecase.SaveTrainingUseCase

class TrainEditingSharedViewModel(
    private val saveTrainingUseCase: SaveTrainingUseCase,
    private val getAllExercisesUseCase: GetAllExercisesUseCase
) : ViewModel() {

    var trainingName: String = ""
    var restBetweenExercises: Int = 0
    var restBetweenRepeats: Int = 0

    private val _selectedExercises: MutableLiveData<List<ExerciseModel>> =
        MutableLiveData(emptyList())
    val selectedExercises: LiveData<List<ExerciseModel>> get() = _selectedExercises

    private val _allExercises: MutableLiveData<List<ExerciseModel>> = MutableLiveData(emptyList())
    val allExercises: LiveData<List<ExerciseModel>> get() = _allExercises

    private val _isSaved = MutableLiveData(false)
    val isSaved: LiveData<Boolean> get() = _isSaved

    fun saveTraining() {
        viewModelScope.launch {
            saveTrainingUseCase(trainingName, restBetweenExercises, selectedExercises.value!!)
            _isSaved.value = true
        }
    }

    fun selectExercise(selectedExercise: ExerciseModel) {
        _selectedExercises.value =
            (selectedExercises.value ?: emptyList()) + selectedExercise
    }

    fun loadExercises() {
        viewModelScope.launch {
            _allExercises.value =
                getAllExercisesUseCase()!!.filter { !selectedExercises.value!!.contains(it) }
        }
    }

    fun clear() {
        _selectedExercises.value = emptyList()
        _allExercises.value = emptyList()
        _isSaved.value = false
    }

}