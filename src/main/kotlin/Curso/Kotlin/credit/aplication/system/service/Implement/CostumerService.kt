package Curso.Kotlin.credit.aplication.system.service.Implement

import Curso.Kotlin.credit.aplication.system.repository.CostumerRepository
import Curso.Kotlin.credit.aplication.system.service.Costumer
import org.springframework.stereotype.Service

@Service
class CostumerService(
    private val costumerRepository: CostumerRepository
) : Costumer {
    override fun save(costumer: Curso.Kotlin.credit.aplication.system.model.Costumer): Curso.Kotlin.credit.aplication.system.model.Costumer =
        this.costumerRepository.save(costumer)

    override fun findById(id: Long): Curso.Kotlin.credit.aplication.system.model.Costumer =
        this.costumerRepository.findById(id).orElseThrow {
            throw RuntimeException("ID $id not found")
        }
    override fun delete(id: Long) =
        this.costumerRepository.deleteById(id)

}