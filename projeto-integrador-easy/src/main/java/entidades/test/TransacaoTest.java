import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import jakarta.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

@QuarkusTest
public class TransacaoTest {

    @Test
    @Transactional
    public void testSalvaUmaTransacao() {
        Usuario usuario = new Usuario();
        usuario.nome = "Easy Teste";
        usuario.email = "easy.teste@email.com";
        usuario.senha = "Easy@123";
        usuario.persist();

        Categoria categoria = new Categoria();
        categoria.nome = "Alimentacao";
        categoria.tipo = "Despesa";
        categoria.persist();

        Transacao transacao = new Transacao();
        transacao.tipo = "Saida";
        transacao.valor = new BigDecimal("150.75");
        transacao.data = LocalDate.now();
        transacao.descricao = "mercado";
        transacao.usuario = usuario;
        transacao.categoria = categoria;
        transacao.persist();

        Assertions.assertNotNull(transacao.id);
        
        Optional<Transacao> transacaoSalva = Transacao.findByIdOptional(transacao.id);
        Assertions.assertTrue(transacaoSalva.isPresent());
        Assertions.assertEquals("Saída", transacaoSalva.get().tipo);
        Assertions.assertEquals(new BigDecimal("150.75"), transacaoSalva.get().valor);
        Assertions.assertEquals("easy.teste@email.com", transacaoSalva.get().usuario.email);
        Assertions.assertEquals("Alimentacao", transacaoSalva.get().categoria.nome);
    }
}