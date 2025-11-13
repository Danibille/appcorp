package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import model.Livro;
import model.Usuario;
import service.LivroService;
import service.UsuarioService;
import to.input.LivroTOInput;
import to.output.LivroTOoutput;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/livros", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "/livros", tags = { "Livros - LivroController" })
public class LivroController {
    private final LivroService livroService;

    private final UsuarioService usuarioService;

    @Autowired
    public LivroController(LivroService livroService, UsuarioService usuarioService) {
        this.livroService = livroService;
        this.usuarioService = usuarioService;
    }

    @PostMapping
    @ApiOperation(value = "Salvar registro", notes = "Salva um novo registro no banco de dados")
    public ResponseEntity<LivroTOoutput> save(@AuthenticationPrincipal OAuth2User principal,
            @RequestBody LivroTOInput input) {
        final var livro = input.build();
        Usuario usuarioLogado = usuarioService.findByEmail(principal.getAttribute("email")).orElse(null);
        livro.setCriadoPor(usuarioLogado);
        final Livro created = livroService.save(livro);

        return new ResponseEntity<>(new LivroTOoutput(created), HttpStatus.CREATED);
    }

    @PutMapping
    @ApiOperation(value = "Atualizar registro", notes = "Atualiza um registro existente no banco de dados")
    public ResponseEntity<LivroTOoutput> edit(@AuthenticationPrincipal OAuth2User principal,
            @RequestBody LivroTOInput input) {
        final Livro livro = input.build();
        Usuario usuarioLogado = usuarioService.findByEmail(principal.getAttribute("email")).orElse(null);
        livro.setAlteradoPor(usuarioLogado);
        final Livro updated = livroService.update(livro);

        return new ResponseEntity<>(new LivroTOoutput(updated), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Pesquisar por ID", notes = "Retorna o registro de acordo com o ID repassado")
    public ResponseEntity<LivroTOoutput> findById(@PathVariable("id") Integer id) {

        return ResponseEntity.ok(livroService.findById(id).map(LivroTOoutput::new).orElse(null));

    }

    @GetMapping
    @ApiOperation(value = "Listar todos", notes = "Retorna todos os registros")
    public ResponseEntity<List<LivroTOoutput>> findAll() {

        return ResponseEntity.ok(livroService.findAll().stream().map(LivroTOoutput::new).toList());

    }

    @DeleteExchange("/{id}")
    @ApiOperation(value = "Deletar por ID", notes = "Remove o registro de acordo com o ID repassado")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Integer id) {

        livroService.delete(id);
        return ResponseEntity.noContent().build();

    }
}