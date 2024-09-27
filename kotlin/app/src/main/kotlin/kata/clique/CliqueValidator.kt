package kata.clique

import kata.concept.Validator
import kata.exception.ErrorKey
import kata.exception.ValidationException
import org.springframework.stereotype.Service

@Service
class CliqueValidator(
    private val repository: CliqueRepository
) : Validator<Clique> {
    override fun validate(t: Clique) {
        if (repository.existsById(t.id)) {
            throw ValidationException(ErrorKey.ALREADY_EXISTS)
        }
    }
}