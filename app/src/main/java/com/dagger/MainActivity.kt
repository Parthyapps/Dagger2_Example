package com.dagger

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.dagger.di.DaggerStudentComponent
import com.dagger.di.StudentComponent
import com.dagger.model.StudentRepository
import javax.inject.Inject

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var editText: EditText
    private lateinit var textView: TextView
    private lateinit var saveBtn: Button
    private lateinit var getBtn: Button

    @Inject
    lateinit var studentRepository: StudentRepository


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referencing the EditText, TextView and Buttons
        editText = findViewById(R.id.inputField)
        textView = findViewById(R.id.outputField)
        saveBtn = findViewById(R.id.saveBtn)
        getBtn = findViewById(R.id.getBtn)

        // Setting onClickListener behavior on buttons
        saveBtn.setOnClickListener(this)
        getBtn.setOnClickListener(this)

        // Dagger initialization
        val appComponent: StudentComponent = DaggerStudentComponent.create()
        appComponent.connect(this)

    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.saveBtn -> {
                println(studentRepository.getStudents().name)
                println(studentRepository.getStudents().address)
            }
            R.id.getBtn -> {
                // Getting shared preferences data and setting it to textView
                textView.text = studentRepository.getStudents().name + studentRepository.getStudents().address
            }
        }
    }
}
