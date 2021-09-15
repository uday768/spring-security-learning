package com.spring.boot.basic.auth.controller.test;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.spring.boot.basic.auth.repo.EmployeeRepository;
import com.spring.boot.basic.auth.service.EmployeeService;

@WebMvcTest
public class EmployeeControllerTest {

  @Autowired
  WebApplicationContext webApplicationContext;

  MockMvc mockMvc;

  @MockBean
  EmployeeService employeeService;

  @MockBean
  EmployeeRepository employeeRepository;

  @BeforeEach
  public void setUp() {
    mockMvc =
        MockMvcBuilders.webAppContextSetup(webApplicationContext).apply(springSecurity()).build();
  }

  @Test
  @WithMockUser("spring")
  public void testAllEmployees() throws Exception {
    mockMvc.perform(get("/v1/employee").with(httpBasic("user", "password")))
        .andExpect(status().isOk());
  }
}
