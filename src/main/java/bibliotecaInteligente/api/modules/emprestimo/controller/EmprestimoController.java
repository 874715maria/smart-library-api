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
    public ResponseEntity<Emprestimo> buscarEmprestimoPorId(@RequestParam Integer id){
        return ResponseEntity.ok(emprestimoService.buscarEmprestimoPorId(id));
    }
    @DeleteMapping
    public ResponseEntity<Void> deletarEmprestimo(@RequestParam Integer id){
        emprestimoService.deletarEmprestimoPorId(id);
        return ResponseEntity.ok().build();
    }
    @PutMapping
    public ResponseEntity<Void> atualizarEmprestimoPorId(@RequestParam Integer id,
                                                    @RequestBody Emprestimo emprestimo){
        emprestimoService.atualizarEmprestimoPorId(id, emprestimo);
        return ResponseEntity.ok().build();
    }
}
