package Curso.Kotlin.credit.aplication.system.Service.Implement

import Curso.Kotlin.credit.aplication.system.Repository.CreditRepository
import Curso.Kotlin.credit.aplication.system.Service.Credit
import java.util.*
import org.springframework.stereotype.Service
import Curso.Kotlin.credit.aplication.system.Model.CreditEntity

@Service
class CreditService(
    private val creditRepository: CreditRepository,
    private val customerService: CostumerService
) : Credit {
    override fun save(credit: CreditEntity): CreditEntity {
        credit.apply {// função apply do kotlin
            customer = customerService.findById(credit.customer?.id!!)
        } // com o apply verifica se o costumer que esta tentando salvar no banco existe
        return this.creditRepository.save(credit)
    }

    override fun findByAllCostumer(costumerId: Long): List<CreditEntity> =
        this.creditRepository.findAllByCostumerId(costumerId)


    override fun findByCreditCode(costumerId: Long,creditCode: UUID): CreditEntity {
        val credit: CreditEntity =(this.creditRepository.findByCreditCode(creditCode)
                ?: throw RuntimeException("CreditCode $creditCode not found"))

        if (credit.customer?.id == costumerId) {
            return credit
        } else {
            throw RuntimeException("Contact Administrador")
        }
    }
}