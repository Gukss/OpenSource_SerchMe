package kr.ac.kumoh.s20160145.serchme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kr.ac.kumoh.s20160145.serchme.databinding.ActivityRegistrationBinding

class registration : AppCompatActivity() {
    private lateinit var view: ActivityRegistrationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        view = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(view.root)
        //setContentView(R.layout.activity_registration)

        view.SignUp.setOnClickListener {

            var inputId = view.InputId.text.toString()
            var inputPw = view.InputPw.text.toString()
            var inputPwConfirm = view.InputPwConfirm.text.toString()

            val intentMainActivity = Intent(this, MainActivity::class.java)

            if(inputPw != inputPwConfirm) {
                Toast.makeText(applicationContext, "confirm PW", Toast.LENGTH_SHORT).show()
            }
            else {
                startActivity(intentMainActivity)
            }


        }
    }
}