package Curso.Kotlin.credit.aplication.system.controllers

import Curso.Kotlin.credit.aplication.system.Model.Credit
import Curso.Kotlin.credit.aplication.system.Service.Implement.CreditService
import Curso.Kotlin.credit.aplication.system.controllers.dto.CreditDto
import Curso.Kotlin.credit.aplication.system.controllers.dto.CreditViewList
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.stream.Collectors

@RestController
@RequestMapping("/api/credits")
class CreditResource(
    private val creditservice: CreditService
) {

    @PostMapping("/insert")
    fun saveCredit(@RequestBody creditDto: CreditDto): String {
        val credit: Credit = this.creditservice.save(creditDto.toEntity())

        return " Credit ${credit.creditCode} + Customer ${credit.customer?.firstName} saved!"

    }

    @GetMapping("/")
    fun findAllByCustomer(
        @RequestParam(value = "customerId") customerId: Long
    ): List<CreditViewList> {
        return this.creditservice.findByAllCostumer(customerId)
            .stream()
            .map { credit: Credit -> CreditViewList(credit) }
            .collect(Collectors.toList())

    }
}