package br.berdugo.vpsa.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
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
import br.berdugo.vpsa.pojo.registro.RegistroArduinoPojo;
import br.berdugo.vpsa.service.interfaces.IFuncionarioService;
import br.berdugo.vpsa.service.interfaces.IRegistroFuncionarioService;
import br.berdugo.vpsa.utils.CustomCalendarEditor;
import br.berdugo.vpsa.utils.I18N;
import br.berdugo.vpsa.utils.JSONReponse;
import br.berdugo.vpsa.utils.ValidationException;
import br.berdugo.vpsa.validator.registro.RegistroArduinoPojoValidator;
import br.berdugo.vpsa.validator.registro.RegistroFuncionarioValidator;

@Controller
@RequestMapping(value = "/registro")
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class RegistroFuncionarioController {
	
	@Autowired
	private IFuncionarioService funcionarioService;
	
	@Autowired
	private IRegistroFuncionarioService registroFuncionarioService;
	
	@Autowired
	private RegistroFuncionarioValidator validator;
	
	@Autowired
	private RegistroArduinoPojoValidator arduinoPojoValidator;
	
	@InitBinder("registro")
    protected void initBinder(WebDataBinder binder) {
    	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
    	binder.registerCustomEditor(Calendar.class, new CustomCalendarEditor(format, false));
    	
    	binder.setValidator(validator);
    }
	
	@InitBinder("registroPojo")
	protected void initBinderPojo(WebDataBinder binder, HttpRequest request) {
		binder.setValidator(arduinoPojoValidator);
	}

    @RequestMapping(value = "/simular", method = RequestMethod.GET)
    public String simularPage(ModelMap model) {
    	model.addAttribute("funcionarios", funcionarioService.listar());
    	
        return "/registro/simular";
    }
    
    @ResponseBody
    @RequestMapping(value = "/simular", method = RequestMethod.POST)
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public JSONReponse simular(@Valid @ModelAttribute("registro") RegistroFuncionario registro, BindingResult result) throws Exception {
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
    
    @ResponseBody
    @RequestMapping(value = "/efetuar", method = RequestMethod.POST)
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public JSONReponse efetuar(@Valid @ModelAttribute("registroPojo") RegistroArduinoPojo pojo, BindingResult result) throws Exception {
    	JSONReponse response = new JSONReponse();
    	
    	if (!result.hasErrors()) {
    		RegistroFuncionario retorno = registroFuncionarioService.efetuar(pojo);
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