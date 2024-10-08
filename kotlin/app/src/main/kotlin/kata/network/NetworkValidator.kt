package kata.network

import kata.exception.ErrorKey
import kata.exception.ValidationException
import kata.concept.Validator
import org.springframework.stereotype.Service

@Service
class NetworkValidator(
    private val repository: NetworkRepository
) : Validator<Network> {
    override fun validate(t: Network) {
        if (repository.existsById(t.id)) {
            throw ValidationException(ErrorKey.ALREADY_EXISTS)
        }
    }
}