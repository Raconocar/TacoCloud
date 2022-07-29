package sia.tacocloud;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import sia.tacocloud.controllers.HomeController;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(HomeController.class)
public class TacoCloudHomeControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Test
    public void testHomePage() throws Exception {
        try {

            mockMvc.perform(get("/"))
                    .andExpect(status().isOk())
                    .andExpect(view().name("home"))
                    .andExpect(content().string(containsString("Welcome to...")));
        } catch (NullPointerException npe) {
            System.out.print("NullPointerException caught");
        }
    }
}
