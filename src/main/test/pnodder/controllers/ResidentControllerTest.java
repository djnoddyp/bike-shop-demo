package pnodder.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import pnodder.config.AppConfig;
import pnodder.model.Resident;

import javax.servlet.ServletContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * This uses the 'webAppContextSetup' style of testing i.e. it loads
 * the Spring configuration from AppConfig.java
 */
@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class})
public class ResidentControllerTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
        this.objectMapper = new ObjectMapper();
    }

    // Verify that the context is setup correctly
    @Test
    public void checkWebAppContext() {
        ServletContext context = this.context.getServletContext();
        Assert.assertNotNull(context);
        Assert.assertTrue(context instanceof MockServletContext);
        Assert.assertNotNull(this.context.getBean("residentController"));
    }

    @Test
    public void testGetWelcome() throws Exception {
        this.mockMvc.perform(get("/welcome"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @Test
    public void testSaveResidentWithErrors() throws Exception {
        this.mockMvc.perform(post("/saveResident")
                .param("name", "jim")
                .param("address", ""))
                //.andDo(print())  // prints out the http req/resp
                .andExpect(model().attributeHasErrors("resident"));
    }

    @Test
    public void testSaveResidentNoErrors() throws Exception {
        this.mockMvc.perform(post("/saveResident")
                .param("name", "jim")
                .param("address", ""))
                //.andDo(print())  // prints out the http req/resp
                .andExpect(model().attributeHasNoErrors("resident"));
    }

}
