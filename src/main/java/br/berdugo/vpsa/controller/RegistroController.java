package br.berdugo.vpsa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.berdugo.vpsa.enums.Status;
import br.berdugo.vpsa.service.interfaces.IFuncionarioService;
import br.berdugo.vpsa.utils.JSONReponse;

@Controller
@RequestMapping(value = "/registro")
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class RegistroController {
	
	@Autowired
	private IFuncionarioService funcionarioService;

    @RequestMapping(value = "/simular", method = RequestMethod.GET)
    public String simularPage(ModelMap model) {
    	model.addAttribute("funcionarios", funcionarioService.listar());
    	
        return "/registro/simular";
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
