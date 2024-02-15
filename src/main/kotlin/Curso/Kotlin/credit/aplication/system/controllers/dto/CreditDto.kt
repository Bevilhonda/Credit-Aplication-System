package Curso.Kotlin.credit.aplication.system.controllers.dto

import Curso.Kotlin.credit.aplication.system.Model.Credit
import Curso.Kotlin.credit.aplication.system.Model.Customer
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDto(
    val creditValue: BigDecimal,
    val dayFirstInstalmente: LocalDate,
    val numbersOffInstalmente: Int,
    val costumerId: Long
) {
    fun toEntity(): Credit = Credit(
        creditValue = this.creditValue,
        dayFirstInstalmente = this.dayFirstInstalmente,
        numberOffInstalmente = this.numbersOffInstalmente,
        customer = Customer(id = this.costumerId)
    )


}