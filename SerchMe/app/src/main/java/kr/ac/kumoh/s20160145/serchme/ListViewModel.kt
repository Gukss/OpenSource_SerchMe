package kr.ac.kumoh.s20160145.serchme

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ListViewModel: ViewModel() {
    private val list = MutableLiveData<ArrayList<String>>()
    private val preferences = ArrayList<String>()

    init {
        list.value = preferences
    }

    fun getList(): LiveData<ArrayList<String>> = list

    fun add(preference: String) {
        preferences.add(preference)
        list.value = preferences
    }

    fun getPreference(i: Int) = preferences[i]
    fun getSize() = preferences.size
}