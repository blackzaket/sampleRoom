package com.monsterb.sampleroom.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Book (val name:String, val auth:String){
    @PrimaryKey(autoGenerate = true) var uid:Int = 0
}
