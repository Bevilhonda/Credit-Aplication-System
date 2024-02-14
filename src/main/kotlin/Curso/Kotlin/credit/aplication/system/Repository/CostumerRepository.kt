package Curso.Kotlin.credit.aplication.system.Repository

import Curso.Kotlin.credit.aplication.system.Model.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CostumerRepository: JpaRepository<Customer,Long>
