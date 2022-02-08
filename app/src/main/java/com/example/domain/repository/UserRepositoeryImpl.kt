package com.example.domain.repository

import com.example.domain.model.create_User_Model
import com.example.domain.model.user
import retrofit2.Response
import com.example.data.remote.user_api

import javax.inject.Inject

class UserRepositoeryImpl @Inject constructor(
    private val userAPI : user_api
) : UserRepository{
    override suspend fun getUser(): Response<List<user>>{
        return userAPI.get_user()
    }

    override suspend fun createUser(
        email: String,
        password: String
    ): Response<List<create_User_Model>> {
        TODO("Not yet implemented")
    }

    override suspend fun getUserById(UserId: String): Response<create_User_Model>{
        return  userAPI.getUserById(UserId)
    }
}