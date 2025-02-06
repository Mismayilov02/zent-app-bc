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
                Toast.makeText(this, "Please, fill all the fields.", Toast.LENGTH_LONG).show()
            }
            else if (!txtEmail.text.contains("@")){
                Toast.makeText(this, "Email is incorrect.", Toast.LENGTH_LONG).show()
            }
            else if (txtPassword.length()<8){
                Toast.makeText(this, "Password must be 8 symbols or more.", Toast.LENGTH_LONG).show()
            }
            else{
                Toast.makeText(this, "Success login", Toast.LENGTH_LONG).show()
            }
        }

    }
}