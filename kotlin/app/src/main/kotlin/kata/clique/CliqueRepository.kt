package kata.clique

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface CliqueRepository : JpaRepository<Clique, String> {
    fun deleteByNetworkIdAndId(networkId: String, id: String)

    @Query(value = """
        select b from Clique b
        where b.network.id = :networkId and b.id = :id
    """)
    fun find(networkId: String, id: String) : Clique?
}