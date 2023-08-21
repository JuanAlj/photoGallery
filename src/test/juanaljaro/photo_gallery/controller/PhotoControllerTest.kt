package juanaljaro.photo_gallery.controller

import juanaljaro.photo_gallery.domain.Photo
import juanaljaro.photo_gallery.service.AlbumServiceImpl
import juanaljaro.photo_gallery.service.PhotoServiceImpl
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
@WebMvcTest(PhotoController::class)
class PhotoControllerTest {

    @Autowired
    var mockMvc: MockMvc? = null
    @MockBean
    val mockAlbumServiceImpl: AlbumServiceImpl? = null
    @MockBean
    val mockPhotoServiceImpl: PhotoServiceImpl? = null

    @Test
    @Throws(Exception::class)
    fun getPhotosFromAlbumTest() {
        val photos = arrayOf(
            Photo(1, "accusamus beatae ad facilis cum similique qui sunt",
                "https://via.placeholder.com/600/92c952", "https://via.placeholder.com/150/92c952"),
                    Photo(2, "reprehenderit est deserunt velit ipsam",
            "reprehenderit est deserunt velit ipsam", "https://via.placeholder.com/150/771796")
        )
        given(mockPhotoServiceImpl!!.getAllPhotosByAlbumId(1)).willReturn(photos)
        given(mockAlbumServiceImpl!!.getAlbumTitle(1)).willReturn("quidem molestiae enim")

        mockMvc!!.perform(get("/photos/1")
            .flashAttr("photos", photos)
            .flashAttr("albumTitle", "quidem molestiae enim")
            .contentType("application/json"))
            .andExpect(status().isOk())
            .andExpect(view().name("photos"))
            .andExpect(model().attributeExists("photos"))
            .andExpect(model().attributeExists("albumTitle"))
    }
}