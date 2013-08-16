package br.berdugo.vpsa.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.berdugo.vpsa.enums.Status;
import br.berdugo.vpsa.model.Funcionario;
import br.berdugo.vpsa.service.interfaces.IFuncionarioService;
import br.berdugo.vpsa.utils.JSONReponse;

@Controller
@RequestMapping(value = "/funcionario")
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class FuncionarioController {

    @Autowired
    private IFuncionarioService service;
    
    @RequestMapping(value = "/novo", method = RequestMethod.POST)
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public @ResponseBody JSONReponse novo(@ModelAttribute("funcionario") Funcionario funcionario, BindingResult result) {
    	JSONReponse response = new JSONReponse();
    	
    	Funcionario retorno = service.cadastrar(funcionario);
    	
    	if (retorno == null) {
    		response.setStatus(Status.ERRO);
    	} else {
    		response.setStatus(Status.OK);
    	}
    	response.setRetorno(retorno);

        return response;
    }
    
    @RequestMapping(value = "/novo", method = RequestMethod.GET)
    public String novo() {
        return "funcionario/novo";
    }
}
