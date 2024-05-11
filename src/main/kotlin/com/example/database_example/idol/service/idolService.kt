package com.example.database_example.idol.service

import com.example.database_example.idol.dto.IdolRequestDto
import com.example.database_example.idol.dto.IdolResponseDto
import com.example.database_example.idol.entity.Idol
import com.example.database_example.idol.repository.IdolRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.server.ResponseStatusException


@Service
class IdolService {

    @Autowired
    private lateinit var idolRepository: IdolRepository

    fun getIdolList() : List<IdolResponseDto> {
        /*
        select * from idol ; 역할
         */
        val result = idolRepository.findAll()
        return result.map { it.toResponse() }
    }
    /*
    INSERT INTO IDOL VALUE(
        id = Long,
        name = Varchar,
        age = Int,
    )
     */

    /*
    SELECT * FROM IDOL
    WHERE "id" = number;
     */

    fun getIdolById(id : Long) : IdolResponseDto{
        val result = idolRepository.findByIdOrNull(id) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)
        return result.toResponse()
    }


    fun postIdol(idol: IdolRequestDto) : IdolResponseDto {
        val result = idolRepository.save(idol.toEntity())
        return result.toResponse()
    }

    /*
    UPDATE FROM IDOL WHERE "ID" = NUMBER;
    GET 과 업데이트 하는 것이 동일
     */

    /*
    DELETE
     */
    fun deleteIdolById(id: Long) : Unit {
        idolRepository.deleteById(id)
    }

}