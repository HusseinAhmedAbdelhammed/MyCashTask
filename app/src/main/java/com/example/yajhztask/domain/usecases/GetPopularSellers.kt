package com.example.yajhztask.domain.usecases

import com.example.yajhztask.domain.repo.Repo

class GetPopularSellers(private val repo:Repo) {
    suspend operator fun invoke(lat:Double,ing:Double,filter:Int) = repo.getPopularSellers(lat,ing,filter)
}