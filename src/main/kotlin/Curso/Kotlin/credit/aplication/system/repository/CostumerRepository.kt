package Curso.Kotlin.credit.aplication.system.repository

import Curso.Kotlin.credit.aplication.system.model.Costumer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CostumerRepository: JpaRepository<Costumer,Long>
