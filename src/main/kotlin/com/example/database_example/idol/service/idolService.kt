package com.example.database_example.idol.service

import com.example.database_example.idol.dto.IdolRequestDto
import com.example.database_example.idol.dto.IdolResponseDto
import com.example.database_example.idol.repository.IdolRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class IdolService {

    @Autowired
    private lateinit var idolRepository: IdolRepository

    /*
    Idol 리스트 추가
     */
    fun getIdolList() : List<IdolResponseDto> {
        /*
        SELECT * FROM IDOL; 의 역할
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
    id를 불러와서 Null이 아니라면 idol의 id에 따른 값을 가져옴
    없다면 NOT_Found status를 출력
     */

    fun getIdolById(id : Long) : IdolResponseDto{
        val result = idolRepository.findByIdOrNull(id) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)
        return result.toResponse()
    }

    /*
    아이돌 개체를 idolRepository 에 저장함
     */
    fun postIdol(idol: IdolRequestDto) : IdolResponseDto {
        val result = idolRepository.save(idol.toEntity())
        return result.toResponse()
    }

    /*
    put은 kotlin에서 get과 동일하기 때문에 생략함
    UPDATE FROM IDOL WHERE "ID" = NUMBER;
     */

    /*
    DELETE
    id를 받아서 idolRepository에서 찾고 있다면 삭제함
    없으면 BAD_REQUEST status 코드를 출력
     */
    fun deleteIdolById(id: Long) : Unit {
        try{
            idolRepository.deleteById(id)
        } catch (e : Exception) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST)
        }
    }

}