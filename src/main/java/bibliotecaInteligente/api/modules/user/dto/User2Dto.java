package bibliotecaInteligente.api.modules.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class User2Dto {

    @NotBlank(message = "O Cpf/Email é obrigatório")
    @Email(message = "Cpf/E-mail inválido")
    private String cpf_email;



}
