package Curso.Kotlin.credit.aplication.system.Service

import Curso.Kotlin.credit.aplication.system.Model.CreditEntity
import java.util.*

interface Credit {

    fun save(credit: CreditEntity) : CreditEntity

    fun findByAllCostumer(costumerId: Long) : List<CreditEntity>

    fun findByCreditCode(costumerId: Long , creditCode: UUID) : CreditEntity
}