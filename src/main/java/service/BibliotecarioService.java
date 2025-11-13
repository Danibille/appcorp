package service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import model.Bibliotecario;
import repository.BibliotecarioRepository;

@Service
public class BibliotecarioService {
    protected BibliotecarioRepository repository;

    public BibliotecarioService(BibliotecarioRepository repository) {
        this.repository = repository;
    }

    public Bibliotecario save(Bibliotecario entity) {
        return repository.save(entity);
    }

    public void update(Bibliotecario entity) {
        repository.save(entity);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public Optional<Bibliotecario> findById(Integer id) {
        return repository.findById(id);
    }

    public List<Bibliotecario> findAll() {
        return repository.findAll();
    }
}
