package kr.ac.kumoh.s20160145.serchme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Website.URL
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import kr.ac.kumoh.s20160145.serchme.databinding.ActivityApiReciveBinding

class ApiRecive : AppCompatActivity() {
    private lateinit var view:ActivityApiReciveBinding

    private var key:String = "d0422c886fe84db9809b"
    private lateinit var data:String

    override fun onCreate(savedInstanceState: Bundle?) {
        view = ActivityApiReciveBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(view.root)
        //setContentView(R.layout.activity_api_recive)

        /*view.button.setOnClickListener {
            data=getData()
        }*/
    }

    fun getData() {
        var queryUrl = "http://openapi.foodsafetykorea.go.kr/api/d0422c886fe84db9809b/COOKRCP01/json/2/2"

        //URL url = new url(queryUrl)
//        val request = JsonArrayRequest(
//            Request.Method.GET,
//            queryUrl,
//            null,
//        )
    }
}