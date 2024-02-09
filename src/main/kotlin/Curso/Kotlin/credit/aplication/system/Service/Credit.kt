package Curso.Kotlin.credit.aplication.system.Service

import Curso.Kotlin.credit.aplication.system.Model.Credit
import java.util.UUID

interface Credit {

    fun save(credit: Credit) : Credit

    fun findByAllCostumer(costumerId: Long) : List<Credit>

    fun findByCreditCode( creditCode: UUID) : Credit
}