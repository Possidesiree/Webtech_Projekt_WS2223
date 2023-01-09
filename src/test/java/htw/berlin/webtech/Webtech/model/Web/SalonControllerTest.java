package htw.berlin.webtech.Webtech.model.Web;


import htw.berlin.webtech.Webtech.model.Person;
import htw.berlin.webtech.Webtech.model.Rolle;
import htw.berlin.webtech.Webtech.service.SalonService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(SalonController.class)
class SalonControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SalonService salonService;

    @Test
    @DisplayName("should return found persons from salon service")
    void should_return_found_persons_from_salon_service() throws Exception {
        // given
        var persons = List.of(
                new Person(1L, "John Lem", "müllweg.2,1234 Berlin", "jo@gmail.com", Rolle.KUNDE),
                new Person(2L, "Bernd Thim", "bergstr.3,16578 Berlin", "thimu@gmail.com", Rolle.KUNDE)
        );
        doReturn(persons).when(salonService).findAll();

        // when
        mockMvc.perform(get("/api/v1/persons"))
                // then
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].name").value("John Lem"))
                .andExpect(jsonPath("$[0].adresse").value("müllweg.2,1234 Berlin"))
                .andExpect(jsonPath("$[0].email").value("jo@gmail.com"))
                .andExpect(jsonPath("$[0].rolle").value(Rolle.KUNDE))
                .andExpect(jsonPath("$[1].id").value(2L))
                .andExpect(jsonPath("$[0].name").value("Bernd Thim"))
                .andExpect(jsonPath("$[0].adresse").value("bergstr.3,16578 Berlin"))
                .andExpect(jsonPath("$[0].email").value("thimu@gmail.com"))
                .andExpect(jsonPath("$[0].rolle").value(Rolle.KUNDE));
    }

    @Test
    @DisplayName("should return 404 if person is not found")
    void should_return_404_if_person_is_not_found() throws Exception {
        // given
        doReturn(null).when(salonService).findById(anyLong());

        // when
        mockMvc.perform(get("/api/v1/salon/person/123"))
                // then
                .andExpect(status().isNotFound());
    }


}