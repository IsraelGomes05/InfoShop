package com.sistnet.projeto.services.validation;

import com.sistnet.projeto.domain.enums.TipoCliente;
import com.sistnet.projeto.dto.ClienteNewDTO;
import com.sistnet.projeto.resources.exeptions.FildMessage;
import com.sistnet.projeto.services.validation.utils.BR;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {

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

        // inclua os testes aqui, inserindo erros na lista
        for (FildMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage())
                    .addPropertyNode(e.getFildName()).addConstraintViolation();
        }
        return list.isEmpty();
    }
}
