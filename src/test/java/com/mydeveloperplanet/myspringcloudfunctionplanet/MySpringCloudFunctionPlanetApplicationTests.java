package com.mydeveloperplanet.myspringcloudfunctionplanet;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.asyncDispatch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
class MySpringCloudFunctionPlanetApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void doesContainsCloud() throws Exception {
        MvcResult result = this.mockMvc.perform(post("/containsCloud").contentType(MediaType.TEXT_PLAIN).content("this is a cloud")).andReturn();
        mockMvc.perform(asyncDispatch(result)).andExpect(content().string("true"));
    }

    @Test
    void doesNotContainsCloud() throws Exception {
        MvcResult result = this.mockMvc.perform(post("/containsCloud").contentType(MediaType.TEXT_PLAIN).content("this is a function")).andReturn();
        mockMvc.perform(asyncDispatch(result)).andExpect(content().string("false"));
    }

}
