package com.example.database_example.idol.controller

import com.example.database_example.idol.dto.IdolRequestDto
import com.example.database_example.idol.dto.IdolResponseDto
import com.example.database_example.idol.service.IdolService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
//경로지정
@RequestMapping("/api/idols")
class IdolController {
    @Autowired
    private lateinit var idolService : IdolService

    @GetMapping
    //외부 접근 불가 private
    private fun getIdolList() : ResponseEntity<List<IdolResponseDto>> {
        val result = idolService.getIdolList()
        return ResponseEntity.status(HttpStatus.OK).body(result)
    }

    /*
    아이디로 아이돌 조회
     */
    @GetMapping("/{id}")
    private fun getIdolById(@PathVariable id : Long) : ResponseEntity<Any> {
        val result = idolService.getIdolById(id)
        return ResponseEntity.status(HttpStatus.OK).body(result)
    }

    @PostMapping
    private fun postIdol(@RequestBody idolRequestDto: IdolRequestDto) : ResponseEntity<IdolResponseDto> {
        val result = idolService.postIdol(idolRequestDto)
        return ResponseEntity.status(HttpStatus.CREATED).body(result)
    }

    //Get 과 세이브 하는 것이 업데이트 하는 것과 동일함
    @PutMapping
    private fun putIdol (@RequestBody idolRequestDto: IdolRequestDto) : ResponseEntity<IdolResponseDto> {
        val result = idolService.postIdol(idolRequestDto)
        return ResponseEntity.status(HttpStatus.OK).body(result)
    }

    @DeleteMapping("/{id}")
    private fun delectIdolById(@PathVariable id : Long) : ResponseEntity<Any> {
        idolService.deleteIdolById(id)
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build()
    }
}