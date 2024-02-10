package Curso.Kotlin.credit.aplication.system.service

import Curso.Kotlin.credit.aplication.system.model.Credit

interface Credit {

    fun save(credit: Credit) : Credit

    fun findByAllCostumer(costumerId: Long) : List<Credit>

    fun findByCreditCode(costumerId: Long , creditCode: org.hibernate.validator.constraints.UUID) : Credit
}