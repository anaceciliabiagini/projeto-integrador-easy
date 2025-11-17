package recursos;

import java.util.List;

import entidades.Transacao;
import io.quarkus.panache.common.Sort;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

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
}

