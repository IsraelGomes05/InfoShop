package com.sistnet.projeto.services.validation;

import com.sistnet.projeto.domain.Cliente;
import com.sistnet.projeto.domain.enums.TipoCliente;
import com.sistnet.projeto.dto.ClienteNewDTO;
import com.sistnet.projeto.repository.ClienteRepository;
import com.sistnet.projeto.resources.exeptions.FildMessage;
import com.sistnet.projeto.services.validation.utils.BR;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {

    @Autowired
    private ClienteRepository clienteRepository;

    public void initialize(ClienteInsert constraint) {
    }

    @Override
    public boolean isValid(ClienteNewDTO objDto, ConstraintValidatorContext context) {

        List<FildMessage> list = new ArrayList<>();

        if (objDto.getTipo().equals(TipoCliente.PESSOA_FISICA.getCod()) && !BR.isValidCPF(objDto.getCpfOuCnpj())) {
            list.add(new FildMessage("cpfOuCnpj", "CPF inválido"));

        }

        if (objDto.getTipo().equals(TipoCliente.PESSOA_JURIDICA.getCod()) && !BR.isValidCNPJ(objDto.getCpfOuCnpj())) {
            list.add(new FildMessage("cpfOuCnpj", "CNPJ inválido"));

        }

        Cliente aux = clienteRepository.findByEmail(objDto.getEmail());
        if (aux != null){
            list.add(new FildMessage("Email", "Email já existe"));
        }

        // inclua os testes aqui, inserindo erros na lista
        for (FildMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage())
                    .addPropertyNode(e.getFildName()).addConstraintViolation();
        }
        return list.isEmpty();
    }
}
