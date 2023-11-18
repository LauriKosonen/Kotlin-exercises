package com.example.e08employeesapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import org.json.JSONObject

class EmployeeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee)

        val bundle: Bundle? = intent.extras
        if (bundle != null) {
            val employeeString = bundle.getString("employee")
            if (employeeString != null) {
                val employee = JSONObject(employeeString)
                val name = "${employee["firstName"]} ${employee["lastName"]}"
                val title = employee.optString("title", "")
                val email = employee.optString("email", "")
                val phone = employee.optString("phone", "")
                val department = employee.optString("department", "")
                val imageUrl = employee.optString("image", "")

                findViewById<TextView>(R.id.nameTextView).text = name
                findViewById<TextView>(R.id.titleTextView).text = title
                findViewById<TextView>(R.id.emailTextView).text = email
                findViewById<TextView>(R.id.phoneTextView).text = phone
                findViewById<TextView>(R.id.departmentTextView).text = department

                val imageView = findViewById<ImageView>(R.id.imageView)
                Glide.with(this)
                    .load(imageUrl)
                    .into(imageView)
            }
        }
    }
}