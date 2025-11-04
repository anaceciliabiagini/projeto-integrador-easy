package recursos;

import java.util.List;

import entidades.Usuario;
import io.quarkus.panache.common.Sort;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/usuario")
public class UsuarioResource {

    @GET
    public List<Usuario> listar() {
        return Usuario.listAll(Sort.ascending("nome"));
    }
}

