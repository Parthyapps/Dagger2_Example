package com.dagger.di

import com.dagger.MainActivity
import com.dagger.model.StudentRepository
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class StudentModule {

    @Provides
    @Singleton
    fun provideStudentRepository(): StudentRepository{
        return StudentRepository()
    }

}

@Singleton
@Component(modules = [StudentModule::class])
interface StudentComponent{
    fun connect(activity: MainActivity)
}