package Curso.Kotlin.credit.aplication.system.Repository

import Curso.Kotlin.credit.aplication.system.Model.Credit
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CreditRepository: JpaRepository<Credit,Long>

