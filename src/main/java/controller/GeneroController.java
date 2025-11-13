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

import model.Genero;
import service.GeneroService;
import to.input.GeneroTOInput;
import to.output.GeneroTOoutput;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(value = "/generos", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "/generos", tags = { "Generos - GeneroController" })
@CrossOrigin(origins = "http://localhost")
public class GeneroController {
    private final GeneroService generoService;

    @Autowired
    public GeneroController(GeneroService generoService) {
        this.generoService = generoService;
    }

    @PostMapping
    @ApiOperation(value = "Salvar registro", notes = "Salva um novo registro no banco de dados")
    public ResponseEntity<GeneroTOoutput> save(@RequestBody GeneroTOInput input) {
        final var genero = input;

        final Genero created = generoService.save(genero.build());

        return new ResponseEntity<>(new GeneroTOoutput(created),
                HttpStatus.CREATED);
    }

    @PutMapping
    @ApiOperation(value = "Atualizar registro", notes = "Atualiza um registro existente no banco de dados")
    public ResponseEntity<GeneroTOoutput> edit(@RequestBody GeneroTOInput input) {

        final Genero created = generoService.save(input.build());

        return new ResponseEntity<>(new GeneroTOoutput(created), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Pesquisar por ID", notes = "Retorna o registro de acordo com o ID repassado")
    public ResponseEntity<GeneroTOoutput> findById(@PathVariable("id") Integer id) {

        return ResponseEntity.ok(generoService.findById(id).map(GeneroTOoutput::new).orElse(null));
    }

    @GetMapping
    @ApiOperation(value = "Listar todos", notes = "Retorna todos os registros")
    public ResponseEntity<List<GeneroTOoutput>> findAll() {

        return ResponseEntity.ok(generoService.findAll().stream().map(GeneroTOoutput::new).toList());
    }

    @DeleteExchange("/{id}")
    @ApiOperation(value = "Deletar por ID", notes = "Remove o registro de acordo com o ID repassado")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Integer id) {

        generoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
