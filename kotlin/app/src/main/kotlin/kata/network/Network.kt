package kata.network

import jakarta.persistence.Entity
import jakarta.persistence.Id
import kata.concept.Validator

@Entity
class Network private constructor(
    @Id val id: String
) {
    constructor(dto: NetworkDto, validator: Validator<Network>) : this(dto.id) {
        validator.validate(this)
    }

}