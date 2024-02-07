package Curso.Kotlin.credit.aplication.system.Model

import jakarta.persistence.*
import Curso.Kotlin.credit.aplication.system.Enumeration.Status
import java.math.BigDecimal
import java.time.LocalDate
import java.util.UUID

@Entity
@Table(name = "Credito")
data class Credit(
    @Column(nullable = false , unique = true ) val creditCode : UUID = UUID.randomUUID(),
    @Column(nullable = false  ) val creditValue : BigDecimal  = BigDecimal.ZERO,
    @Column(nullable = false  ) val dayFirstInstalmente : LocalDate,
    @Column(nullable = false ) val numberOffInstalmente : Int = 0,
    @Enumerated val status : Status = Status.IN_PROGRESS,
    @ManyToOne val costumer : Costumer? = null,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id : Long? = null
)
