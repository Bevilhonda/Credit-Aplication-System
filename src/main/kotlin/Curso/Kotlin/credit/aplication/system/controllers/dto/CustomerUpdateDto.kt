package Curso.Kotlin.credit.aplication.system.controllers.dto

import Curso.Kotlin.credit.aplication.system.Model.Customer
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal

data class CustomerUpdateDto(
    @field:NotEmpty(message = "Falta digitar o nome") val firstName: String,
    @field:NotEmpty(message = "Falta digitar o sobrenome") val lastName: String,
    @field:NotNull(message = "Digite o valor da renda") val income: BigDecimal,
    @field:NotEmpty(message = "Falta digitar o CEP") val zipCode: String,
    @field:NotEmpty(message = "Falta digitar a rua") val street: String

) {
    fun toEntity(customer: Customer): Customer {
        customer.firstName = this.firstName
        customer.lastName = this.lastName
        customer.income = this.income
        customer.address.zipCode = this.zipCode
        customer.address.street = this.street

        return customer

    }
}