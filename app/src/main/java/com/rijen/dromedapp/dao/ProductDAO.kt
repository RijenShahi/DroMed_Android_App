package com.rijen.dromedapp.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rijen.dromedapp.entity.Product

@Dao
interface ProductDAO {
    // insert product
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProduct(product : Product)

    @Query("select * from Product")
    suspend fun getAllProduct(): List<Product>

    @Query("delete from Product")
    suspend fun deleteProducts()
}