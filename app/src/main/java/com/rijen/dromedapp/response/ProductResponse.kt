package com.rijen.dromedapp.response

import com.rijen.dromedapp.entity.Product

data class ProductResponse(
    val success: Boolean? = null,
    val data: List<Product>? = null
)
