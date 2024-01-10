package com.example.yajhztask.domain.usecases

import com.example.yajhztask.domain.repo.AuthRepo

class Register(private val authRepo: AuthRepo) {
    suspend operator fun invoke(name:String,email: String,
                                password: String,phoneNumber:String,deviceToken:String)
    = authRepo.register(name,email,password,phoneNumber,deviceToken)
}