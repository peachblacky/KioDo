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
import ru.nsu.fit.kiodo.data.repository.TrainingRepositoryImpl
import ru.nsu.fit.kiodo.domain.TrainingRepository
import ru.nsu.fit.kiodo.domain.model.TrainingModel
import ru.nsu.fit.kiodo.domain.usecase.GetAllTrainingUseCase
import ru.nsu.fit.kiodo.domain.usecase.GetExercisesListUseCase
import ru.nsu.fit.kiodo.presentation.viewmodel.MainViewModel
import ru.nsu.fit.kiodo.presentation.viewmodel.TrainingViewModel

val appModule = module {

    viewModel { MainViewModel() }
    viewModel { TrainingViewModel(get()) }

    single<KioDoDatabase> {
        Room.databaseBuilder(
            androidContext(),
            KioDoDatabase::class.java,
            "Kio"
        )
            .build()
    }

    factory {GetExercisesListUseCase(get())}

    single { get<KioDoDatabase>(KioDoDatabase::class.java).trainingDao() }
    factory<Converter<TrainingWithExercises, TrainingModel>> { TrainingConverter() }
    single<TrainingRepository> { TrainingRepositoryImpl(get(), get()) }

    factory { GetAllTrainingUseCase(get()) }

}