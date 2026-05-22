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
    @Column
    private String status;
}
