package com.greedy.boxoffice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.greedy.boxoffice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        auth = Firebase.auth

        /* 회원가입 버튼 */
        binding.join.setOnClickListener {
            startActivity(Intent(this, JoinActivity::class.java))
        }

        /* 로그인 버튼 */
        binding.btnLogin.setOnClickListener {

            val email = binding.email.text.toString()
            val password = binding.password.text.toString()

            /* 유효성 검사 */
            if (email.isNotEmpty() && password.isNotEmpty()) {
                signIn(email, password)
            } else {
                Toast.makeText(this, "이메일과 비밀번호를 입력해주세요", Toast.LENGTH_SHORT).show()
            }

        }


    }

    private fun signIn(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "로그인 되었습니다.", Toast.LENGTH_SHORT).show()
                    moveResultPage()
                } else {
                    Toast.makeText(this, "로그인에 실패하였습니다.", Toast.LENGTH_SHORT).show()
                }
            }
    }

    /* 로그인 후 Result로 이동 */
    public override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        if (currentUser != null) {
            moveResultPage()
        }
    }


    fun moveResultPage() {
        startActivity(Intent(this, ResultActivity::class.java))
        finish()
    }


}