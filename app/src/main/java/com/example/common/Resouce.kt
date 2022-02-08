package com.example.common

import com.example.domain.model.create_User_Model
import com.example.domain.model.user
import retrofit2.HttpException
import retrofit2.Response


sealed class Resource<T>(val data: Any? = null, val message: HttpException? = null) {
    class Success<T>(data: Response<List<user>>) : Resource<T>(data)
    class Error<T>(message: HttpException, data: T? = null) : Resource<T>(data, message)
    class Loading<T>(data: T? = null) : Resource<T>(data)
}