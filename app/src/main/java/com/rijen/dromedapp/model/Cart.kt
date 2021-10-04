package com.rijen.dromedapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.rijen.dromedapp.entity.Product

@Entity
data class Cart(
    @PrimaryKey
    var _id: String,
    var product_id: Product,
    var quantity: Int=0,
    val price: Int = 0
)
