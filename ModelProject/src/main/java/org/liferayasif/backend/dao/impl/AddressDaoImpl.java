package org.liferayasif.backend.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.liferayasif.backend.abstrct.dao.AbstractDao;
import org.liferayasif.backend.dao.AddressDao;
import org.liferayasif.backend.model.Address;
import org.liferayasif.backend.model.User;
import org.springframework.stereotype.Repository;

@Repository("addressDao")
public class AddressDaoImpl extends AbstractDao<String, Address> implements AddressDao{
	

	@Override
	@SuppressWarnings("unchecked")
	public List<Address> getAllAddress() {
		Criteria criteria = createEntityCriteria();
		return (List<Address>) criteria.list();
	}

	@Override
	public Address getAddressById(String id) {
		return getByKey(id);
	}

	@Override
	public void addAddress(Address address) {
		persist(address);
	}

	@Override
	public void deleteAddress(String id) {
		Query query = getSession().createSQLQuery("delete from Employee where id = :id");
		query.setString("id", id);
		query.executeUpdate();
	}

	@Override
	public User updateAddress(Address address) {
		return null;
	}
	

}
