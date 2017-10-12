package pnodder.controllers;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * This uses the 'standaloneSetup' style of testing i.e. it doesn't load
 * the Spring configuration like in ResidentControllerTest.java
 */
public class ControllerTest {

    private MockMvc mockMvc;

//    @Before
//    public void setup() {
//        this.mockMvc = MockMvcBuilders.standaloneSetup(new WelcomeController(new ResidentValidator())).build();
//    }

    @Test
    public void testGetWelcome() throws Exception {
        this.mockMvc.perform(get("/welcome"))
                .andExpect(status().isOk());
    }
}
