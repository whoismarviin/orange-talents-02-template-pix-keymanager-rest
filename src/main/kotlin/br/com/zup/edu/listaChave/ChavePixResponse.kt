package br.com.zup.edu.listaChave

import br.com.zup.edu.ListaChavesResponse
import io.micronaut.core.annotation.Introspected
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneOffset

@Introspected
class ChavePixResponse(chavePix: ListaChavesResponse.ChavePix) {
    val id = chavePix.pixID
    val chave = chavePix.chave
    val tipo = chavePix.tipo
    val tipoConta = chavePix.tipoDeConta
    val criadaEm = chavePix.criadaEm.let {
        LocalDateTime.ofInstant(Instant.ofEpochSecond(it.seconds, it.nanos.toLong()), ZoneOffset.UTC)
    }

}
