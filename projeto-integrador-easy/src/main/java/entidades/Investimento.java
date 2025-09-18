package entidades;

import java.math.BigDecimal;
import java.time.LocalDate;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "investimento")
public class Investimento extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(nullable = false, precision = 10, scale = 2)
    public BigDecimal valorAplicado;

    @Column(nullable = false)
    public LocalDate dataAplicacao;

    @Column(nullable = false)
    public String tipoInvestimento;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    public Usuario usuario;
}