package com.rijen.dromedapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.rijen.dromedapp.dao.UserDAO
import com.rijen.dromedapp.entity.User

@Database(
    entities = [(User::class)],
    version = 1
)
abstract class UserDB : RoomDatabase() {

    abstract fun getUserDAO(): UserDAO

    companion object {
        @Volatile
        private var instance: UserDB? = null
        fun getInstance(context: Context): UserDB {
            if (instance == null) {
                synchronized(UserDB::class) {
                    instance = buildDatabase(context)
                }
            }
            return instance!!
        }
        private fun buildDatabase(context: Context): UserDB {
            return Room.databaseBuilder(
                context.applicationContext,
                UserDB::class.java,
                "MeroMedDatabase"
            ).build()
        }
    }
}