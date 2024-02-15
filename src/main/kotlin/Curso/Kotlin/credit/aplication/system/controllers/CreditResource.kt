package Curso.Kotlin.credit.aplication.system.controllers

import Curso.Kotlin.credit.aplication.system.Model.CreditEntity
import Curso.Kotlin.credit.aplication.system.Service.Implement.CreditService
import Curso.Kotlin.credit.aplication.system.controllers.dto.CreditDto
import Curso.Kotlin.credit.aplication.system.controllers.dto.CreditView
import Curso.Kotlin.credit.aplication.system.controllers.dto.CreditViewList
import org.springframework.http.HttpStatus.*
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.*
import java.util.stream.Collectors

@RestController
@RequestMapping("/api/credits")
class CreditResource(private val creditService: CreditService) {

    @PostMapping()
    fun saveCredit(@RequestBody creditDto: CreditDto): ResponseEntity<String> {
        val credit: CreditEntity = this.creditService.save(creditDto.toEntity())

        return ResponseEntity
            .status(CREATED)
            .body(" Credit ${credit.creditCode} + Customer ${credit.customer?.firstName} saved!")

    }

    @GetMapping
    fun findAllByCustomer(@RequestParam(value = "customerId") customerId: Long): ResponseEntity<List<CreditViewList>> {
        val creditListView: List<CreditViewList> = this.creditService.findByAllCostumer(customerId)
            .stream()
            .map { credit: CreditEntity -> CreditViewList(credit) }
            .collect(Collectors.toList())

        return ResponseEntity.status(OK).body(creditListView)

    }

    @GetMapping("/{creditCode}")
    fun findByCreditCode(
        @RequestParam(value = "customerId") customerId: Long,
        @PathVariable creditCode: UUID
    ): ResponseEntity<CreditView> {
        val credit: CreditEntity = this.creditService.findByCreditCode(customerId, creditCode)
        return ResponseEntity.status(OK).body(CreditView(credit))
    }
}