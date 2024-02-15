package Curso.Kotlin.credit.aplication.system.Repository

import Curso.Kotlin.credit.aplication.system.Model.CreditEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.UUID


@Repository
interface CreditRepository: JpaRepository<CreditEntity,Long>{
    fun findByCreditCode(creditCode : UUID) : CreditEntity

    @Query(value = "Select * from Credit where CUSTUMER_ID = ?1 ", nativeQuery = true)
    fun findAllByCostumerId(costumerId : Long): List<CreditEntity>

    // usa o ?1 porque só temos um parametro neste exemplo , que é o costumerId do tipo Long

}

