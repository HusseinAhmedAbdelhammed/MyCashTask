package com.example.yajhztask.domain.usecases

import com.example.yajhztask.domain.repo.Repo

class GetTrendingSellers(private val repo: Repo) {
    suspend operator fun invoke(lat:Double,ing:Double,filter:Int) = repo.getTrendingSellers(lat,ing,filter)
}