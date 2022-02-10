package com.example

import com.example.api.data.remote.user_api
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton
import java.lang.Class
import com.example.api.common.Constants
import com.example.api.domain.repository.UserRepositoeryImpl
import com.example.api.domain.repository.UserRepository
import retrofit2.create


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun UserApi() : user_api {
        return  Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .build()
            .create(user_api::class.java)

    }


    @Provides
    @Singleton
    fun userRepo(api : user_api) : UserRepository {
        return UserRepositoeryImpl(api)
    }

}