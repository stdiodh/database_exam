package com.example.database_example.idol.entity

import com.example.database_example.idol.dto.IdolResponseDto
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

//h-2 annotation
//Entity 어노테이션의 의미는 Idol 클래스가 이런형식이다 라는 걸 알려줌
//@table 이름 -> 이름을 내가 직접 명시해 커스텀 해서 쓸 수 있음
@Entity
class Idol (

    //Id 어노테이션은 primary key를 의미
    @Id
    //키 값의 규칙을 정함 (IDENTITY는 사용자에게 키 값을 받겠다. auto는 없는 키 값 부터 만듬)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long = 0,
    //field

    //Columm은 일반 필드를 의미 nullable = false는 널값이 들어갈 수 없다는 것을 의미
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