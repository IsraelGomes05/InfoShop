package com.sistnet.projeto.resources;

import com.sistnet.projeto.domain.Produto;
import com.sistnet.projeto.dto.ProdutoDTO;
import com.sistnet.projeto.resources.utils.URL;
import com.sistnet.projeto.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {

    @Autowired
    private ProdutoService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Produto> find(@PathVariable Integer id) {
        Produto obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public ResponseEntity<Page<ProdutoDTO>> findPage(
            @RequestParam(value = "nome", defaultValue = "") String nome,
            @RequestParam(value = "categorias", defaultValue = "") String  categorias,
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction) {

        List<Integer> ids = URL.decodeIntList(categorias);
        String nomeDecode = URL.decodeParam(nome);

        Page<Produto> lista = service.findDistinctByNomeContainingAndCategoriasIn(nomeDecode, ids, page, linesPerPage, orderBy, direction);
        Page<ProdutoDTO> listaDto = lista.map(ProdutoDTO::new);
        return ResponseEntity.ok().body(listaDto);
    }
}
