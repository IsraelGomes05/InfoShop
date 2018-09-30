package com.sistnet.projeto.resources;

import com.sistnet.projeto.domain.Cidade;
import com.sistnet.projeto.domain.Estado;
import com.sistnet.projeto.dto.CidadeDto;
import com.sistnet.projeto.dto.EstadoDto;
import com.sistnet.projeto.services.CidadeService;
import com.sistnet.projeto.services.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/estados")
public class EstadoResource {

    @Autowired
    private EstadoService estadoService;
    @Autowired
    private CidadeService cidadeService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<EstadoDto>> findAll(){
        List<Estado> list =estadoService.findAll();
        List<EstadoDto> listDto = list.stream().map(EstadoDto::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(value="/{estadoId}/cidades", method=RequestMethod.GET)
    public ResponseEntity<List<CidadeDto>> findCidades(@PathVariable Integer estadoId) {
        List<Cidade> list = cidadeService.findByEstado(estadoId);
        List<CidadeDto> listDto = list.stream().map(CidadeDto::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }
}
