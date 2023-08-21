package juanaljaro.photo_gallery.controller

import juanaljaro.photo_gallery.domain.Album
import juanaljaro.photo_gallery.service.AlbumServiceImpl
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.BDDMockito.given
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.model
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.view

@ExtendWith(MockitoExtension::class)
@WebMvcTest(AlbumController::class)
class AlbumControllerTest {

    @Autowired
    var mockMvc: MockMvc? = null
    @MockBean
    val mockAlbumServiceImpl: AlbumServiceImpl? = null

    @Test
    @Throws(Exception::class)
    fun getAllAlbumsTest() {
        val albums = arrayOf(
            Album(1, "quidem molestiae enim"),
            Album(2, "sunt qui excepturi placeat culpa"))
        given(mockAlbumServiceImpl!!.getAllAlbums()).willReturn(albums)

        mockMvc!!.perform(get("/albums")
            .flashAttr("albums", albums)
            .contentType("application/json"))
            .andExpect(status().isOk())
            .andExpect(view().name("albums"))
            .andExpect(model().attributeExists("albums"))
    }
}