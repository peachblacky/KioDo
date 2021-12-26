package ru.nsu.fit.kiodo.di

import androidx.room.Room
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.core.scope.get
import org.koin.dsl.module
import ru.nsu.fit.kiodo.data.KioDoDatabase
import ru.nsu.fit.kiodo.data.converter.Converter
import ru.nsu.fit.kiodo.data.converter.ExerciseConverter
import ru.nsu.fit.kiodo.data.converter.TrainingConverter
import ru.nsu.fit.kiodo.data.model.exercise.Exercise
import ru.nsu.fit.kiodo.data.model.training.TrainingWithExercises
import ru.nsu.fit.kiodo.data.repository.ExerciseRepositoryImpl
import ru.nsu.fit.kiodo.data.repository.TrainingRepositoryImpl
import ru.nsu.fit.kiodo.domain.repository.ExerciseRepository
import ru.nsu.fit.kiodo.domain.repository.TrainingRepository
import ru.nsu.fit.kiodo.domain.model.ExerciseModel
import ru.nsu.fit.kiodo.domain.model.TrainingModel
import ru.nsu.fit.kiodo.domain.usecase.*
import ru.nsu.fit.kiodo.presentation.viewmodel.*

val appModule = module {
    viewModel { TrainingListViewModel(get()) }
    viewModel { MainViewModel() }
    viewModel { TrainingViewModel(get(), get(), get()) }
    viewModel { TrainEditingSharedViewModel(get(), get(), get()) }
    viewModel { ExerciseEditingViewModel(get()) }
    viewModel { StatisticsViewModel(get(), get(), get()) }

    single<KioDoDatabase> {
        Room.databaseBuilder(
            androidContext(),
            KioDoDatabase::class.java,
            "KioDoDatabase"
        )
            .build()
    }
    factory { get<KioDoDatabase>(KioDoDatabase::class.java).trainingDao() }
    factory { get<KioDoDatabase>(KioDoDatabase::class.java).exerciseDao() }

    factory<TrainingRepository> { TrainingRepositoryImpl(get(), get(named("TrainingConverter"))) }
    factory<ExerciseRepository> { ExerciseRepositoryImpl(get(), get(named("ExerciseConverter"))) }

    factory<Converter<Exercise, ExerciseModel>>(named("ExerciseConverter")) { ExerciseConverter() }
    factory<Converter<TrainingWithExercises, TrainingModel>>(named("TrainingConverter")) { TrainingConverter() }


    factory { GetAllTrainingUseCase(get()) }
    factory { GetAllExercisesUseCase(get()) }
    factory { GetExercisesListUseCase(get()) }
    factory { IncrementExerciseNumberCompletedUseCase(get()) }
    factory { IncrementTrainingNumberCompletedUseCase(get()) }
    factory { SaveTrainingUseCase(get()) }
    factory { SaveExerciseUseCase(get()) }
    factory { CheckIfTrainingExistUseCase(get())}
    factory { GetFavoriteExerciseUseCase(get()) }
    factory { GetFavoriteTrainingUseCase(get()) }
    factory { GetTrainingsDoneNumberUseCase(get()) }
}