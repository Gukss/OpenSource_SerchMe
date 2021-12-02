package kr.ac.kumoh.s20160145.serchme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kr.ac.kumoh.s20160145.serchme.databinding.ActivityRegistrationBinding


class registration : AppCompatActivity() {
    private lateinit var view: ActivityRegistrationBinding
    private val preferences = arrayOf("끓이기", "찌기", "굽기", "튀기기", "볶기", "기타")

    private lateinit var model: ListViewModel
    private val preferenceAdapter = PreferenceAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        view = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(view.root)
        //setContentView(R.layout.activity_registration)

        /*view.SignUp.setOnClickListener {

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
        }*/

        /*view.listView1.adapter = RecyclerView.ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, preferences)*/

        model = ViewModelProvider(this).get(ListViewModel::class.java)

        model.getList().observe(this, Observer<ArrayList<String>> {
            preferenceAdapter.notifyDataSetChanged()
        })

        for (str in preferences) {
            model.add(str)
        }



        view.listView1.apply{
            layoutManager = LinearLayoutManager(applicationContext, RecyclerView.HORIZONTAL, false)
            itemAnimator = DefaultItemAnimator()
            setHasFixedSize(true)
            adapter = PreferenceAdapter()
        }
        
        view.listView1.setOnClickListener {
            //클릭시 구현
        }
    }
    inner class PreferenceAdapter:RecyclerView.Adapter<PreferenceAdapter.ViewHolder>(){
        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val txPreference: TextView = itemView.findViewById(android.R.id.text1)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(android.R.layout.simple_list_item_1, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.txPreference.text = model.getPreference(position)
        }

        override fun getItemCount()= model.getSize()

    }
    
}