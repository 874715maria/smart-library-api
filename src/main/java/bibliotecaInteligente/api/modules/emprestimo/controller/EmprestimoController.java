package bibliotecaInteligente.api.modules.emprestimo.controller;

import bibliotecaInteligente.api.modules.emprestimo.model.Emprestimo;
import bibliotecaInteligente.api.modules.emprestimo.service.EmprestimoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emprestimo")
@RequiredArgsConstructor
public class EmprestimoController {
    private final EmprestimoService emprestimoService;

    @PostMapping
    public ResponseEntity<Void> salvarEmprestimo(@RequestBody Emprestimo emprestimo){
        emprestimoService.salvarEmprestimo(emprestimo);
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public ResponseEntity<List<Emprestimo>> listarEmprestimos(){
        return ResponseEntity.ok(emprestimoService.listarEmprestimos());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Emprestimo> buscarEmprestimoPorId(@PathVariable Integer id){
        return ResponseEntity.ok(emprestimoService.buscarEmprestimoPorId(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEmprestimo(@PathVariable Integer id){
        emprestimoService.deletarEmprestimoPorId(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarEmprestimoPorId(@PathVariable Integer id,
                                                    @RequestBody Emprestimo emprestimo){
        emprestimoService.atualizarEmprestimoPorId(id, emprestimo);
        return ResponseEntity.ok().build();
    }
}
