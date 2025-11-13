package service;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import model.Usuario;
import repository.UsuarioRepository;

@Service
public class UsuarioService {
    protected UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public Usuario save(Usuario entity) {
        return repository.save(entity);
    }

    public Usuario update(Usuario entity) {
        return repository.save(entity);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public Optional<Usuario> findById(Integer id) {
        return repository.findById(id);
    }

    public List<Usuario> findAll() {

        return repository.findAll();
    }

    public Optional<Usuario> findByEmail(String email) {
        return repository.findByEmail(email);
    }
}
