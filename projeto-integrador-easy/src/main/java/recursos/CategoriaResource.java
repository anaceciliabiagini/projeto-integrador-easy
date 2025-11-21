package recursos;

import java.util.List;

import entidades.Categoria;
import io.quarkus.panache.common.Sort;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/categoria")
public class CategoriaResource {

    @GET
    public List<Categoria> listar() {
        return Categoria.listAll(Sort.ascending("nome"));
    }

    @POST
    @Transactional
    public Categoria salvar(Categoria categoria) {
        categoria.persist();
        return categoria;
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public void atualizar(@PathParam("id") Long id, Categoria categoria) {
        Categoria categoriaExistente = Categoria.findById(id);
        if (categoriaExistente != null) {
            categoriaExistente.nome = categoria.nome;
            categoriaExistente.tipo = categoria.tipo;
            categoriaExistente.persist();
        }
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void remover(@PathParam("id") Long id) {
        Categoria categoria = Categoria.findById(id);
        if (categoria != null) {
            categoria.delete();
        }
    }
}

