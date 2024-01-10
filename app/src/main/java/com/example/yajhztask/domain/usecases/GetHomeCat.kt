package com.example.yajhztask.domain.usecases

import com.example.yajhztask.domain.repo.Repo

class GetHomeCat(private val repo: Repo)  {
    suspend operator fun invoke() = repo.getHomeCat()
}