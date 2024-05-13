package com.example.database_example.idol.controller

import com.example.database_example.idol.dto.IdolRequestDto
import com.example.database_example.idol.dto.IdolResponseDto
import com.example.database_example.idol.service.IdolService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
//경로지정 (한번 해두면 경로 지정을 다시 안해도 됨)
@RequestMapping("/api/idols")
class IdolController {
    @Autowired
    private lateinit var idolService : IdolService

    @GetMapping
    //private를 사용하면 함수 안 매개변수들을 다른 곳에서 정의할 수 없음
    //변수를 재사용할 때 용의
    private fun getIdolList() : ResponseEntity<List<IdolResponseDto>> {
        val result = idolService.getIdolList()
        return ResponseEntity.status(HttpStatus.OK).body(result)
    }

    /*
    아이디로 아이돌 조회
    GET은 데이터 읽는 것을 요청하는 메서드
    조회가 된다면 200, 즉 OK status로 출력
     */
    @GetMapping("/{id}")
    private fun getIdolById(@PathVariable id : Long) : ResponseEntity<Any> {
        val result = idolService.getIdolById(id)
        return ResponseEntity.status(HttpStatus.OK).body(result)
    }

    /*
    Post는 데이터 생성을 요청하는 메서드
    생성될 시 CREATED status를 출력
     */
    @PostMapping
    private fun postIdol(@RequestBody idolRequestDto: IdolRequestDto) : ResponseEntity<IdolResponseDto> {
        val result = idolService.postIdol(idolRequestDto)
        return ResponseEntity.status(HttpStatus.CREATED).body(result)
    }

    /*
    PUT은 데이터를 변경하는 것을 요청하는 메서드
    기본적으로 Status는 GET과 동일함 (이유는 데이터를 업데이트 한다는 점에서 세이브하는 GET과 동일)
     */
    @PutMapping
    private fun putIdol (@RequestBody idolRequestDto: IdolRequestDto) : ResponseEntity<IdolResponseDto> {
        val result = idolService.postIdol(idolRequestDto)
        return ResponseEntity.status(HttpStatus.OK).body(result)
    }

    /*
    DELETE는 데이터의 삭제를 요청하는 메서드
    요구사항에 따라 NO_CONTENT 204의 status 값을 가짐
    204는 요청은 성공했지만 데이터를 반환할 것이 없다는 의미로 return에는 body가 존재하지 않고 build가 존재
     */
    @DeleteMapping("/{id}")
    private fun delectIdolById(@PathVariable id : Long) : ResponseEntity<Any> {
        idolService.deleteIdolById(id)
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build()
    }
}