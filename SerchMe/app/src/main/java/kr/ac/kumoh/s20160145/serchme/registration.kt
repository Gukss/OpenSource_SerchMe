package kr.ac.kumoh.s20160145.serchme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

class registration : AppCompatActivity() {
    lateinit var id: EditText
    lateinit var password: EditText
    lateinit var password_confirm: EditText

    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        id = findViewById(R.id.InputId)
        password = findViewById(R.id.InputPw)
        password_confirm = findViewById(R.id.InputPwConfirm)

        button = findViewById(R.id.SignUp)

        val retrofit = Retrofit.Builder()
            .baseUrl("http://searchme1.cafe24.com") // 주소는 본인의 서버 주소로 설정
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(RegisterService::class.java)

        button.setOnClickListener {
            val idStr = id.text.toString()
            val pwStr = password.text.toString()
            val pwconfStr = password_confirm.text.toString()

            //pwconfirm interrupt

            service.register(idStr, pwStr).enqueue(object : Callback<RegistrationResponse> {
                override fun onResponse(call: Call<RegistrationResponse>, response: Response<RegistrationResponse>) {
                    val result = response.body()
                    Log.d("로그인", "${result}")
                }

                override fun onFailure(call: Call<RegistrationResponse>, t: Throwable) {
                    Log.e("로그인", "${t.localizedMessage}")
                }
            })
        }
    }
}

interface RegisterService {
    @FormUrlEncoded
    @POST("registration.php")
    fun register(@Field("id") id:String,
                 @Field("password") pw:String ) : Call<RegistrationResponse>
}
