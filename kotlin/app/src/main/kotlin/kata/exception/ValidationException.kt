package kata.exception

class ValidationException(val errorKey: ErrorKey, val context: List<String> = listOf("")) : RuntimeException() {
}