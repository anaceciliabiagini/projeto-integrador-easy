package recursos;

import java.util.List;

import entidades.Transacao;
import io.quarkus.panache.common.Sort;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/transacao")
public class TransacaoResource {

    @GET
    public List<Transacao> listar() {
        return Transacao.listAll(Sort.descending("data"));
    }

    @POST
    @Transactional
    public Transacao salvar(Transacao transacao) {
        transacao.persist();
        return transacao;
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Transacao atualizar(@PathParam("id") Long id, Transacao transacao) {
        Transacao transacaoExistente = Transacao.findById(id);
        if (transacaoExistente != null) {
            transacaoExistente.tipo = transacao.tipo;
            transacaoExistente.valor = transacao.valor;
            transacaoExistente.data = transacao.data;
            transacaoExistente.descricao = transacao.descricao;
            transacaoExistente.categoria = transacao.categoria;
            transacaoExistente.usuario = transacao.usuario;
            transacaoExistente.persist();
            return transacaoExistente;
        }
        return null;
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void remover(@PathParam("id") Long id) {
        Transacao transacao = Transacao.findById(id);
        if (transacao != null) {
            transacao.delete();
        }
    }
}

