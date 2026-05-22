package bibliotecaInteligente.api.modules.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LivroDto {
    @NotBlank(message = "O Título é obrigatória")
    private String titulo;
    @NotBlank(message = "O Autor é obrigatória")
    private String autor;
    @NotBlank(message = "O Descrição é obrigatório")
    private String descricao;
}
