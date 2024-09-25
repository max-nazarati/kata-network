package kata.network.presentation

import kata.exception.ErrorKey
import kata.exception.PersistenceException
import kata.concept.Validator
import kata.network.Network
import kata.network.NetworkDto
import kata.network.NetworkRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("network")
class NetworkController(
    private val validator: Validator<Network>,
    private val repository: NetworkRepository
) {

    @PostMapping
    fun create(@RequestBody dto: NetworkDto) : NetworkDto {
        val network = Network(dto, validator)

        val savedNetwork = repository.save(network)
        return NetworkDto(savedNetwork)
    }

    @GetMapping("{id}")
    fun get(@PathVariable id: String) : NetworkDto {
        val model = repository.findByIdOrNull(id)

        return model?.let {NetworkDto(it)} ?: throw PersistenceException(ErrorKey.NOT_FOUND)
    }

}