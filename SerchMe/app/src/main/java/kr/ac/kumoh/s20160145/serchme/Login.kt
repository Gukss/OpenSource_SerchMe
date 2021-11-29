package kr.ac.kumoh.s20160145.serchme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kr.ac.kumoh.s20160145.serchme.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {
    private lateinit var view : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        view = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(view.root)
        //setContentView(R.layout.activity_login)

        view.SignIn.setOnClickListener {

            var InputId = view.InputId.text.toString()
            var InputPw = view.InputPw.text.toString()

            val intentLogin = Intent(this, MainActivity::class.java)

            if((InputId == "0000") && (InputPw == "0000")){
                startActivity(intentLogin)
            }
            else {
                Toast.makeText(applicationContext, "invalid", Toast.LENGTH_SHORT).show()
            }
        }

        view.SignUp.setOnClickListener {
            val intentSignUp = Intent(this, registration::class.java)
            startActivity(intentSignUp)
        }
    }
}