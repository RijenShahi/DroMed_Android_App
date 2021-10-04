package com.rijen.dromedapp.response

import com.rijen.dromedapp.entity.User

data class LoginResponse(
    val success: Boolean? = null,
    val token: String? = null,
    val data: User? = null

)
