package kata.network

import jakarta.persistence.Embeddable
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import kata.clique.Clique
import kata.member.Member
import java.io.Serializable

@Embeddable
class NetworkExclusionRule(
    @ManyToOne @JoinColumn(name = "excluded_network_id") val excludedNetwork: Network,
    @ManyToOne @JoinColumn(name = "excluded_clique_id") val excludedClique: Clique?,
    @ManyToOne @JoinColumn(name = "excluded_member_id") val excludedMember: Member?,
) : Serializable {

    fun isNetworkExclusion() : Boolean {
        return excludedClique == null && excludedMember == null
    }

    fun isCliqueExclusion() : Boolean {
        return excludedClique != null && excludedMember == null
    }

    fun isMemberExclusion() : Boolean {
        return excludedClique != null && excludedMember != null
    }
}