package bibliotecaInteligente.api.modules.livro.controller;

import bibliotecaInteligente.api.modules.livro.model.Livro;
import bibliotecaInteligente.api.modules.livro.service.LivroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/livro")
@RequiredArgsConstructor
public class LivroController {
    private final LivroService livroService;

    @PostMapping
    public ResponseEntity<Void> salvarLivro(@RequestBody Livro livro){
        livroService.salvarLivro(livro);
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public ResponseEntity<Livro> buscarLivroPorId(@RequestParam Integer id){
        return ResponseEntity.ok(livroService.buscarLivroPorId(id));
    }
    @DeleteMapping
    public ResponseEntity<Void> deletarLivro(@RequestParam Integer id){
        livroService.deletarLivroPorId(id);
        return ResponseEntity.ok().build();
    }
    @PutMapping
    public ResponseEntity<Void> atualizarLivroPorId(@RequestParam Integer id,
                                                    @RequestBody Livro livro){
        livroService.atualizarLivroPorId(id, livro);
        return ResponseEntity.ok().build();
    }
}
