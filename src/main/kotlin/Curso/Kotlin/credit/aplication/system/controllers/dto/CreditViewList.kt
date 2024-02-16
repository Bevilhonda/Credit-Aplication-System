package Curso.Kotlin.credit.aplication.system.controllers.dto

import Curso.Kotlin.credit.aplication.system.Model.Credit
import java.math.BigDecimal
import java.util.UUID

data class CreditViewList(
    val creditCode: UUID,
    val creditValue : BigDecimal,
    val numbersOffInstalment : Int
) {
    constructor(credit : Credit): this (
        creditCode = credit.creditCode,
        creditValue = credit.creditValue,
        numbersOffInstalment = credit.numberOfInstallments
    )
}