package bibliotecaInteligente.api.modules.livro.service;

import bibliotecaInteligente.api.modules.livro.model.Livro;
import bibliotecaInteligente.api.modules.livro.repository.LivroRpository;

public class EmprestimoService {
    private final EmprestimoRpository EmprestimoRpository;

    public EmprestimoService(EmprestimoRpository EmprestimoRpository) {
        this.EmprestimoRpository = EmprestimoRpository;
    }

    public void salvarEmprestimo(Emprestimo Emprestimo) {
        EmprestimoRpository.save(Emprestimo);
    }
    public Emprestimo buscarPorId(Integer id) {
        return EmprestimoRpository.findById(id).orElseThrow(
                () -> new RuntimeException("Id não encontrado!")
        );
    }
    public void deletarEmprestimoPorId(Integer id) {
        EmprestimoRpository.deleteById(id);
    }
    public void atualizarEmprestimoPorId(Integer id, Emprestimo Emprestimo) {
        Emprestimo EmprestimoEntity = EmprestimoRpository.findById(id).orElseThrow(() ->
                new RuntimeException("Emprestimo não encontrado!"));

        Emprestimo EmprestimoAtualizado = Emprestimo.builder()
                .id(EmprestimoEntity.getId())
                .data_emprestimo(emprestimo.getData_() != null ? livro.getTitulo() : livroEntity.getTitulo())
                .autor(livro.getAutor() != null ? livro.getAutor() : livroEntity.getAutor())
                .descricao(livro.getDescricao() != null ? Emprestimo.getDescricao() : EmprestimoEntity.getDescricao())
                .build();

        EmprestimoRpository.saveAndFlush(EmprestimoAtualizado);
    }
}
