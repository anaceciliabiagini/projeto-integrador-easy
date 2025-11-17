package recursos;

import java.util.List;

import entidades.Investimento;
import io.quarkus.panache.common.Sort;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

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
}

