package bibliotecaInteligente.api.modules.user.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

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
