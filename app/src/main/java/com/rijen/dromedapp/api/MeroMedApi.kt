package com.rijen.dromedapp.api

import com.rijen.dromedapp.model.AccountModel
import com.rijen.dromedapp.response.LoginResponse
import com.rijen.dromedapp.response.ServerResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface MeroMedApi {
    //for registering user
    @POST("account/insert")
    suspend fun registerUser(@Body user: AccountModel): Response<ServerResponse>

    @FormUrlEncoded
    @POST("account/login")
    suspend fun loginUser(
        @Field("accUN") username: String,
        @Field("accPwd") password: String
    ): Response<LoginResponse>
}