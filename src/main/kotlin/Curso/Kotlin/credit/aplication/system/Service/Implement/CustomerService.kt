package Curso.Kotlin.credit.aplication.system.Service.Implement

import Curso.Kotlin.credit.aplication.system.Model.Customer
import Curso.Kotlin.credit.aplication.system.Repository.CustomerRepository
import Curso.Kotlin.credit.aplication.system.Service.ICostumerService
import Curso.Kotlin.credit.aplication.system.exceptions.BusinesExceptions
import org.springframework.stereotype.Service

@Service
class CustomerService(
    private val customerRepository: CustomerRepository
) : ICostumerService {
    override fun save(costumer: Customer): Customer =
        this.customerRepository.save(costumer)

    override fun findById(id: Long): Customer =
        this.customerRepository.findById(id).orElseThrow {
            throw BusinesExceptions("ID $id not found")
        }
    override fun delete(id: Long){
        val customer : Customer =  this.findById(id)
        this.customerRepository.delete(customer)
    }

}