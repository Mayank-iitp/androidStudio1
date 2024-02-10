package com.example.testapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.testapp.databinding.FirstPageBinding
import com.example.testapp.databinding.LoginBinding
import com.example.testapp.databinding.SignupBinding


class MainActivity : AppCompatActivity() {
    private lateinit var firstPageBinding: FirstPageBinding
    private lateinit var loginBinding: LoginBinding
    private lateinit var signupBinding: SignupBinding
    private var currentLayout: Int = R.layout.first_page
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        firstPageBinding= FirstPageBinding.inflate(layoutInflater)
        setContentView(firstPageBinding.root)

        firstPageBinding.loginButton.setOnClickListener {
            navigateToLogin()

        }
        firstPageBinding.signupButton.setOnClickListener {
            navigateToSignup()
        }
    }

    override fun onBackPressed() {
        when (currentLayout) {
            R.layout.first_page -> super.onBackPressed()
            R.layout.login -> {
                setContentView(firstPageBinding.root)
                currentLayout= R.layout.first_page
            }
            R.layout.signup -> {
                setContentView(firstPageBinding.root)
                currentLayout= R.layout.first_page
            }
        }

    }
    private fun navigateToLogin () {
        loginBinding= LoginBinding.inflate(layoutInflater)
        setContentView(loginBinding.root)
        currentLayout= R.layout.login
        loginBinding.button.setOnClickListener {
            showToast ("INVALID LOGIN ATTEMPT")
        }
    }
    private fun navigateToSignup () {
        signupBinding= SignupBinding.inflate(layoutInflater)
        setContentView(signupBinding.root)
    }
    private fun showToast (message: String) {

    }
}