package com.example.yajhztask.app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.yajhztask.app.state.ResponseState
import com.example.yajhztask.domain.models.basecat.BaseCatRespoonse
import com.example.yajhztask.domain.models.homecat.HomeCatRes
import com.example.yajhztask.domain.models.popularsellers.PopularSellers
import com.example.yajhztask.domain.models.trendingsellers.TrendingSellers
import com.example.yajhztask.domain.usecases.GetBaseCat
import com.example.yajhztask.domain.usecases.GetHomeCat
import com.example.yajhztask.domain.usecases.GetPopularSellers
import com.example.yajhztask.domain.usecases.GetTrendingSellers
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel

class HomeViewModel@Inject constructor(private val getBaseCat: GetBaseCat, private val getHomeCat: GetHomeCat,
                                       private val getPopularSellers: GetPopularSellers, private val getTrendingSellers: GetTrendingSellers):ViewModel() {
    var homeCat : MutableStateFlow<ResponseState<HomeCatRes>> = MutableStateFlow(ResponseState.OnLoading(false))
    private val _homeCat: StateFlow<ResponseState<HomeCatRes>> = homeCat
    var baseCat : MutableStateFlow<ResponseState<BaseCatRespoonse>> = MutableStateFlow(ResponseState.OnLoading(false))
    private val _baseCat: StateFlow<ResponseState<BaseCatRespoonse>> = baseCat
    var popularSellers : MutableStateFlow<ResponseState<PopularSellers>> = MutableStateFlow(ResponseState.OnLoading(false))
    private val _popularSellers: StateFlow<ResponseState<PopularSellers>> = popularSellers
    var trendingSellers : MutableStateFlow<ResponseState<TrendingSellers>> = MutableStateFlow(ResponseState.OnLoading(false))
    private val _trendingSellers: StateFlow<ResponseState<TrendingSellers>> = trendingSellers
    fun getPopularSeller(lat:Double,ing:Double,filter:Int){
        viewModelScope.launch{
            getPopularSellers(lat,ing,filter).flowOn(Dispatchers.IO).catch {
                popularSellers.emit(ResponseState.OnError(it.message?:"No message found"))
            }.collect{
                popularSellers.emit(ResponseState.OnSuccess(it))
            }
        }
    }
    fun getTrendSellers(lat:Double,ing:Double,filter:Int){
        viewModelScope.launch{
            getTrendingSellers(lat,ing,filter).flowOn(Dispatchers.IO).catch {
                trendingSellers.emit(ResponseState.OnError(it.message?:"No message found"))
            }.collect{
                trendingSellers.emit(ResponseState.OnSuccess(it))
            }
        }
    }
    fun getBaseCategory(){
        viewModelScope.launch {
            getBaseCat().flowOn(Dispatchers.IO).catch {
                baseCat.emit(ResponseState.OnError(it.message?:"No message found"))
            }.collect{
                baseCat.emit(ResponseState.OnSuccess(it))
            }
        }
    }
    fun getHomeCategory(){
        viewModelScope.launch {
            getHomeCat().flowOn(Dispatchers.IO).catch {
                homeCat.emit(ResponseState.OnError(it.message?:"No message found"))
            }.collect{
                homeCat.emit(ResponseState.OnSuccess(it))
            }
        }
    }


}