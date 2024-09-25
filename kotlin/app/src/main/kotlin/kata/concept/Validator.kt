package kata.concept

interface Validator<T> {
    fun validate(t: T)
}