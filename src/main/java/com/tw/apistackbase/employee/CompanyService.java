package com.tw.apistackbase.employee;

import com.tw.apistackbase.employee.entity.Company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompanyService {

    private final Map<Integer, Company> companyMap;

    public CompanyService(List<Company> companies) {
        this.companyMap = new HashMap<>();
        for (Company company : companies) {
            this.companyMap.put(company.getId(), company);
        }
    }

    public List<Company> getAllCompanies() {
        return new ArrayList<>(this.companyMap.values());
    }

    public void addCompany(Company company) {
        this.companyMap.put(company.getId(), company);
    }

    public void removeCompany(int id) {
        this.companyMap.remove(id);
    }

    public Company searchCompany(int id) {
        return this.companyMap.get(id);
    }
}
