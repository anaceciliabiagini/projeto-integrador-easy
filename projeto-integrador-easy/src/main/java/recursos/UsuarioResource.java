package recursos;

import java.util.List;

import entidades.Usuario;
import io.quarkus.panache.common.Sort;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/usuario")
public class UsuarioResource {

    @GET
    public List<Usuario> listar() {
        return Usuario.listAll(Sort.ascending("nome"));
    }

    @POST
    @Transactional
    public Usuario salvar(Usuario usuario) {
        usuario.persist();
        return usuario;
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public void atualizar(@PathParam("id") Long id, Usuario usuario) {
        Usuario usuarioExistente = Usuario.findById(id);
        if (usuarioExistente != null) {
            usuarioExistente.nome = usuario.nome;
            usuarioExistente.email = usuario.email;
            usuarioExistente.senha = usuario.senha;
            usuarioExistente.persist();
        }
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void remover(@PathParam("id") Long id) {
        Usuario usuario = Usuario.findById(id);
        if (usuario != null) {
            usuario.delete();
        }
    }
}

