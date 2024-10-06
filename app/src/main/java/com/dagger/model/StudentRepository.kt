package com.dagger.model

class StudentRepository {

    fun getStudents(): Student{
       return Student("nimo", 13, "UK")
    }
}