package kata.network

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface NetworkRepository : JpaRepository<Network, String> {
}