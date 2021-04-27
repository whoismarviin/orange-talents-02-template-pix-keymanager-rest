package br.com.zup.edu.deletaChave

import br.com.zup.edu.RemoveChavePixRequest
import br.com.zup.edu.RemoveChavePixServiceGrpc
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Delete
import java.util.*
import javax.inject.Inject


@Controller("/api/clientes")
class deletaChaveEndpoint(@Inject private val deletaGrpc: RemoveChavePixServiceGrpc.RemoveChavePixServiceBlockingStub) {

    @Delete("{cliente_id}/pix/{pixId}")
    fun removeChavePix(clienteId: UUID, pixId: UUID): HttpResponse<Any> {

        deletaGrpc.remove(
            RemoveChavePixRequest.newBuilder()
                .setClientId(clienteId.toString())
                .setPixId(pixId.toString())
                .build()
        )

        return HttpResponse.accepted()

    }


}