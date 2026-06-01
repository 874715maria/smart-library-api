package bibliotecaInteligente.api.modules.livro.model;

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
    private Usuario id_usuario;
    @ManyToOne
    @JoinColumn(name = "id_livro")
    private Usuario id_usuario;
    @Column
    private String data_emprestimo;
    @Column
    private String data_devolucao;
    @Column
    private String status;
}
