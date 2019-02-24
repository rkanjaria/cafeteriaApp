package com.example.cafeteria.data

import com.example.cafeteria.data.remote.RetrofitApi

class CafeteriaRepository(val retrofitApi: RetrofitApi) {

    companion object {
        private var INSTANCE: CafeteriaRepository? = null

        @JvmStatic
        fun getInstance(retrofitApi: RetrofitApi /*, databaseDao*/) =
            INSTANCE ?: synchronized(CafeteriaRepository::class.java) {
                INSTANCE ?: CafeteriaRepository(retrofitApi).also { INSTANCE = it }
            }
    }
}
