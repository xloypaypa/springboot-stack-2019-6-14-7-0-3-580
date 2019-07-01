package com.tw.apistackbase.employee;

import com.tw.apistackbase.employee.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Company>> searchAll() {
        return ResponseEntity.ok(this.companyService.getAllCompanies());
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Company> searchById(@PathVariable int id) {
        return ResponseEntity.ok(this.companyService.searchCompany(id));
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteById(@PathVariable int id) {
        this.companyService.removeCompany(id);
        return ResponseEntity.ok("");
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity addById(@RequestBody Company company) {
        this.companyService.addCompany(company);
        return ResponseEntity.ok("");
    }
}
