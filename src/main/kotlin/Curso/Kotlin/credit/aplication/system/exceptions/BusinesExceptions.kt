package Curso.Kotlin.credit.aplication.system.exceptions

data class BusinesExceptions(override val message: String?) : RuntimeException(message) {
}