package ru.sberbank.jd.controller;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.sberbank.jd.service.TaskService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

//MockMvcRequestBuilders.*
//
//        MockMvcResultMatchers.*
//
//        MockMvcResultHandlers.*

@SpringBootTest
@AutoConfigureMockMvc
public class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    @MockBean
    private TaskService taskService;

    @Test
    public void create_post_200() throws Exception {
        Mockito.when(taskService.createTask(ArgumentMatchers.any())).thenReturn(null);

        mockMvc.perform(post("/tasks").content("{\n" +
                "    \"description\": \"body of task\",\n" +
                "    \"summary\": \"Title of task\",\n" +
                "    \"owner\": \"owner of task\"\n" +
                "}").accept(MediaType.APPLICATION_JSON));
    }

    @Test
    public void notFound_404_error() throws Exception {
        mockMvc.perform(get("/tasks/not_exsisting_task")).andExpect(status().isNotFound());
    }
}
