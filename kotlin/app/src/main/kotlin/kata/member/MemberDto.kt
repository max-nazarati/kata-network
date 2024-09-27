package kata.member

data class MemberDto(val id: String) {
    constructor(clique: Member) : this(clique.id)
}
