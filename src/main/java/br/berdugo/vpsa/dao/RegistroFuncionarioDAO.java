package br.berdugo.vpsa.dao;

import java.util.Calendar;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.berdugo.vpsa.dao.interfaces.IRegistroFuncionarioDAO;
import br.berdugo.vpsa.model.Funcionario;
import br.berdugo.vpsa.model.RegistroFuncionario;
import br.berdugo.vpsa.utils.CalendarUtils;

@Repository
public class RegistroFuncionarioDAO extends BaseDAO<RegistroFuncionario> implements IRegistroFuncionarioDAO {

	@Override
	public RegistroFuncionario buscarUltimoRegistroFuncionario(Funcionario funcionario, Calendar data) {
		DetachedCriteria criteria = DetachedCriteria.forClass(getPersistentClass());
		
		criteria.createAlias("funcionario", "funcionario");
		criteria.add(Restrictions.eq("funcionario.id", funcionario.getId()));
		criteria.add(Restrictions.between("dataHora", CalendarUtils.getInicioDia(data), CalendarUtils.getFinalDia(data)));
		
		List<RegistroFuncionario> registros = this.findByCriteria(criteria);
		
		if (registros.isEmpty()) {
			return null;
		} else {
			return registros.get(0);
		}
	}
}
