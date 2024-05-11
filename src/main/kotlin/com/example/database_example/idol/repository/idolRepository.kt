package com.example.database_example.idol.repository

import com.example.database_example.idol.entity.Idol
import org.springframework.data.repository.CrudRepository

//CrudRepository 추상메서드 ()생략 가능 상속
interface IdolRepository : CrudRepository<Idol, Long> {

}