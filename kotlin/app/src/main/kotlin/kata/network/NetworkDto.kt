package kata.network

import kata.network.Network

data class NetworkDto(val id: String) {
    constructor(model: Network) : this(model.id)
}
