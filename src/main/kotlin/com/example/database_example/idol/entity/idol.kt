package com.example.database_example.idol.entity

import com.example.database_example.idol.dto.IdolResponseDto
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

//h-2 annotation
@Entity
class Idol (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long = 0,
    //field
    @Column(nullable = false)
    var name : String,
    @Column(nullable = false)
    var age : Int,
) {
    fun toResponse() : IdolResponseDto = IdolResponseDto(
        id = id,
        name = name,
        age = age,
    )
}