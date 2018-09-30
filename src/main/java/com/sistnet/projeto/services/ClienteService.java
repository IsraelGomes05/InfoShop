package com.sistnet.projeto.services;

import com.sistnet.projeto.domain.Cidade;
import com.sistnet.projeto.domain.Cliente;
import com.sistnet.projeto.domain.Endereco;
import com.sistnet.projeto.domain.enums.Perfil;
import com.sistnet.projeto.domain.enums.TipoCliente;
import com.sistnet.projeto.dto.ClienteDTO;
import com.sistnet.projeto.dto.ClienteNewDTO;
import com.sistnet.projeto.repository.ClienteRepository;
import com.sistnet.projeto.repository.EnderecoRepository;
import com.sistnet.projeto.security.UserSS;
import com.sistnet.projeto.services.exeptions.AuthorizationException;
import com.sistnet.projeto.services.exeptions.DataIntegrityException;
import com.sistnet.projeto.services.exeptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private BCryptPasswordEncoder encoder;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private S3Service s3Service;

    public Cliente find(Integer id) {

        UserSS user = UserService.authenticated();
        if (user == null || !user.hasRole(Perfil.ADMIN) && !id.equals(user.getId()) ){
            throw new AuthorizationException("Acesso negado");
        }

        Optional<Cliente> obj = clienteRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
    }

    @Transactional
    public Cliente insert(Cliente obj) {
        obj.setId(null);
        obj = clienteRepository.save(obj);
        enderecoRepository.saveAll(obj.getEnderecos());
        return obj;
    }

    public Cliente update(Cliente oldCliente) {
        Cliente newCliente = find(oldCliente.getId());
        updateData(newCliente, oldCliente);
        return clienteRepository.save(newCliente);
    }

    public void delete(Integer id) {
        this.find(id);
        try {
            clienteRepository.deleteById(id);
        } catch (DataIntegrityViolationException ex) {
            throw new DataIntegrityException("Não é possível excluir um cliente que possui pedido");
        }
    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return clienteRepository.findAll(pageRequest);
    }

    public Cliente fromDTO(ClienteDTO clienteDTO) {
        return new Cliente(clienteDTO.getId(), clienteDTO.getNome(), clienteDTO.getEmail(), null, null, null);
    }

    public Cliente fromDTO(ClienteNewDTO objDTO) {
        Cliente cli = new Cliente(null, objDTO.getNome(), objDTO.getEmail(), objDTO.getCpfOuCnpj(), TipoCliente.toEnum(objDTO.getTipo()), encoder.encode(objDTO.getSenha()));
        Cidade cidade = new Cidade(objDTO.getCidadeId(), null, null);
        Endereco end = new Endereco(null, objDTO.getLogradouro(), objDTO.getNumero(), objDTO.getComplemento(), objDTO.getBairro(), objDTO.getCep(), cli, cidade);

        cli.getEnderecos().add(end);
        cli.getTelefones().add(objDTO.getTelefone());

        if (objDTO.getTelefone1() != null) {
            cli.getTelefones().add(objDTO.getTelefone1());
        }

        if (objDTO.getTelefone2() != null) {
            cli.getTelefones().add(objDTO.getTelefone2());
        }

        return cli;
    }

    private void updateData(Cliente newCliente, Cliente obj) {
        newCliente.setNome(obj.getNome());
        newCliente.setEmail(obj.getEmail());
    }

    public URI uploadProfilePicture(MultipartFile file){
        return s3Service.uploadFile(file);
    }
}
