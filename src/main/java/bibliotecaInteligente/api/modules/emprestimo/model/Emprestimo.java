package bibliotecaInteligente.api.modules.emprestimo.model;

import bibliotecaInteligente.api.modules.livro.model.Livro;
import bibliotecaInteligente.api.modules.user.model.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_emprestimo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private User id_usuario;
    @ManyToOne
    @JoinColumn(name = "id_livro")
    private Livro id_livro;
    @Column
    private String data_emprestimo;
    @Column
    private String data_devolucao;
    @Column
    private String status;
}
