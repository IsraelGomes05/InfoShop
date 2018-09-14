package com.sistnet.projeto.services;

import java.util.List;
import java.util.Optional;

import com.sistnet.projeto.dto.CategoriaDTO;
import com.sistnet.projeto.services.exeptions.DataIntegrityExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sistnet.projeto.domain.Categoria;
import com.sistnet.projeto.repository.CategoriaRepository;
import com.sistnet.projeto.services.exeptions.ObjectNotFoundException;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repo;

    public Categoria find(Integer id) {
        Optional<Categoria> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
    }

    public Categoria insert(Categoria obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public Categoria update(Categoria categoriaOld) {
        Categoria categoriaNew = find(categoriaOld.getId());
        updateData(categoriaNew, categoriaOld);
        return repo.save(categoriaNew);
    }

    public void delete(Integer id) {
        this.find(id);
        try {
            repo.deleteById(id);
        } catch (DataIntegrityViolationException ex) {
            throw new DataIntegrityExeption("Não é possível excluir uma categoria que possui produtos");
        }
    }

    public List<Categoria> findAll() {
        return repo.findAll();
    }

    public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repo.findAll(pageRequest);
    }

    public Categoria fromDTO(CategoriaDTO categoriaDTO){
        return new Categoria(categoriaDTO.getId(), categoriaDTO.getNome());
    }

    private void updateData(Categoria categoriaNew, Categoria categoriaNewOld) {
        categoriaNew.setNome(categoriaNewOld.getNome());
    }
}
