package com.example.api.presenetion

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.api.common.Resource
import com.example.api.domain.model.create_User_Model
import com.example.api.domain.model.user
import com.example.api.domain.model.userListState
import com.example.api.domain.use_case.getUser.getUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class viewModel @Inject constructor(

    private val getUserUseCase : getUsersUseCase


) : ViewModel() {

    private val _state = mutableStateOf(userListState())
    val state : State<userListState> = _state

    init{
        getUser()
    }


    fun getUser(){

        getUserUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = userListState()
                }
                is Resource.Error -> {
                    _state.value = userListState(
                        error = (result.message ?: "An unexpected error occured") as String
                    )
                }
                is Resource.Loading -> {
                    _state.value = userListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)

    }

}