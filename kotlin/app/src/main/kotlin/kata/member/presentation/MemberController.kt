package kata.member.presentation

import jakarta.transaction.Transactional
import kata.clique.CliqueRepository
import kata.concept.Validator
import kata.exception.ErrorKey
import kata.exception.ValidationException
import kata.member.Member
import kata.member.MemberDto
import kata.member.MemberRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("network/{networkId}/clique/{cliqueId}")
class MemberController(
    private val validator: Validator<Member>,
    private val repository: MemberRepository,
    private val cliqueRepository: CliqueRepository
) {
    @PostMapping
    fun create(
        @PathVariable networkId: String,
        @PathVariable cliqueId: String,
        @RequestBody dto: MemberDto
    ): MemberDto {
        val clique = cliqueRepository.find(networkId, cliqueId)
            ?: throw ValidationException(
                ErrorKey.NOT_FOUND,
                listOf("the hierarchy 'network/$networkId/clique/$cliqueId' does not exist")
            )
        val member = Member(dto, clique, validator)

        val savedMember = repository.save(member)
        return MemberDto(savedMember)
    }

    @GetMapping("{memberId}")
    fun get(
        @PathVariable networkId: String,
        @PathVariable cliqueId: String,
        @PathVariable memberId: String
    ): MemberDto {
        return repository.find(networkId, cliqueId, memberId)?.let { MemberDto(it) }
            ?: throw ValidationException(ErrorKey.NOT_FOUND)
    }

    @DeleteMapping("{memberId}")
    @Transactional
    fun delete(
        @PathVariable networkId: String,
        @PathVariable cliqueId: String,
        @PathVariable memberId: String
    ) {
        repository.deleteByCliqueIdAndId(networkId, cliqueId)
    }

}