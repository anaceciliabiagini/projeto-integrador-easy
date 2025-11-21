package recursos;

import java.util.List;

import entidades.Investimento;
import io.quarkus.panache.common.Sort;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/investimento")
public class InvestimentoResource {

    @GET
    public List<Investimento> listar() {
        return Investimento.listAll(Sort.ascending("dataAplicacao"));
    }

    @POST
    @Transactional
    public Investimento salvar(Investimento investimento) {
        investimento.persist();
        return investimento;
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Investimento atualizar(@PathParam("id") Long id, Investimento investimento) {
        Investimento investimentoExistente = Investimento.findById(id);
        if (investimentoExistente != null) {
            investimentoExistente.valorAplicado = investimento.valorAplicado;
            investimentoExistente.dataAplicacao = investimento.dataAplicacao;
            investimentoExistente.tipoInvestimento = investimento.tipoInvestimento;
            investimentoExistente.usuario = investimento.usuario;
            investimentoExistente.persist();
            return investimentoExistente;
        }
        return null;
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void remover(@PathParam("id") Long id) {
        Investimento investimento = Investimento.findById(id);
        if (investimento != null) {
            investimento.delete();
        }
    }
}

