package com.example.mad_lab_exam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_firebase.*
import java.time.LocalDate

class Firebase : AppCompatActivity() {
    val TAG = "TEST TAG"
    private var auth: FirebaseAuth = Firebase.auth
    val db = Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_firebase)
        _btn_sign_up.setOnClickListener{
            createAccount()
        }

        _btn_search.setOnClickListener{
            searchDataBase(_username_search.text.toString())
        }
    }

    private fun createAccount(){
        val etEmail = _sign_up_email.text.toString()
        val etUserName = _sign_up_username.text.toString()
        val etPassword = _sign_up_password.text.toString()
        if (etEmail.isNotEmpty() && etUserName.isNotEmpty()
            && etPassword.isNotEmpty()) {
            //Validation Rules
            auth.createUserWithEmailAndPassword(etEmail, etPassword)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(
                            baseContext,
                            "Account Created Successfully! You can now search username" + (task.getException()?.message
                                ?: ""),
                            Toast.LENGTH_SHORT
                        ).show()
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "createUserWithEmail:success")
                        Log.d(TAG, "Saving data to FireStore")
                        saveToFirestore(
                            etEmail.trim(),
                            etUserName.trim(),
                        )
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "createUserWithEmail:failure", task.exception)
                        Toast.makeText(
                            baseContext,
                            "Authentication Failed" + (task.getException()?.message
                                ?: ""),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

        } else {
            Toast.makeText(this, "Some Empty Fields", Toast.LENGTH_SHORT).show()
        }
    }

    private fun saveToFirestore(userEmail: String, userName: String) {
        val user = hashMapOf(
            "email" to userEmail,
            "username" to userName
        )
        db.collection("users").add(user).addOnSuccessListener { documentReference ->
            Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
            Toast.makeText(
                baseContext,
                "User added to Database!",
                Toast.LENGTH_SHORT
            ).show()
        }.addOnFailureListener { e ->
            Log.w(TAG, "Error adding document", e)
            Toast.makeText(
                baseContext,
                "Error" + e.toString(),
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    fun searchDataBase(username: String){
        db.collection("users")
            .whereEqualTo("username", username)
            .get()
            .addOnSuccessListener{
                Toast.makeText(
                    baseContext,
                    "User Found in Database!",
                    Toast.LENGTH_SHORT
                ).show()
            }
            .addOnFailureListener{
                Toast.makeText(
                    baseContext,
                    "User Not Found in Database!",
                    Toast.LENGTH_SHORT
                ).show()
            }
    }
}