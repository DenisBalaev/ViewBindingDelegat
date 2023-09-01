package com.example.viewbindingdelegat.status

interface StatusModel

data class ItemHeaderStatusModel(
    val date: String
):StatusModel

data class ItemCardErrorModel(
    val text:String
):StatusModel

data class ItemCardGeneralModel(
    val image:Int,
    val name:String,
    val percentages:Int,
    val isActive:Boolean = true
):StatusModel