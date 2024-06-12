package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class SearchFacadeTests {
    @Autowired
    SearchFacade searchFacade;

    @Test
    public void shouldRetrieveCompany() throws SearchingException {
        //Given
        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");
        searchFacade.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        searchFacade.save(dataMaesters);
        int dataMaestersId = dataMaesters.getId();
        searchFacade.save(greyMatter);
        int greyMatterId = greyMatter.getId();

        //When
        CompanyDto companyByFragment = searchFacade.findCompanyByFragment("Dat");
        CompanyDto companyByFragment2 = searchFacade.findCompanyByFragment("soft");

        //Then
        assertEquals(dataMaestersId, companyByFragment.getId());
        assertEquals("Data Maesters", companyByFragment.getName());
        assertEquals(softwareMachineId, companyByFragment2.getId());
        assertEquals("Software Machine", companyByFragment2.getName());

        //CleanUp
        searchFacade.cleanUp();
    }

    @Test
    public void retrieveEmployeeByNameFragment() throws SearchingException {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");
        searchFacade.save(johnSmith);
        int smithId = johnSmith.getId();
        searchFacade.save(stephanieClarckson);
        int clarcksonId = stephanieClarckson.getId();
        searchFacade.save(lindaKovalsky);
        int kovalskyId = lindaKovalsky.getId();

        //When
        EmployeeDto foundSmith = searchFacade.findEmployeeByAnyFragmentOfLastName("mit");
        EmployeeDto foundKovalsky = searchFacade.findEmployeeByAnyFragmentOfLastName("val");

        //Then
        assertEquals(smithId, foundSmith.getId());
        assertEquals(johnSmith.getLastName(), foundSmith.getLastName());
        assertEquals(kovalskyId, foundKovalsky.getId());
        assertEquals(lindaKovalsky.getLastName(), foundKovalsky.getLastName());

        //Clean up
        searchFacade.cleanUp();
    }
}
