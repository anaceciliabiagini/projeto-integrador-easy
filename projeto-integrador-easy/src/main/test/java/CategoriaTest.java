package entidades;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import jakarta.transaction.Transactional;
import java.util.Optional;

@QuarkusTest
public class CategoriaTest {

    @Test
    @Transactional
    public void testSalvaUmaCategoria() {
        Categoria categoria = new Categoria();
        categoria.nome = "Alimentacao";
        categoria.tipo = "Casa";

        categoria.persist();
        Assertions.assertNotNull(categoria.id);
        
        Optional<Categoria> categoriaSalva = Categoria.findByIdOptional(categoria.id);
        Assertions.assertTrue(categoriaSalva.isPresent());
        Assertions.assertEquals("Alimentacao", categoriaSalva.get().nome);
    }
}