package com.example.database_example.idol.repository

import com.example.database_example.idol.entity.Idol
import org.springframework.data.repository.CrudRepository

//CrudRepository 추상메서드 ()생략 가능 상속
//save, findAll 등의 역할을 담고 있음
//DAO 역할
//JPA : 자바 코드로 SQL을 만듬
interface IdolRepository : CrudRepository<Idol, Long>

