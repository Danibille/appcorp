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

import model.Editora;
import service.EditoraService;
import to.input.EditoraTOInput;
import to.output.EditoraTOoutput;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/editoras", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "/editoras", tags = { "Editoras - EditoraController" })
@CrossOrigin(origins = "http://localhost")
public class EditoraController {
    private final EditoraService editoraService;

    @Autowired
    public EditoraController(EditoraService editoraService) {
        this.editoraService = editoraService;
    }

    @PostMapping
    @ApiOperation(value = "Salvar registro", notes = "Salva um novo registro no banco de dados")
    public ResponseEntity<EditoraTOoutput> save(@RequestBody EditoraTOInput input) {
        final var editora = input;

        final Editora created = editoraService.save(editora.build());

        return new ResponseEntity<>(new EditoraTOoutput(created),
                HttpStatus.CREATED);
    }

    @PutMapping
    @ApiOperation(value = "Atualizar registro", notes = "Atualiza um registro existente no banco de dados")
    public ResponseEntity<EditoraTOoutput> edit(@RequestBody EditoraTOInput input) {

        final Editora created = editoraService.save(input.build());

        return new ResponseEntity<>(new EditoraTOoutput(created), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Pesquisar por ID", notes = "Retorna o registro de acordo com o ID repassado")
    public ResponseEntity<EditoraTOoutput> findById(@PathVariable("id") Integer id) {

        return ResponseEntity.ok(editoraService.findById(id).map(EditoraTOoutput::new).orElse(null));
    }

    @GetMapping
    @ApiOperation(value = "Listar todos", notes = "Retorna todos os registros")
    public ResponseEntity<List<EditoraTOoutput>> findAll() {

        return ResponseEntity.ok(editoraService.findAll().stream().map(EditoraTOoutput::new).toList());
    }

    @DeleteExchange("/{id}")
    @ApiOperation(value = "Deletar por ID", notes = "Remove o registro de acordo com o ID repassado")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Integer id) {

        editoraService.delete(id);
        return ResponseEntity.noContent().build();
    }
}