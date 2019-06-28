package com.tw.apistackbase.employee;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest()
@AutoConfigureMockMvc
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void should_return_all_employee_as_json_array() throws Exception {
        String except = "[{\"id\":1,\"name\":\"Xiaoming\",\"age\":20,\"gender\":\"MALE\"},{\"id\":2,\"name\":\"Xiaohong\",\"age\":19,\"gender\":\"FEMALE\"},{\"id\":3,\"name\":\"Xiaozhi\",\"age\":15,\"gender\":\"MALE\"}]";

        this.mockMvc.perform(get("/employees")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(is(except)));
    }

    @Test
    public void should_return_employee_details_as_json_object() throws Exception {
        String except = "{\"id\":2,\"name\":\"Xiaohong\",\"age\":19,\"gender\":\"FEMALE\"}";

        this.mockMvc.perform(get("/employees/2")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(is(except)));
    }

    @Test
    @DirtiesContext
    public void should_not_return_removed_employee_after_delete_it() throws Exception {
        this.mockMvc.perform(delete("/employees/2"));

        String except = "[{\"id\":1,\"name\":\"Xiaoming\",\"age\":20,\"gender\":\"MALE\"},{\"id\":3,\"name\":\"Xiaozhi\",\"age\":15,\"gender\":\"MALE\"}]";
        this.mockMvc.perform(get("/employees")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(is(except)));
    }
}