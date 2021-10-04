package com.rijen.dromedapp.repository

import com.rijen.dromedapp.api.ApiRequest
import com.rijen.dromedapp.api.MeroMedApi
import com.rijen.dromedapp.api.ServiceBuilder
import com.rijen.dromedapp.model.AccountModel
import com.rijen.dromedapp.response.LoginResponse
import com.rijen.dromedapp.response.ServerResponse

class UserRepository : ApiRequest() {
    val egApi = ServiceBuilder.buildService(MeroMedApi::class.java)
    suspend fun registerUser(user: AccountModel): ServerResponse {
        return apiRequest {
            egApi.registerUser(user)
        }
    }

    suspend fun loginUser(username: String, password: String): LoginResponse {
        return apiRequest {
            egApi.loginUser(username, password)
        }
    }
}
