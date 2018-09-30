package com.sistnet.projeto.services;

import com.sistnet.projeto.domain.Cidade;
import com.sistnet.projeto.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    public List<Cidade> findByEstado(Integer estadoId){
        return cidadeRepository.findCidades(estadoId);
    }

}
