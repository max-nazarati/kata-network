package kata.exception

import kata.exception.ErrorKey

class PersistenceException(val errorKey: ErrorKey, context: List<String> = listOf("")) : RuntimeException() {
}