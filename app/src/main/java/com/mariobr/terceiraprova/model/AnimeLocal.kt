package com.mariobr.terceiraprova.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_anime")
data class AnimeLocal (
    var nome:String,
    var arcos:String,
    var eps:Int,
    var ano:Int,
    var idioma:String,
    var classificacao:Int
){
    @PrimaryKey(autoGenerate = true)
    var id = 0L;
    constructor() :this ("", "", 0, 0, "", 0)
}