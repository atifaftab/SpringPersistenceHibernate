package org.liferayasif.backend.dao;

import java.util.List;

import org.liferayasif.backend.model.CompanyAddress;

public interface CompanyAddressDao {

	public List<CompanyAddress> getAllCompanyAddresses();
	
	public CompanyAddress getCompanyAddressById(Integer id);
	
	public void addCompanyAddress(CompanyAddress companyAddress);
	
	public CompanyAddress updateCompanyAddress(CompanyAddress companyAddress);
	
	public List<CompanyAddress> getCompanyAddressByUserId(Integer id);

	void deleteCompanyAddress(Integer id);
}