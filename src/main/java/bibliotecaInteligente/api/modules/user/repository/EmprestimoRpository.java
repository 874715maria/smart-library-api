package bibliotecaInteligente.api.modules.user.repository;

import bibliotecaInteligente.api.modules.user.model.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprestimoRpository extends JpaRepository<Emprestimo, Integer> {
}
