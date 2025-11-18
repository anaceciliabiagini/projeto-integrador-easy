package entidades;

import java.util.List;

import jakarta.json.bind.annotation.JsonbTransient;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(nullable = false)
    public String nome;

    @Column(unique = true)
    public String email;

    public String senha;

    @JsonbTransient
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    public List<Transacao> transacoes;

    @JsonbTransient
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    public List<Investimento> investimentos;
};