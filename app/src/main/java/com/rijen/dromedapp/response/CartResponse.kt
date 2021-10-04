package com.rijen.dromedapp.response

import com.rijen.dromedapp.model.Cart


data class CartResponse(
    val success: Boolean? = null,
    val data: List<Cart>?= null
)
