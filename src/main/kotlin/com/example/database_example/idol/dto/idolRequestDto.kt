package com.example.database_example.idol.dto

import com.example.database_example.idol.entity.Idol
import jakarta.persistence.Column
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

data class IdolRequestDto(
    val id : Long,
    var name : String,
    var age : Int,
){
    fun toEntity() : Idol = Idol(
        id = id,
        name = name,
        age = age,
    )
}

data class IdolResponseDto (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long,
    @Column(nullable = false)
    var name : String,
    @Column(nullable = false)
    var age : Int,
){
    fun toResponse() : IdolResponseDto = IdolResponseDto(
        id = id,
        name = name,
        age = age
    )
}