package bibliotecaInteligente.api.modules.livro.repository;

import bibliotecaInteligente.api.modules.livro.model.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprestimoRpository extends JpaRepository<Emprestimo, Integer> {
}
