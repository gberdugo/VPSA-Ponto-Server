package br.berdugo.vpsa.adapter.funcionario;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.berdugo.vpsa.model.Funcionario;
import br.berdugo.vpsa.pojo.funcionario.FuncionarioRelatorioPojo;

@Component
public class GeradorRelatorioFuncionarioAdapter {

	public List<FuncionarioRelatorioPojo> adapt(List<Funcionario> funcionarios) {
		List<FuncionarioRelatorioPojo> retorno = new ArrayList<FuncionarioRelatorioPojo>();
		
		if (funcionarios != null) {
			for (Funcionario funcionario : funcionarios) {
				FuncionarioRelatorioPojo pojo = new FuncionarioRelatorioPojo();
				
				pojo.setId(funcionario.getId());
				pojo.setNome(funcionario.getNome());
				pojo.setRfid(funcionario.getCodigoRFID());
				
				retorno.add(pojo);
			}
		}
		
		return retorno;
	}
}
