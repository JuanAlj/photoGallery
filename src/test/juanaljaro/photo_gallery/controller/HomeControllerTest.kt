package juanaljaro.photo_gallery.controller

import juanaljaro.photo_gallery.domain.Album
import juanaljaro.photo_gallery.service.AlbumService
import org.hamcrest.Matchers.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.BDDMockito.given
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@ExtendWith(MockitoExtension::class)
@WebMvcTest(AlbumController::class)
class AlbumControllerTest {

    @Autowired
    var mockMvc: MockMvc? = null

    @MockBean
    val mockAlbumService: AlbumService? = null

    @Test
    @Throws(Exception::class)
    fun getAllAlbums() {
        val album1 = Album(1, "quidem molestiae enim")
        val album2 = Album(2, "sunt qui excepturi placeat culpa")
        val albums = arrayOf(album1, album2)
        given(mockAlbumService!!.findAll()).willReturn(albums)

        mockMvc!!.perform(get("/albums")
            .flashAttr("albums", albums)
            .contentType("application/json"))
            .andExpect(status().isOk())
            .andExpect(view().name("albums"))
            .andExpect(model().attributeExists("albums"))
    }

}