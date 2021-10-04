package com.rijen.dromedapp.dao

import androidx.room.*
import com.rijen.dromedapp.entity.Cart

@Dao
interface CartDAO {
    // insert product
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCart(cart : Cart)

    @Query("select * from Cart")
    suspend fun getCartItems(): List<Cart>

    @Delete
    suspend fun deleteCartItems(cart: Cart)

    @Update
    suspend fun updateCartItems(cart: Cart)

    @Query("DELETE FROM Cart")
    suspend fun deleteAll()
}