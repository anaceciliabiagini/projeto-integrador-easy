import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;
import entidades.Usuario;
import entidades.Investimento;

@QuarkusTest
public class InvestimentoTest {

    @Test
    @Transactional
    public void testSalvaUmInvestimento() {
        Usuario usuario = new Usuario();
        usuario.nome = "Easy teste";
        usuario.email = "easy.teste@email.com";
        usuario.senha = "Easy@123";
        usuario.persist();

        Investimento investimento = new Investimento();
        investimento.valorAplicado = new BigDecimal("2500,00");
        investimento.dataAplicacao = LocalDate.of(2025, 9, 24);
        investimento.tipoInvestimento = "Poupança";
        investimento.usuario = usuario;

        investimento.persist();
        Assertions.assertNotNull(investimento.id);
        
        Optional<Investimento> investimentoSalvo = Investimento.findByIdOptional(investimento.id);
        Assertions.assertTrue(investimentoSalvo.isPresent());
        Assertions.assertEquals(new BigDecimal("2500.50"), investimentoSalvo.get().valorAplicado);
        Assertions.assertEquals("Poupança", investimentoSalvo.get().tipoInvestimento);
        Assertions.assertEquals("Easy teste", investimentoSalvo.get().usuario.nome);
    }
}