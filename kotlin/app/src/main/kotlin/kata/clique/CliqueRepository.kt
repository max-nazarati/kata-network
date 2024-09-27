package kata.clique

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CliqueRepository : JpaRepository<Clique, String> {
    fun findByNetworkIdAndId(networkId: String, id: String) : Clique?

    fun deleteByNetworkIdAndId(networkId: String, id: String)
}