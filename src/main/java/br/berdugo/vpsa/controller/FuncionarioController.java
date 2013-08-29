package br.berdugo.vpsa.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.berdugo.vpsa.adapter.funcionario.FuncionarioAdapter;
import br.berdugo.vpsa.enums.Status;
import br.berdugo.vpsa.model.Funcionario;
import br.berdugo.vpsa.service.interfaces.IFuncionarioService;
import br.berdugo.vpsa.utils.I18N;
import br.berdugo.vpsa.utils.JSONReponse;
import br.berdugo.vpsa.utils.ValidationException;
import br.berdugo.vpsa.validator.funcionario.FuncionarioValidator;

@Controller
@RequestMapping(value = "/funcionario")
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class FuncionarioController {

    @Autowired
    private IFuncionarioService service;
    
    @Autowired
    private FuncionarioAdapter adapter;
    
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
    	binder.setValidator(new FuncionarioValidator());
    }
    
    @ResponseBody
    @RequestMapping(value = "/novo", method = RequestMethod.POST)
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public JSONReponse novo(@Valid @ModelAttribute("funcionario") Funcionario funcionario, BindingResult result) throws Exception {
    	JSONReponse response = new JSONReponse();
		
    	if (!result.hasErrors()) {
    		Funcionario retorno = service.cadastrar(funcionario);
    		response.setStatus(Status.OK);
    		response.setRetorno(retorno);
    		response.setMensagem(I18N.getString("funcionario.novo.sucesso"));
    	} else {
    		throw new ValidationException(result.getAllErrors());
    	}

        return response;
    }
    
    @RequestMapping(value = "/novo", method = RequestMethod.GET)
    public String novo() {
        return "funcionario/novo";
    }
    
    @ResponseBody
    @RequestMapping(value = "/listar", method = RequestMethod.POST)
    public JSONReponse funcionarios() throws Exception {
    	JSONReponse response = new JSONReponse();
    	
    	response.setStatus(Status.OK);
    	//response.setRetorno(adapter.getJSON(service.listar()));
    	response.setRetorno(service.listar());
    	return response;
    }
    
    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public String listFuncionarios() {
    	return "funcionario/listar";
    }
    
    @ExceptionHandler
    @ResponseBody
    public JSONReponse handleException(Exception e) {
    	JSONReponse response = new JSONReponse();
    	
    	response.setStatus(Status.ERRO);
    	response.setRetorno(e);
    	response.setMensagem(e.getMessage());
    	
    	return response;
    }
}
