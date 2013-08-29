package br.berdugo.vpsa.adapter.funcionario;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import br.berdugo.vpsa.enums.ColumnType;
import br.berdugo.vpsa.model.Funcionario;
import br.berdugo.vpsa.pojo.TableColumnPropertyPojo;

@Component
public class FuncionarioAdapter {

	public String getJSON(List<Funcionario> funcionarios) throws Exception {
		JSONObject retorno = new JSONObject();
		
		for (Funcionario funcionario : funcionarios) {
			JSONObject linha = new JSONObject(funcionario);
			
			retorno.append("rows", linha);
		}
		
		return retorno.toString();
	}
}
