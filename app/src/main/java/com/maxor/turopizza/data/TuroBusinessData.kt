package com.maxor.turopizza.data

data class TuroBusinessData (
    val rating : Double = 0.0,
    val price : String,
    val phone : String,
    val id : String,
    val review_count : Int = 0,
    val name : String,
    val image_url : String,
    val distance : Double = 0.0)