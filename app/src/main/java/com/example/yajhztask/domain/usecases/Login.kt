package com.example.yajhztask.domain.usecases

import com.example.yajhztask.domain.repo.AuthRepo

class Login(private val authRepo: AuthRepo) {
    suspend operator fun invoke(email:String,password:String,deviceToken:String) = authRepo.login(
        email,password,deviceToken
    )
}