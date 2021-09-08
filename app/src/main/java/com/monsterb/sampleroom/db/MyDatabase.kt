package com.monsterb.sampleroom.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.monsterb.sampleroom.db.dao.BookDao
import com.monsterb.sampleroom.db.dao.UserDao
import com.monsterb.sampleroom.db.model.Book
import com.monsterb.sampleroom.db.model.User

const val DATABASE = "mydatabase.db"

@Database(entities = [User::class, Book::class], version = 1)
abstract class MyDatabase : RoomDatabase(){

    abstract fun userDao(): UserDao
    abstract fun bookDao(): BookDao

    companion object {
        private var instance: MyDatabase? = null

        fun getInstance(context: Context): MyDatabase? {
            if (instance == null) {
                instance = Room.databaseBuilder(context, MyDatabase::class.java, DATABASE).build()
            }
            return instance
        }
    }
}
