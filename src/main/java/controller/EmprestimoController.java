package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import model.Emprestimo;
import service.EmprestimoService;
import to.input.EmprestimoTOInput;
import to.output.EmprestimoTOoutput;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/emprestimos", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "/emprestimos", tags = { "Emprestimos - EmprestimoController" })
@CrossOrigin(origins = "http://localhost")
public class EmprestimoController {
    private final EmprestimoService emprestimoService;

    @Autowired
    public EmprestimoController(EmprestimoService emprestimoService) {
        this.emprestimoService = emprestimoService;
    }

    @PostMapping
    @ApiOperation(value = "Salvar registro", notes = "Salva um novo registro no banco de dados")
    public ResponseEntity<EmprestimoTOoutput> save(@RequestBody EmprestimoTOInput input) {
        final var emprestimo = input;

        final Emprestimo created = emprestimoService.save(emprestimo.build());

        return new ResponseEntity<>(new EmprestimoTOoutput(created),
                HttpStatus.CREATED);
    }

    @PutMapping
    @ApiOperation(value = "Atualizar registro", notes = "Atualiza um registro existente no banco de dados")
    public ResponseEntity<EmprestimoTOoutput> edit(@RequestBody EmprestimoTOInput input) {

        final Emprestimo created = emprestimoService.save(input.build());

        return new ResponseEntity<>(new EmprestimoTOoutput(created), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Pesquisar por ID", notes = "Retorna o registro de acordo com o ID repassado")
    public ResponseEntity<EmprestimoTOoutput> findById(@PathVariable("id") Integer id) {

        return ResponseEntity.ok(emprestimoService.findById(id).map(EmprestimoTOoutput::new).orElse(null));
    }

    @GetMapping
    @ApiOperation(value = "Listar todos", notes = "Retorna todos os registros")
    public ResponseEntity<List<EmprestimoTOoutput>> findAll() {

        return ResponseEntity.ok(emprestimoService.findAll().stream().map(EmprestimoTOoutput::new).toList());
    }

    @DeleteExchange("/{id}")
    @ApiOperation(value = "Deletar por ID", notes = "Remove o registro de acordo com o ID repassado")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Integer id) {

        emprestimoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}