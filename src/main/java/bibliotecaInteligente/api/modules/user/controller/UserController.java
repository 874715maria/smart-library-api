package bibliotecaInteligente.api.modules.user.controller;

import bibliotecaInteligente.api.modules.user.dto.UserDto;
import bibliotecaInteligente.api.modules.user.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody @Valid UserDto dto){
        userService.registerUser(dto);
        return ResponseEntity.ok("Usuario cadastrado com sucesso!");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid UserDto dto, HttpServletRequest request){
        try{
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword())
            );

            SecurityContext context = SecurityContextHolder.getContext();
            context.setAuthentication(authentication);

            HttpSession session = request.getSession(true);
            session.setAttribute("SPRING_SECURITY_CONTEXT", context);

            return ResponseEntity.ok("login realizado com sucesso! Cookie de sessao gerado.");

        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).body("Credenciais Invalidas.");
        }
    }
    @PutMapping("/{cpf}")
    public ResponseEntity<Void> atualizarUsuario(
            @PathVariable String cpf,
            @RequestBody UserDto dto) {

        userService.atualizarUsuario(cpf, dto);
        return ResponseEntity.ok().build();
    }
    @PatchMapping("/{cpf}/bloquear")
    public ResponseEntity<Void> bloquearUsuario(@PathVariable String cpf) {
        userService.bloquearUsuario(cpf);
        return ResponseEntity.ok().build();
    }
    @PatchMapping("/{cpf}/desbloquear")
    public ResponseEntity<Void> desbloquearUsuario(@PathVariable String cpf) {
        userService.desbloquearUsuario(cpf);
        return ResponseEntity.ok().build();
}

    @PostMapping("logout")
    public ResponseEntity<String> logout(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if(session != null){
            session.invalidate();
        }
        return ResponseEntity.ok("Logout realizado com sucesso.");
    }

}
