package kata.member

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import kata.clique.Clique
import kata.concept.Validator
import kata.network.Network

@Entity
class Member private constructor(
    @Id val id: String,
    @ManyToOne @JoinColumn(name = "clique_id") val clique: Clique
) {
    constructor(dto: MemberDto, clique: Clique, validator: Validator<Member>)
            : this(dto.id, clique) {
        validator.validate(this)
    }
}