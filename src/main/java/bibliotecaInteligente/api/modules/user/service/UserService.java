package bibliotecaInteligente.api.modules.user.service;

import bibliotecaInteligente.api.modules.user.dto.UserDto;
import bibliotecaInteligente.api.modules.user.model.User;
import bibliotecaInteligente.api.modules.user.repository.UserRpository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRpository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registerUser(UserDto userdto){
        if (repository.findByEmail(userdto.getEmail()).isPresent()){
            throw new RuntimeException("Email ja cadastrado");
        }

        User user = new User();
        user.setNome(userdto.getNome());
        user.setCpf(userdto.getCpf());
        user.setEmail(userdto.getEmail());
        user.setPassword(passwordEncoder.encode(userdto.getPassword()));

        repository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
        User user = repository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario nao encontrado"));

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                new ArrayList<>()
        );
    }
    public void deletarUserPorCpf(String cpf) {
        repository.deleteById(cpf);
    }
    public void atualizarUserPorCpf(String cpf, UserDto userdto) {
        User userEntity = repository.findById(cpf).orElseThrow(() ->
                new RuntimeException("Usuário não encontrado!"));

        if (userdto.getNome() != null && !userdto.getNome().isBlank()) {
            userEntity.setNome(userdto.getNome());
        }

        if (userdto.getEmail() != null && !userdto.getEmail().isBlank()) {
            if (repository.findByEmail(userdto.getEmail()).isPresent()
                    && !userdto.getEmail().equals(userEntity.getEmail())) {
                throw new RuntimeException("Email já cadastrado");
            }

            userEntity.setEmail(userdto.getEmail());
        }

        if (userdto.getPassword() != null && !userdto.getPassword().isBlank()) {
            userEntity.setPassword(passwordEncoder.encode(userdto.getPassword()));
        }

        repository.saveAndFlush(userEntity);
    }
    public List<User> listarUsuarios() {
        return repository.findAll();
    }
    public void bloquearUsuario(String cpf) {

        User user = repository.findById(cpf)
             .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        user.setBloqueado(true);

        repository.save(user);
    }
    public void desbloquearUsuario(String cpf) {

        User user = repository.findById(cpf)
            .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        user.setBloqueado(false);

        repository.save(user);
    }


}
