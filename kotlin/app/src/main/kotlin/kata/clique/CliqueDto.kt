package kata.clique

data class CliqueDto(val id: String) {
    constructor(clique: Clique) : this(clique.id)
}
