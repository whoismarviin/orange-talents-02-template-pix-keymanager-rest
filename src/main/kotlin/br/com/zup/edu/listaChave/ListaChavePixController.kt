package br.com.zup.edu.listaChave

import br.com.zup.edu.ListaChavePixRequest
import br.com.zup.edu.PixListaChavesPorClienteGrpc
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Get
import java.util.*
import javax.inject.Inject

class ListaChavePixController(
    @Inject private val listaChavePixClient:
    PixListaChavesPorClienteGrpc.PixListaChavesPorClienteBlockingStub
) {

    @Get("/{clienteId}/pix/")
    fun lista(clienteId: UUID): HttpResponse<Any> {

        val pix = listaChavePixClient.lista(
            ListaChavePixRequest.newBuilder()
                .setClienteId(clienteId.toString())
                .build()
        )

        val chaves = pix.chavesList.map { ChavePixResponse(it) }


        return HttpResponse.ok(chaves)
    }
}