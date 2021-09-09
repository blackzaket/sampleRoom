package com.monsterb.sampleroom.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.monsterb.sampleroom.db.model.User

@Dao
interface UserDao {
    @Query("Select * From User")
    fun getUsers():List<User>

    @Insert
    fun insert(user: User)

    @Delete
    fun delete(user: User)
}
