package bibliotecaInteligente.api.modules.livro.service;

import bibliotecaInteligente.api.modules.livro.model.Livro;
import bibliotecaInteligente.api.modules.livro.repository.LivroRpository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {
    private final LivroRpository livroRepository;

    public LivroService(LivroRpository livroRpository) {
        this.livroRepository = livroRpository;
    }

    public void salvarLivro(Livro livro) {
        livroRepository.save(livro);
    }
    public List<Livro> listarLivros() {
        return livroRepository.findAll();
    }
    public Livro buscarLivroPorId(Integer id) {
        return livroRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Id não encontrado!")
        );
    }
    public void deletarLivroPorId(Integer id) {
        livroRepository.deleteById(id);
    }
    public void atualizarLivroPorId(Integer id, Livro livro) {
        Livro livroEntity = livroRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Livro não encontrado!"));

        Livro livroAtualizado = Livro.builder()
                .id(livroEntity.getId())
                .titulo(livro.getTitulo() != null ? livro.getTitulo() : livroEntity.getTitulo())
                .autor(livro.getAutor() != null ? livro.getAutor() : livroEntity.getAutor())
                .descricao(livro.getDescricao() != null ? livro.getDescricao() : livroEntity.getDescricao())
                .build();

        livroRepository.saveAndFlush(livroAtualizado);
    }
}
