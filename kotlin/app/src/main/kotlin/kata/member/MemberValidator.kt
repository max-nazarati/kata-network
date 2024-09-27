package kata.member

import kata.concept.Validator
import kata.exception.ErrorKey
import kata.exception.ValidationException
import org.springframework.stereotype.Service

@Service
class MemberValidator(
    private val repository: MemberRepository
) : Validator<Member> {
    override fun validate(t: Member) {
        if (repository.existsById(t.id)) {
            throw ValidationException(ErrorKey.ALREADY_EXISTS)
        }
    }
}