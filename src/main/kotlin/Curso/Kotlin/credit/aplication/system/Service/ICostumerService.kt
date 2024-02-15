package Curso.Kotlin.credit.aplication.system.Service

import Curso.Kotlin.credit.aplication.system.Model.Customer

interface Costumer {

    fun save(costumer : Customer) : Customer

    fun findById( id : Long) : Customer

    fun delete(id: Long)
}