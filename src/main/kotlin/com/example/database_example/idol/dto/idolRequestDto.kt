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
URL Link에 정보를 담아 보낼 수 있음
또 json 형식의 데이터를 보냄
 */
data class IdolRequestDto(
    val id : Long,
    var name : String,
    var age : Int,
){
    fun toEntity() : Idol = Idol(
        /*
        Database 안에 값을 Entity로 넣어줌
        메소드를 부르면 idol의 객체로 바꿔서 보내줌
         */
        id = id,
        name = name,
        age = age,
    )
}

data class IdolResponseDto (
    val id : Long,
    var name : String,
    var age : Int,
){
    fun toResponse() : IdolResponseDto = IdolResponseDto(
        id = id,
        name = name,
        age = age
    )
}