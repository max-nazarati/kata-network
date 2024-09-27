package kata.exception.presentation

import kata.exception.ErrorKey
import kata.exception.ValidationException

data class PersistenceExceptionDto(val errorKey: ErrorKey, val context: List<String> = listOf("")) {
    constructor(errorKey: ValidationException) : this(errorKey.errorKey, errorKey.context)
}