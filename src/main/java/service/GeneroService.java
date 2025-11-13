package service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import model.Genero;
import repository.GeneroRepository;

@Service
public class GeneroService {
    protected GeneroRepository repository;

    public GeneroService(GeneroRepository repository) {
        this.repository = repository;
    }

    public Genero save(Genero entity) {
        return repository.save(entity);
    }

    public void update(Genero entity) {
        repository.save(entity);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public Optional<Genero> findById(Integer id) {
        return repository.findById(id);
    }

    public List<Genero> findAll() {
        return repository.findAll();
    }
}
