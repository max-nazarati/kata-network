package kata.exception

import kata.exception.ErrorKey

class PersistenceException(val errorKey: ErrorKey, val context: List<String> = listOf("")) : RuntimeException() {
}