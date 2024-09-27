package kata.clique

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import kata.concept.Validator
import kata.network.Network

@Entity
class Clique private constructor(
    @Id val id: String,
    @ManyToOne @JoinColumn(name = "network_id") val network: Network
) {
    constructor(dto: CliqueDto, network: Network, validator: Validator<Clique>)
            : this(dto.id, network) {
        validator.validate(this)
    }
}