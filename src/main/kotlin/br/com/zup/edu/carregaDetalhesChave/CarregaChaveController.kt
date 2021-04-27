package br.com.zup.edu.carregaDetalhesChave

import br.com.zup.edu.CarregaChavePixRequest
import br.com.zup.edu.CarregaChavePixServiceGrpc
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import java.util.*
import javax.inject.Inject


@Controller("api/clientes")
class CarregaChaveController(@Inject private val carregaChaveGRPC: CarregaChavePixServiceGrpc.CarregaChavePixServiceBlockingStub) {


    @Get("/{cliente_id}/pix/{pixId}")
    fun carregaChavePix(clienteId: UUID, pixId: UUID): HttpResponse<Any> {
        val carregaChavePixResponse = carregaChaveGRPC.consulta(
            CarregaChavePixRequest.newBuilder()
                .setPixId(
                    CarregaChavePixRequest.FiltroPorPixId.newBuilder()
                        .setClientId(clienteId.toString())
                        .setPixId(pixId.toString())
                        .build()
                )
                .build()
        )

        return HttpResponse.accepted()

    }
}