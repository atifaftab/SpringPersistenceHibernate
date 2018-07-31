package org.liferayasif.backend.dao;

import java.util.List;

import org.liferayasif.backend.model.Address;
import org.liferayasif.backend.model.User;

public interface AddressDao {


public List<Address> getAllAddress();
	
	public Address getAddressById(String id);
	
	public void addAddress(Address address);
	
	public void deleteAddress(String id);
	
	public User updateAddress(Address address);
	
}
