package kata.clique.presentation

import jakarta.transaction.Transactional
import kata.clique.Clique
import kata.clique.CliqueDto
import kata.clique.CliqueRepository
import kata.concept.Validator
import kata.exception.ErrorKey
import kata.exception.ValidationException
import kata.network.NetworkRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("network/{networkId}/clique")
class CliqueController(
    private val validator: Validator<Clique>,
    private val repository: CliqueRepository,
    private val networkRepository: NetworkRepository
) {
    @PostMapping
    fun create(@PathVariable networkId: String, @RequestBody dto: CliqueDto): CliqueDto {
        val network = networkRepository.findByIdOrNull(networkId)
            ?: throw ValidationException(ErrorKey.NOT_FOUND, listOf("parent network does not exist"))
        val clique = Clique(dto, network, validator)

        val savedClique = repository.save(clique)
        return CliqueDto(savedClique)
    }

    @GetMapping("{cliqueId}")
    fun get(@PathVariable networkId: String, @PathVariable cliqueId: String): CliqueDto {
        return repository.find(networkId, cliqueId)?.let { CliqueDto(it) }
            ?: throw ValidationException(ErrorKey.NOT_FOUND)
    }

    @DeleteMapping("{cliqueId}")
    @Transactional
    fun delete(@PathVariable networkId: String, @PathVariable cliqueId: String) {
        repository.deleteByNetworkIdAndId(networkId, cliqueId)
    }

}