package Curso.Kotlin.credit.aplication.system.controllers.dto

import Curso.Kotlin.credit.aplication.system.Model.CreditEntity
import Curso.Kotlin.credit.aplication.system.Model.Customer
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDto(
    val creditValue: BigDecimal,
    val dayFirstInstalment: LocalDate,
    val numbersOffInstalment: Int,
    val costumerId: Long
) {
    fun toEntity(): CreditEntity = CreditEntity(
        creditValue = this.creditValue,
        dayFirstInstalmente = this.dayFirstInstalment,
        numberOffInstalmente = this.numbersOffInstalment,
        customer = Customer(id = this.costumerId)
    )

}