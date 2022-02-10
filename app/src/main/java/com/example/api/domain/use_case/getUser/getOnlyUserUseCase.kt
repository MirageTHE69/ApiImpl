package com.example.api.domain.use_case.getUser

import android.util.Log
import com.example.api.common.Resource
import com.example.api.domain.model.user
import com.example.api.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class getOnlyUserUseCase @Inject constructor(

    private  val repository: UserRepository

) {
        operator  fun invoke(Id : String) : Flow<Resource<user>> = flow{

            try{

                emit(Resource.Loading())

//                val user = repository.getUserById(Id)
//                emit(Resource.Success(user))
//

            }catch (e:HttpException){

                emit(Resource.Error(e))

            }catch (e : IOException){

                Log.d("error get user Domain",""+e)

            }

        }
}