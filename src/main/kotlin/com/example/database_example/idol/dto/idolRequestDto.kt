package com.example.database_example.idol.dto

import com.example.database_example.idol.entity.Idol
import jakarta.persistence.Column
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

/*
Dto (Data transport object)
데이터를 각각의 레이어로 전송시켜주기 위한 객체
해당 계층 안에서만 교환이 일어남
 */
data class IdolRequestDto(
    val id : Long,
    var name : String,
    var age : Int,
){
    fun toEntity() : Idol = Idol(
        /*
        Database 안에 값을 Entity로 넣어줌
         */
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