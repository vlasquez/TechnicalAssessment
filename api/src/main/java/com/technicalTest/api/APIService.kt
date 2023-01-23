package com.technicalTest.api

import retrofit2.Retrofit
import javax.inject.Inject

class APIService @Inject constructor(private val retrofit: Retrofit) {

    fun <T> createService(service: Class<T>): T = retrofit.create(service)
}