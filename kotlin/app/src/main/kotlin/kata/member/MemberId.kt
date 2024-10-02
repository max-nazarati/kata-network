package kata.member

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import java.io.Serializable

@Embeddable
class MemberId(
    @Column(name = "id") val id: String,
    @Column(name = "clique_id") val cliqueId: String,
    @Column(name = "network_id") val networkId: String
) : Serializable {
}