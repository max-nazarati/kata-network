package kata.exception.presentation

import kata.exception.ErrorKey
import kata.exception.PersistenceException

data class PersistenceExceptionDto(val errorKey: ErrorKey, val context: List<String> = listOf("")) {
    constructor(errorKey: PersistenceException) : this(errorKey.errorKey, errorKey.context)
}