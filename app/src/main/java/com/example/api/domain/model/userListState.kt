package com.example.api.domain.model

data class userListState(

    val isLoading : Boolean = false,
    val UserList : List<user> = emptyList(),
    val error : String = " "
)
