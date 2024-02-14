package Curso.Kotlin.credit.aplication.system.controllers

import Curso.Kotlin.credit.aplication.system.Model.Customer
import Curso.Kotlin.credit.aplication.system.Service.Implement.CostumerService
import Curso.Kotlin.credit.aplication.system.controllers.dto.CustomerDTO
import Curso.Kotlin.credit.aplication.system.controllers.dto.CustomerUpdateDto
import Curso.Kotlin.credit.aplication.system.controllers.dto.CustomerView
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/costumers")
class CustomerResource(
    private val costumerService: CostumerService
) {

    @PostMapping
    fun saveCostumer(@RequestBody costumerDto: CustomerDTO): String {
        val savedCostumer = this.costumerService.save(costumerDto.toEntity())

        return "Costumer ${savedCostumer.email} saved!"

    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): CustomerView {
        val costumer: Customer = this.costumerService.findById(id);

        return CustomerView(costumer);

    }

    @DeleteMapping("/{deleteId}")
    fun deleteCustomer(@PathVariable id: Long) =
        this.costumerService.delete(id);

    @PatchMapping("/update")
    fun updateCostumer(@RequestParam(value = "customerId") id: Long,
                       @RequestBody customerUpdateDto: CustomerUpdateDto): CustomerView {
       val customer : Customer =  this.costumerService.findById(id)
       val customerUpdate : Customer =  customerUpdateDto.toEntity(customer)
       val customerUpdated : Customer =  this.costumerService.save(customerUpdate)

        return CustomerView(customerUpdated)

    }
}

