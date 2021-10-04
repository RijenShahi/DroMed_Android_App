package com.rijen.dromedapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.rijen.dromedapp.dao.CartDAO
import com.rijen.dromedapp.dao.ProductDAO
import com.rijen.dromedapp.dao.UserDAO
import com.rijen.dromedapp.entity.Cart
import com.rijen.dromedapp.entity.Product
import com.rijen.dromedapp.entity.User

@Database(
    entities = [(Product::class), (Cart::class), (User::class)],
    version = 1
)
abstract class ProductDB : RoomDatabase() {

    abstract fun getProductDAO(): ProductDAO
    abstract fun getCartDAO() : CartDAO
    abstract fun getUserDAO(): UserDAO

    companion object {
        @Volatile
        private var instance: ProductDB? = null
        fun getInstance(context: Context): ProductDB {
            if (instance == null) {
                synchronized(ProductDB::class) {
                    instance = buildDatabase(context)
                }
            }
            return instance!!
        }
        private fun buildDatabase(context: Context): ProductDB {
            return Room.databaseBuilder(
                context.applicationContext,
                ProductDB::class.java,
                "MeroMedDatabase"
            ).build()
        }
    }
}