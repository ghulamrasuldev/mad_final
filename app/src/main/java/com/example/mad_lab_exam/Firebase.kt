package com.example.mad_lab_exam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_firebase.*

class Firebase : AppCompatActivity() {
    val TAG = "TEST TAG"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_firebase)
        _btn_sign_up.setOnClickListener{
            createAccount()
        }

        _btn_search.setOnClickListener{
            searchDataBase()
        }
    }

    private fun createAccount(){
        val etEmail = _sign_up_email.text.toString()
        val etUserName = _sign_up_username.text.toString()
        val etPassword = _sign_up_password.text.toString()
        if (etEmail.isNotEmpty() && etUserName.isNotEmpty()
            && etPassword.isNotEmpty()) {
            //Validation Rules
            //Checking Email
            auth.createUserWithEmailAndPassword(etEmail, etPassword)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "createUserWithEmail:success")
                        Log.d(TAG, "Saving data to FireStore")
                        saveToFirestore(
                            etEmail.trim(),
                            etUserName.trim(),
                            etNumber.trim()
                        )
                    } else {
                        _progressBar.visibility = View.INVISIBLE
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "createUserWithEmail:failure", task.exception)
                        Toast.makeText(
                            baseContext,
                            AUTHENTICATION_FAILED_ERROR + (task.getException()?.message
                                ?: ""),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

        } else {
            _progressBar.visibility = View.INVISIBLE
            Toast.makeText(this, EMPTY_FIELDS_ERROR, Toast.LENGTH_SHORT).show()
        }
    }

    fun searchDataBase(){

    }
}