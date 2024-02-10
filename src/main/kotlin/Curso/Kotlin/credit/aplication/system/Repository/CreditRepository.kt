package Curso.Kotlin.credit.aplication.system.Repository

import Curso.Kotlin.credit.aplication.system.Model.Credit
import org.hibernate.validator.constraints.UUID
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository


@Repository
interface CreditRepository: JpaRepository<Credit,Long>{
    fun findByCreditCode(creditCode : UUID) : Credit

    @Query(value = "Select * from Credit where CUSTUMER_ID = ?1 ", nativeQuery = true)
    fun findAllByCostumerId(costumerId : Long): List<Credit>

    // usa o ?1 porque só temos um parametro neste exemplo , que é o costumerId do tipo Long

}

