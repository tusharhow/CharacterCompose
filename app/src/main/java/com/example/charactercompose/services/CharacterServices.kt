package com.example.charactercompose.services

import com.example.charactercompose.models.CharacterModel
import retrofit2.http.GET

interface CharacterService {
    @GET("/api/character")
   suspend fun getCharacters(): CharacterModel
}