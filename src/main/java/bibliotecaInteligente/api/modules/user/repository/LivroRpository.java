package bibliotecaInteligente.api.modules.user.repository;

import bibliotecaInteligente.api.modules.user.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRpository extends JpaRepository<Livro, Integer> {
}
