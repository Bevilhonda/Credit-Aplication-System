package Curso.Kotlin.credit.aplication.system.Service.Implement

import Curso.Kotlin.credit.aplication.system.Repository.CreditRepository
import java.util.*
import org.springframework.stereotype.Service
import Curso.Kotlin.credit.aplication.system.Model.Credit
import Curso.Kotlin.credit.aplication.system.Service.ICreditService
import Curso.Kotlin.credit.aplication.system.exceptions.BusinesExceptions
import java.time.LocalDate

@Service
class CreditService(
    private val creditRepository: CreditRepository,
    private val customerService: CustomerService
) : ICreditService {
    override fun save(credit: Credit): Credit {
        credit.apply {// função apply do kotlin
            customer = customerService.findById(credit.customer?.id!!)
        } // com o apply verifica se o costumer que esta tentando salvar no banco existe
        return this.creditRepository.save(credit)
    }

    override fun findByAllCostumer(costumerId: Long): List<Credit> =
        this.creditRepository.findAllByCostumerId(costumerId)


    override fun findByCreditCode(costumerId: Long, creditCode: UUID): Credit {
        val credit: Credit = (this.creditRepository.findByCreditCode(creditCode)
            ?: throw BusinesExceptions("Creditcode $creditCode not found"))
        return if (credit.customer?.id == costumerId) credit
        else throw IllegalArgumentException("Contact admin")

        /*if (credit.customer?.id == costumerId) {
            return credit
        } else {
            throw RuntimeException("Contact Administrador")
        }

         */
    }
    private fun validDayFirstInstallment(dayFirstInstallment: LocalDate): Boolean {
        return if (dayFirstInstallment.isBefore(LocalDate.now().plusMonths(3))) true
        else throw BusinesExceptions("Invalid Date")
    }
}