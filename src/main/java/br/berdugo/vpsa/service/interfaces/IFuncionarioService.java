package br.berdugo.vpsa.service.interfaces;

import java.util.List;

import br.berdugo.vpsa.model.Funcionario;

public interface IFuncionarioService {

	public Funcionario cadastrar(Funcionario funcionario);
	
	public Funcionario editar(Funcionario funcionario);
	
	public List<Funcionario> listar();

	public void remover(Long idFuncionario);
	
	public Funcionario buscarPorId(Long idFuncionario);

	public Funcionario buscarPorNroRfid(String nroRfid);
}
