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

import model.Bibliotecario;
import service.BibliotecarioService;
import to.input.BibliotecarioTOInput;
import to.output.BibliotecarioTOoutput;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/bibliotecarios", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "/bibliotecarios", tags = { "Bibliotecarios - BibliotecarioController" })
@CrossOrigin(origins = "http://localhost")
public class BibliotecarioController {
    private final BibliotecarioService bibliotecarioService;

    @Autowired
    public BibliotecarioController(BibliotecarioService bibliotecarioService) {
        this.bibliotecarioService = bibliotecarioService;
    }

    @PostMapping
    @ApiOperation(value = "Salvar registro", notes = "Salva um novo registro no banco de dados")
    public ResponseEntity<BibliotecarioTOoutput> save(@RequestBody BibliotecarioTOInput input) {
        final var bilbiotecario = input;

        final Bibliotecario created = bibliotecarioService.save(bilbiotecario.build());

        return new ResponseEntity<>(new BibliotecarioTOoutput(created),
                HttpStatus.CREATED);
    }

    @PutMapping
    @ApiOperation(value = "Atualizar registro", notes = "Atualiza um registro existente no banco de dados")
    public ResponseEntity<BibliotecarioTOoutput> edit(@RequestBody BibliotecarioTOInput input) {

        final Bibliotecario created = bibliotecarioService.save(input.build());

        return new ResponseEntity<>(new BibliotecarioTOoutput(created), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Pesquisar por ID", notes = "Retorna o registro de acordo com o ID repassado")
    public ResponseEntity<BibliotecarioTOoutput> findById(@PathVariable("id") Integer id) {

        return ResponseEntity.ok(bibliotecarioService.findById(id).map(BibliotecarioTOoutput::new).orElse(null));
    }

    @GetMapping
    @ApiOperation(value = "Listar todos", notes = "Retorna todos os registros")
    public ResponseEntity<List<BibliotecarioTOoutput>> findAll() {

        return ResponseEntity.ok(bibliotecarioService.findAll().stream().map(BibliotecarioTOoutput::new).toList());
    }

    @DeleteExchange("/{id}")
    @ApiOperation(value = "Deletar por ID", notes = "Remove o registro de acordo com o ID repassado")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Integer id) {

        bibliotecarioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
