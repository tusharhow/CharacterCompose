package com.example.charactercompose.views.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.charactercompose.models.CharacterModel
import com.example.charactercompose.retrofit_config.RetrofitConfig
import kotlinx.coroutines.launch

class CharacterViewModel : ViewModel() {
    private val retrofitConfig = RetrofitConfig
    private val _characterData = MutableLiveData<CharacterModel>()
    val characterData: LiveData<CharacterModel> get() = _characterData

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading



    private fun getCharacter() {
        _isLoading.value = true // Set isLoading to true when starting the request
        viewModelScope.launch {
            try {
                val character = retrofitConfig.characterService.getCharacters()
                _characterData.value = character
            } catch (e: Exception) {
                _error.value = e.message
            } finally {
                _isLoading.value = false // Set isLoading to false when the request is completed
            }
        }
    }

    init {
        getCharacter()
    }
}
