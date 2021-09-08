package com.monsterb.sampleroom.db.dao

import androidx.room.Query
import com.monsterb.sampleroom.db.model.User

interface UserDao {
    @Query("Select * From User")
    fun getUsers():List<User>
}
