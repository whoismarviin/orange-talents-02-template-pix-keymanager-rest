package br.com.zup.edu.RegistraChave

import br.com.zup.edu.RegistraChavePixRequest
import br.com.zup.edu.TipoChave
import br.com.zup.edu.TipoConta
import io.micronaut.core.annotation.Introspected
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size


@Introspected
class RegistraChaveRequest(
    val clienteId: String,
    @field:NotNull
    val tipoChave: TipoChave,
    @field:Size(max = 77)
    val chave: String,
    @field:NotNull
    val tipoConta: TipoConta
) {
    fun toModel(): RegistraChavePixRequest? {
        return RegistraChavePixRequest.newBuilder()
            .setChave(this.chave)
            .setClienteId(this.clienteId)
            .setTipoConta(this.tipoConta)
            .setTipoChave(this.tipoChave)
            .build()

    }
}
