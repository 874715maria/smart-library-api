package bibliotecaInteligente.api.modules.livro.model;

import bibliotecaInteligente.api.modules.emprestimo.model.Emprestimo;
import bibliotecaInteligente.api.modules.user.model.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;

@Entity
@Table(name = "tb_livros")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Integer id;
    @Column
    private String titulo;
    @Column
    private String autor;

    @Column
    private String descricao;
    @ManyToOne
    @JoinColumn(name = "cpf_usuario")
    private User posse;
    @OneToMany
    @JoinColumn(name = "livro_id")
    private ArrayList<Emprestimo> livros;
}
