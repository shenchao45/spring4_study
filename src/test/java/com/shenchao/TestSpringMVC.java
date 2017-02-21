package com.shenchao;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.htmlunit.MockMvcWebClientBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by shenchao on 2017/2/2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mvc.xml"})
@WebAppConfiguration
public class TestSpringMVC {
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;
    WebClient webClient;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
//        this.mockMvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
        webClient = MockMvcWebClientBuilder
                .webAppContextSetup(this.wac)
                .build();
    }

    @Test
    public void getAccount() throws Exception {
//        this.mockMvc.perform(get("/hello/Lee").accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType("application/json;charset=UTF-8"))
//                .andExpect(jsonPath("$.name").value("Lee"));
//
//        mockMvc.perform(fileUpload("/doc").file("a1", "ABC".getBytes("UTF-8")))
//                .andExpect(status().isOk());
        ResultActions result = mockMvc.perform(get("/hotels?foo={foo}", "沈超")).andDo(print()).andExpect(status().isOk());
    }
    @Test
    public void testHtmlUnit() throws Exception {
        MockHttpServletRequestBuilder createMessage = post("/messages/")
                .param("summary", "Spring Rocks")
                .param("text", "In case you didn't know, Spring Rocks!");

        mockMvc.perform(createMessage)
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/messages/123"));
    }
    @Test
    public void testHtmlUnit1() throws Exception {
        HtmlPage createMsgFormPage = webClient.getPage("http://localhost/messages/form");
        HtmlForm form = createMsgFormPage.getHtmlElementById("messageForm");
        HtmlTextInput summaryInput = createMsgFormPage.getHtmlElementById("summary");
        summaryInput.setValueAttribute("Spring Rocks");
        HtmlTextArea textInput = createMsgFormPage.getHtmlElementById("text");
        textInput.setText("In case you didn't know, Spring Rocks!");
        HtmlSubmitInput submit = form.getOneHtmlElementByAttribute("input", "type", "submit");
        HtmlPage newMessagePage = submit.click();

    }

}
