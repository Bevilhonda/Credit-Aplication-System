package Curso.Kotlin.credit.aplication.system.Service

import Curso.Kotlin.credit.aplication.system.Model.Credit
import java.util.*

interface ICreditService {

    fun save(credit: Credit) : Credit

    fun findByAllCostumer(costumerId: Long) : List<Credit>

    fun findByCreditCode(costumerId: Long , creditCode: UUID) : Credit
}