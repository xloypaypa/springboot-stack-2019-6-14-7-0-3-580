package com.tw.apistackbase.employee;

import com.tw.apistackbase.employee.entity.Company;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompanyServiceTest {

    @Test
    public void should_return_default_company_list_when_get_company_list() {
        List<Company> except = Arrays
                .asList(new Company(1, "ali", Collections.emptyList()),
                        new Company(2, "bili", Collections.emptyList()));
        CompanyService companyService = new CompanyService(except);

        List<Company> actual = companyService.getAllCompanies();

        assertEquals(except, actual);
    }

    @Test
    public void should_save_the_company_when_add_the_company_to_data_service() {
        CompanyService companyService = new CompanyService(new ArrayList<>());

        companyService.addCompany(new Company(1, "ali", Collections.emptyList()));

        List<Company> except = new ArrayList<>();
        except.add(new Company(1, "ali", Collections.emptyList()));
        assertEquals(except, companyService.getAllCompanies());
    }

    @Test
    public void should_not_have_the_company_when_delete_it_from_data_service_by_id() {
        List<Company> defaultCompany = Arrays
                .asList(new Company(1, "ali", Collections.emptyList()),
                        new Company(2, "bili", Collections.emptyList()));
        CompanyService companyService = new CompanyService(defaultCompany);

        companyService.removeCompany(1);

        List<Company> except = new ArrayList<>();
        except.add(new Company(2, "bili", Collections.emptyList()));
        assertEquals(except, companyService.getAllCompanies());
    }

    @Test
    public void should_return_the_company_when_search_company_by_id() {
        Company except = new Company(2, "bili", Collections.emptyList());
        List<Company> defaultCompany = Arrays
                .asList(new Company(1, "ali", Collections.emptyList()),
                        except);
        CompanyService companyService = new CompanyService(defaultCompany);

        Company company = companyService.searchCompany(2);

        assertEquals(except, company);
    }
}