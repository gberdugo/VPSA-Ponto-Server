package br.berdugo.vpsa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.berdugo.vpsa.model.Funcionario;
import br.berdugo.vpsa.service.interfaces.IFuncionarioService;

@Controller
@RequestMapping(value = "/funcionario")
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class FuncionarioController {

    @Autowired
    private IFuncionarioService service;

    @RequestMapping(value = "/novo", method = RequestMethod.POST)
    public String novo(@ModelAttribute("funcionario") Funcionario funcionario, BindingResult result) {

        service.cadastrar(funcionario);

        return "funcionario/novo";
    }
    
    @RequestMapping(value = "/novo", method = RequestMethod.GET)
    public String novo() {
        return "funcionario/novo";
    }
}
