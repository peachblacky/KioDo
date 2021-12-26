package ru.nsu.fit.kiodo.di

import androidx.room.Room
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.scope.get
import org.koin.dsl.module
import ru.nsu.fit.kiodo.data.KioDoDatabase
import ru.nsu.fit.kiodo.data.converter.Converter
import ru.nsu.fit.kiodo.data.converter.TrainingConverter
import ru.nsu.fit.kiodo.data.model.training.TrainingWithExercises
import ru.nsu.fit.kiodo.data.repository.ExerciseRepositoryImpl
import ru.nsu.fit.kiodo.data.repository.TrainingRepositoryImpl
import ru.nsu.fit.kiodo.domain.ExerciseRepository
import ru.nsu.fit.kiodo.domain.TrainingRepository
import ru.nsu.fit.kiodo.domain.model.TrainingModel
import ru.nsu.fit.kiodo.domain.usecase.*
import ru.nsu.fit.kiodo.presentation.viewmodel.ExerciseEditingViewModel
import ru.nsu.fit.kiodo.presentation.viewmodel.MainViewModel
import ru.nsu.fit.kiodo.presentation.viewmodel.TrainEditingSharedViewModel
import ru.nsu.fit.kiodo.presentation.viewmodel.TrainingListViewModel
import ru.nsu.fit.kiodo.ui.adapter.TrainingListAdapter
import ru.nsu.fit.kiodo.presentation.viewmodel.TrainingViewModel

val appModule = module {

    viewModel { TrainingListViewModel(get()) }
    viewModel { MainViewModel() }
    viewModel { TrainingViewModel(get(), get(), get()) }
    viewModel { TrainEditingSharedViewModel(get()) }
    viewModel { ExerciseEditingViewModel(get()) }

    single<KioDoDatabase> {
        Room.databaseBuilder(
            androidContext(),
            KioDoDatabase::class.java,
            "KioDoDatabase"
        )
            .build()
    }

    factory { GetExercisesListUseCase(get()) }
    factory { IncrementExerciseNumberCompletedUseCase(get()) }
    factory { IncrementTrainingNumberCompletedUseCase(get()) }
    factory { SaveTrainingUseCase(get()) }
    factory { SaveExerciseUseCase(get()) }

    factory { get<KioDoDatabase>(KioDoDatabase::class.java).trainingDao() }
    factory { get<KioDoDatabase>(KioDoDatabase::class.java).exerciseDao() }
    factory<Converter<TrainingWithExercises, TrainingModel>> { TrainingConverter() }
    factory<TrainingRepository> { TrainingRepositoryImpl(get(), get()) }
    factory<ExerciseRepository> { ExerciseRepositoryImpl(get()) }

    factory { GetAllTrainingUseCase(get()) }

    factory { TrainingListAdapter() }

}