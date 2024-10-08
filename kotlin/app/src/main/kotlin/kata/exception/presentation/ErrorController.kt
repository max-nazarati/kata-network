package kata.exception.presentation

import kata.exception.ErrorKey
import kata.exception.ValidationException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ErrorController {

    @ExceptionHandler(value = [ValidationException::class])
    fun persistenceExceptionHandler(e: ValidationException) : ResponseEntity<PersistenceExceptionDto> {
        return ResponseEntity(PersistenceExceptionDto(e), keyToHttpStatus(e.errorKey))
    }

    private fun keyToHttpStatus(key: ErrorKey) : HttpStatus {
        return when (key) {
            ErrorKey.ALREADY_EXISTS -> HttpStatus.BAD_REQUEST
            ErrorKey.NOT_FOUND -> HttpStatus.NOT_FOUND
        }
    }
}