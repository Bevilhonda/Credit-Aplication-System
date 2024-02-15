package Curso.Kotlin.credit.aplication.system.controllers.dto

import Curso.Kotlin.credit.aplication.system.Model.Credit
import java.math.BigDecimal
import java.util.UUID

data class CreditViewList(
    val creditCode: UUID,
    val creditValue : BigDecimal,
    val numbersOffInstalmente : Int
) {
    constructor(credit : Credit): this (
        creditCode = credit.creditCode,
        creditValue = credit.creditValue,
        numbersOffInstalmente = credit.numberOffInstalmente
    )
}