package com.example.darts_de_go.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.darts_de_go.model.repository.OverpassService
import com.example.darts_de_go.model.state.InitialSettingState
import com.example.darts_de_go.model.useCase.OverpassImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class InitialSettingScreenViewModel: ViewModel() {
    private val apiService = OverpassImpl.create()
    // viewModel内で使用（更新用）
    private val _state = MutableStateFlow(InitialSettingState())
    // viewで呼び出される（読み取り専用）
    val state: StateFlow<InitialSettingState> = _state


    /**
     * getCityNames
     * 各都市を取得してくる
     */
    fun getCityNames() {
        viewModelScope.launch {
            try {
                val query = "[out:json];area[name='Osaka'][admin_level=4];node(area)[place=city];out;"
                val cityNames = apiService.queryCityNames(query)
                _state.value = _state.value.copy(
                    cityName = cityNames
                )
            } catch(e: Exception) {
                // TODO: 後でやる
            }
        }
    }

    fun cityNameToStr() {

    }

}