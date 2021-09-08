package com.monsterb.sampleroom.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(val name:String, val age:Int, val address:String) {
    @PrimaryKey(autoGenerate = true) var uid:Int = 0
}
