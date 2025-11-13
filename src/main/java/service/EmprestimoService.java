package service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import model.Emprestimo;
import repository.EmprestimoRepository;

@Service
public class EmprestimoService {
    protected EmprestimoRepository repository;

    public EmprestimoService(EmprestimoRepository repository) {
        this.repository = repository;
    }

    public Emprestimo save(Emprestimo entity) {
        return repository.save(entity);
    }

    public void update(Emprestimo entity) {
        repository.save(entity);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public Optional<Emprestimo> findById(Integer id) {
        return repository.findById(id);
    }

    public List<Emprestimo> findAll() {
        return repository.findAll();
    }
}
