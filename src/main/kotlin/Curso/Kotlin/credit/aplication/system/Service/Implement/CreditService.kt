package Curso.Kotlin.credit.aplication.system.Service.Implement

import Curso.Kotlin.credit.aplication.system.Repository.CreditRepository
import Curso.Kotlin.credit.aplication.system.Service.Credit
import org.hibernate.validator.constraints.UUID
import org.springframework.stereotype.Service

@Service
class CreditService(
    private val creditRepository: CreditRepository,
    private val customerService: CostumerService
) : Credit {
    override fun save(credit: Curso.Kotlin.credit.aplication.system.Model.Credit): Curso.Kotlin.credit.aplication.system.Model.Credit {
        credit.apply {// função apply do kotlin
            costumer = customerService.findById(credit.costumer?.id!!)
        } // com o apply verifica se o costumer que esta tentando salvar no banco existe
        return this.creditRepository.save(credit)
    }

    override fun findByAllCostumer(costumerId: Long): List<Curso.Kotlin.credit.aplication.system.Model.Credit>
    = this.creditRepository.findAllByCostumerId(costumerId)



    override fun findByCreditCode(
        costumerId: Long,
        creditCode: UUID
    ): Curso.Kotlin.credit.aplication.system.Model.Credit {
        val credit: Curso.Kotlin.credit.aplication.system.Model.Credit =
            (this.creditRepository.findByCreditCode(creditCode)
                ?: throw RuntimeException("CreditCode $creditCode not found"))

        if (credit.costumer?.id == costumerId) {
            return credit
        } else {
            throw RuntimeException("Contact Administrador")
        }
    }
}