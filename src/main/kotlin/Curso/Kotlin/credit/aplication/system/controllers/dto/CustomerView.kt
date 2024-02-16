package Curso.Kotlin.credit.aplication.system.controllers.dto

import Curso.Kotlin.credit.aplication.system.Model.Customer
import java.math.BigDecimal

data class CustomerView(
    var firstName: String,
    var lastName: String,
    var cpf: String,
    var income: BigDecimal,
    var email: String,
    var zipCode: String,
    var street: String
) {
    constructor(customer: Customer) : this(
        firstName = customer.firstName,
        lastName = customer.lastName,
        cpf = customer.cpf,
        income = customer.income,
        email = customer.email,
        zipCode = customer.address.zipCode,
        street = customer.address.street,
    )


}