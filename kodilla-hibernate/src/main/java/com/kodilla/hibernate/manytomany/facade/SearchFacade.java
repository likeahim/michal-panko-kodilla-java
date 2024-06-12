package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class SearchFacade {
    private static final Logger LOGGER = LoggerFactory.getLogger(SearchFacade.class);

    @Autowired
    private final CompanyDao companyDao;
    @Autowired
    private final EmployeeDao employeeDao;

    public void save(Company company) {
        companyDao.save(company);
    }
    public void save(Employee employee) {
        employeeDao.save(employee);
    }
    public CompanyDto findCompanyByFragment (String nameFragment) throws SearchingException {
        try {
            Company company = companyDao.retrieveCompanyByAnyFragment(nameFragment);
            return new CompanyDto(company.getId(), company.getName());
        } catch (Exception e) {
            LOGGER.error(SearchingException.ERR_SEARCH_COMPANY);
        }
        throw new SearchingException(SearchingException.ERR_SEARCH_COMPANY);
    }

    public EmployeeDto findEmployeeByAnyFragmentOfLastName (String nameFragment) throws SearchingException {
        try {
            Employee employee = employeeDao.retrieveEmployeeByAnyFragmentOfLastName(nameFragment);
            return new EmployeeDto(employee.getId(), employee.getFirstName(), employee.getLastName());
        } catch (Exception e) {
            LOGGER.error(SearchingException.ERR_SEARCH_EMPLOYEE);
        }
        throw new SearchingException(SearchingException.ERR_SEARCH_EMPLOYEE);
    }

    public void cleanUp() {
        companyDao.deleteAll();
        employeeDao.deleteAll();
    }
}
