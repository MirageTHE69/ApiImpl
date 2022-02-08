package com.example.data.remote

import com.example.domain.model.create_User_Model
import com.example.domain.model.user
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface user_api {

    @GET("/user")
    fun get_user() : Response<List<user>>

    @POST("/ceateUser")
    fun creat_user(email : String , password : String) : Response<List<create_User_Model>>

    @GET("/user/{userId}")
    fun getUserById(@Path("userId")userId : String ): Response<create_User_Model>

}


