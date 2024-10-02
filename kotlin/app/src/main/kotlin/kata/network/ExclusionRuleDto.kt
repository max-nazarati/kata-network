package kata.network

data class ExclusionRuleDto(
    val excludedNetworks: Set<String>?,
    val excludedCliques: Set<String>?,
    val excludedMembers: Set<String>?
) {
    constructor(exclusionRules: Set<NetworkExclusionRule>)
            : this(
        exclusionRules.filter { it.isNetworkExclusion() }.map { it.excludedNetwork.id }.toSet(),
        exclusionRules.filter { it.isCliqueExclusion() }.map { it.excludedClique!!.id }.toSet(),
        exclusionRules.filter { it.isMemberExclusion() }.map { it.excludedMember!!.id }.toSet()
    )
}
