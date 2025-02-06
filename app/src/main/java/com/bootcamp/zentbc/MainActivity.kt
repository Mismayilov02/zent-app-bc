package com.bootcamp.zentbc

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.collection.emptyLongSet

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnLogin = findViewById<Button>(R.id.btn_login)
        val txtPassword = findViewById<EditText>(R.id.edit_txt_password)
        val txtEmail = findViewById<EditText>(R.id.edit_txt_email)

        btnLogin.setOnClickListener { _ ->
            if (txtEmail.text.isEmpty() ||
                txtPassword.text.isEmpty()){
                showToast("Please fill in all fields.")
            } else if (!txtEmail.text.contains("@")){
                showToast("Invalid email.")
            } else if (txtPassword.length()<8){
                showToast("Password must be at least 8 characters.")
            } else{
                showToast("Login successful.")
            }
        }

    }
    fun showToast(message: String){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}