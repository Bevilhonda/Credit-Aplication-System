package Curso.Kotlin.credit.aplication.system.service

import Curso.Kotlin.credit.aplication.system.model.Costumer

interface Costumer {

    fun save(costumer : Costumer) : Costumer

    fun findById( id : Long) : Costumer

    fun delete(id: Long)
}