package Curso.Kotlin.credit.aplication.system.controllers.dto

import java.math.BigDecimal
import java.util.*
import Curso.Kotlin.credit.aplication.system.Enumeration.Status
import Curso.Kotlin.credit.aplication.system.Model.Credit

data class CreditView(
    val creditCode : UUID,
    val creditValue : BigDecimal,
    val numberOffInstalment : Int,
    val status : Status,
    val emailCustomer : String?,
    val incomeCustomer : BigDecimal?
) {
    constructor(credit : Credit ): this(
        creditCode = credit.creditCode,
        creditValue = credit.creditValue,
        numberOffInstalment = credit.numberOfInstallments,
        status= credit.status,
        emailCustomer = credit.customer?.email,
        incomeCustomer = credit.customer?.income
    )
}