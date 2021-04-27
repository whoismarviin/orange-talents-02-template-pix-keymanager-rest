package br.com.zup.edu.shared

import br.com.zup.edu.CarregaChavePixServiceGrpc
import br.com.zup.edu.CriaChavePixServiceGrpc
import br.com.zup.edu.PixListaChavesPorClienteGrpc
import br.com.zup.edu.RemoveChavePixServiceGrpc
import io.grpc.ManagedChannel
import io.micronaut.context.annotation.Factory
import io.micronaut.grpc.annotation.GrpcChannel
import javax.inject.Singleton


@Factory
class KeyManagerGrpcFactory(@GrpcChannel("keyManager") val channel: ManagedChannel) {

    @Singleton
    fun registraChave() = CriaChavePixServiceGrpc.newBlockingStub(channel)

    @Singleton
    fun deletaChave() = RemoveChavePixServiceGrpc.newBlockingStub(channel)

    @Singleton
    fun listaChaves() = PixListaChavesPorClienteGrpc.newBlockingStub(channel)

    @Singleton
    fun carregaChave() = CarregaChavePixServiceGrpc.newBlockingStub(channel)
}