package juanaljaro.photo_gallery.controller

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@ExtendWith(MockitoExtension::class)
@WebMvcTest(HomeController::class)
class HomeControllerTest {

    @Autowired
    var mockMvc: MockMvc? = null

    @Test
    @Throws(Exception::class)
    fun indexTest() {
            mockMvc!!.perform(get("/")
            .contentType("application/json"))
            .andExpect(status().isOk())
    }
}