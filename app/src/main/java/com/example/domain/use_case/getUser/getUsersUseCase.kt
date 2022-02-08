package com.example.domain.use_case.getUser

import android.util.Log
import com.example.common.Resource
import com.example.domain.model.user
import com.example.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class getUsersUseCase @Inject constructor(

    private  val repository: UserRepository

) {
        operator  fun invoke() : Flow<Resource<List<user>>> = flow{

            try{

                emit(Resource.Loading())
                val user = repository.getUser()
                emit(Resource.Success(user))


            }catch (e:HttpException){

                emit(Resource.Error(e))

            }catch (e : IOException){

                Log.d("error get user Domain",""+e)

            }

        }
}