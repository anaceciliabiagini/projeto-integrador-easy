import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import jakarta.transaction.Transactional;
import java.util.Optional;

@QuarkusTest
public class UsuarioTest {

    @Test
    @Transactional
    public void testSalvaUmUsuario() {
        Usuario usuario = new Usuario();
        usuario.nome = "Easy Teste";
        usuario.email = "easy.teste@email.com";
        usuario.senha = "Easy@123";

        usuario.persist();
        Assertions.assertNotNull(usuario.id);
        
        Optional<Usuario> usuarioSalvo = Usuario.findByIdOptional(usuario.id);
        Assertions.assertTrue(usuarioSalvo.isPresent());
        Assertions.assertEquals("easy.teste@email.com", usuarioSalvo.get().email);
    }
}