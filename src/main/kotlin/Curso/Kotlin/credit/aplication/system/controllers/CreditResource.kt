package Curso.Kotlin.credit.aplication.system.controllers

import Curso.Kotlin.credit.aplication.system.Service.Implement.CreditService
import Curso.Kotlin.credit.aplication.system.controllers.dto.CreditDto
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/credits")
class CreditResource(
    private val creditservice : CreditService
) {

    @PostMapping("/insert")
    fun saveCredit(creditDto : CreditDto): String{

    }
}