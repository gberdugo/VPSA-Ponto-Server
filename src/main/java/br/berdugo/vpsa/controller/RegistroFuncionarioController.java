package br.berdugo.vpsa.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.berdugo.vpsa.enums.Status;
import br.berdugo.vpsa.model.RegistroFuncionario;
import br.berdugo.vpsa.service.interfaces.IFuncionarioService;
import br.berdugo.vpsa.service.interfaces.IRegistroFuncionarioService;
import br.berdugo.vpsa.utils.I18N;
import br.berdugo.vpsa.utils.JSONReponse;
import br.berdugo.vpsa.utils.ValidationException;

@Controller
@RequestMapping(value = "/registro")
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class RegistroFuncionarioController {
	
	@Autowired
	private IFuncionarioService funcionarioService;
	
	@Autowired
	private IRegistroFuncionarioService registroFuncionarioService;
	
	@InitBinder("registro")
    protected void initBinder(WebDataBinder binder, HttpServletRequest request) {
    	RegistroFuncionario funcionario = (RegistroFuncionario)binder.getTarget();
    	funcionario.setFuncionario(funcionarioService.buscarPorId(Long.parseLong(request.getParameter("funcionario"))));
    }

    @RequestMapping(value = "/simular", method = RequestMethod.GET)
    public String simularPage(ModelMap model) {
    	model.addAttribute("funcionarios", funcionarioService.listar());
    	
        return "/registro/simular";
    }
    
    @RequestMapping(value = "/simular", method = RequestMethod.POST)
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    @ResponseBody
    public JSONReponse simular(@ModelAttribute("registro") RegistroFuncionario registro, BindingResult result) throws Exception {
    	JSONReponse response = new JSONReponse();
    	
    	if (!result.hasErrors()) {
    		RegistroFuncionario retorno = registroFuncionarioService.efetuar(registro);
    		response.setStatus(Status.OK);
    		response.setRetorno(retorno);
    		response.setMensagem(I18N.getString("registro.novo.sucesso"));
    	} else {
    		throw new ValidationException(result.getAllErrors());
    	}
    	
    	return response;
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
