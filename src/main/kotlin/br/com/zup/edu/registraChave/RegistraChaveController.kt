package br.com.zup.edu.registraChave

import br.com.zup.edu.CriaChavePixServiceGrpc
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import javax.inject.Inject
import javax.validation.Valid


@Validated
@Controller("/api/v1/clientes/{cliente_id}")
open class RegistraChaveController(
    @Inject val grpcClient: CriaChavePixServiceGrpc.CriaChavePixServiceBlockingStub
) {

    @Post("/pix")
    fun registraChave(@Valid @Body form: RegistraChaveRequest): HttpResponse<Any> {

        val request = form.toModel();

        val response = grpcClient.registra(request)


        return HttpResponse.created(RegistraChaveResponse(clienteId = response.clienteId, pixId = response.pixId))


    }


}