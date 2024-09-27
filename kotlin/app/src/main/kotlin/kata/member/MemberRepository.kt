package kata.member

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface MemberRepository : JpaRepository<Member, String> {
    @Query(value = """
        select m from Member m
        where m.clique.network.id = :networkId and m.clique.id = :cliqueId and m.id = :id
    """)
    fun find(networkId: String, cliqueId: String, id: String) : Member?

    fun deleteByCliqueIdAndId(networkId: String, id: String)
}