
public class UserDto {

    @NotBlank(message = "O Cpf/Email é obrigatório")
    @Email(message = "Cpf/E-mail inválido")
    private String cpf_email;



}
