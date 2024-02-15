package Curso.Kotlin.credit.aplication.system.controllers.dto

import Curso.Kotlin.credit.aplication.system.Model.Address
import Curso.Kotlin.credit.aplication.system.Model.Customer
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import org.hibernate.validator.constraints.br.CPF
import java.math.BigDecimal

data class CustomerDTO(
    @field:NotEmpty(message = "Falta digitar o nome") val firstName: String,
    @field:NotEmpty(message = "Falta digitar o sobrenome") val lastName: String,
    @field:NotEmpty(message = "Falta digitar o CPF")
    @field:CPF(message = "O CPF é inválido") val cpf: String,
    @field:NotNull(message = "Digite o valor da renda") val income: BigDecimal,
    @field:NotEmpty(message = "Falta digitar o e-mail")
    @Email(message = "este e-mail é inválido") val email: String,
    @field:NotEmpty(message = "Falta digitar a senha") val password: String,
    @field:NotEmpty(message = "Falta digitar o CEP") val zipCode: String,
    @field:NotEmpty(message = "Falta digitar a rua") val street: String

) {

    fun toEntity(): Customer = Customer(
        firstName = this.firstName,
        lastName = this.lastName,
        cpf = this.cpf,
        income = this.income,
        email = this.email,
        password = this.password,
        address = Address(
            zipCode = this.zipCode,
            street = this.street
        )
    )

}