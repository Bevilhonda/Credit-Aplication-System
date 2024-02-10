package Curso.Kotlin.credit.aplication.system.controllers

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/costumers")
class CostumerResource {

    @PostMapping
    fun saveCostumer(costumerDto: CostumerDto) : String {

    }

}