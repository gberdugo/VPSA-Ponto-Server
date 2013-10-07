package br.berdugo.vpsa.dao;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.berdugo.vpsa.dao.interfaces.IFuncionarioDAO;
import br.berdugo.vpsa.model.Funcionario;

@Repository
public class FuncionarioDAO extends BaseDAO<Funcionario> implements IFuncionarioDAO {

	@Override
	public Funcionario findByRfid(String nroRfid) {
		DetachedCriteria criteria = DetachedCriteria.forClass(getPersistentClass());
		
		criteria.add(Restrictions.eq("codigoRFID", nroRfid));
		
		return this.findOneByCriteria(criteria);
	}
}
