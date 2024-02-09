package Curso.Kotlin.credit.aplication.system.Service

import Curso.Kotlin.credit.aplication.system.Model.Costumer

interface Costumer {

    fun save(costumer : Costumer) : Costumer

    fun findById( id : Long) : Costumer

    fun delete(id: Long)
}