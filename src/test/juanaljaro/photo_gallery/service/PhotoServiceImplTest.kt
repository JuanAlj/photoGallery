package juanaljaro.photo_gallery.service

import juanaljaro.photo_gallery.domain.Photo
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.BDDMockito.given
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.web.client.RestTemplate

@ExtendWith(MockitoExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PhotoServiceImplTest {

    @MockBean
    private val restTemplate: RestTemplate? = null
    @Autowired
    private val photoServiceImpl: PhotoServiceImpl? = null

    @Test
    fun findAllTest() {
        val photos = arrayOf(
            Photo(1, "accusamus beatae ad facilis cum similique qui sunt",
                "https://via.placeholder.com/600/92c952", "https://via.placeholder.com/150/92c952"),
            Photo(2, "reprehenderit est deserunt velit ipsam",
                "reprehenderit est deserunt velit ipsam", "https://via.placeholder.com/150/771796")
        )
        val url = "https://jsonplaceholder.typicode.com/albums/1/photos/"

        given(restTemplate?.getForObject(url, Array<Photo>::class.java)).willReturn(photos)

        val photosResult = photoServiceImpl?.getAllPhotosByAlbumId(1)

        assertThat(photosResult).isNotEmpty()
        assertThat(photosResult?.size).isEqualTo(2)
        assertThat(photosResult?.firstOrNull()?.title).isEqualTo("accusamus beatae ad facilis cum similique qui sunt")
    }
}