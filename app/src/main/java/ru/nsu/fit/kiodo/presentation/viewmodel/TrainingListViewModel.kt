package ru.nsu.fit.kiodo.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.nsu.fit.kiodo.domain.model.TrainingModel

class TrainingListViewModel : ViewModel() {

    private val _trainings = MutableLiveData<List<TrainingModel>>()
    val training: LiveData<List<TrainingModel>> get() = _trainings

}