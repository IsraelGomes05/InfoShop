package com.sistnet.projeto.services.validation;

import com.sistnet.projeto.domain.Cliente;
import com.sistnet.projeto.domain.enums.TipoCliente;
import com.sistnet.projeto.dto.ClienteDTO;
import com.sistnet.projeto.dto.ClienteNewDTO;
import com.sistnet.projeto.repository.ClienteRepository;
import com.sistnet.projeto.resources.exeptions.FildMessage;
import com.sistnet.projeto.services.validation.utils.BR;
import com.sistnet.projeto.services.validation.utils.ClienteUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClienteUpdateValidator implements ConstraintValidator<ClienteUpdate, ClienteDTO> {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private HttpServletRequest servletRequest;

    public void initialize(ClienteUpdate constraint) {
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean isValid(ClienteDTO objDto, ConstraintValidatorContext context) {

        Map<String, String> map = (Map<String, String>) servletRequest.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        List<FildMessage> list = new ArrayList<>();
        Integer uriId = Integer.parseInt(map.get("id"));

        Cliente aux = clienteRepository.findByEmail(objDto.getEmail());
        if (aux != null && !aux.getId().equals(uriId)){
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
