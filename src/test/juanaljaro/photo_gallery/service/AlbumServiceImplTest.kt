package juanaljaro.photo_gallery.service

import juanaljaro.photo_gallery.domain.Album
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
class AlbumServiceImplTest() {

    @MockBean
    private val restTemplate: RestTemplate? = null
    @Autowired
    private val albumServiceImpl: AlbumServiceImpl? = null

    @Test
    fun findAllTest() {
        val albums = arrayOf(
            Album(1, "quidem molestiae enim"),
            Album(2, "sunt qui excepturi placeat culpa"))
        val url = "https://jsonplaceholder.typicode.com/albums/"
        given(restTemplate?.getForObject(url, Array<Album>::class.java)).willReturn(albums)

        val albumsResult = albumServiceImpl?.getAllAlbums()

        assertThat(albumsResult).isNotEmpty()
        assertThat(albumsResult?.size).isEqualTo(2)
        assertThat(albumsResult?.firstOrNull()?.title).isEqualTo("quidem molestiae enim")
    }

    @Test
    fun getTitleTest() {
        val album = Album(1, "quidem molestiae enim")
        val url = "https://jsonplaceholder.typicode.com/albums/1"
        given(restTemplate?.getForObject(url, Album::class.java)).willReturn(album)

        val albumTitleResult = albumServiceImpl?.getAlbumTitle(1)

        assertThat(albumTitleResult).isNotEmpty()
        assertThat(albumTitleResult).isEqualTo("quidem molestiae enim")
    }
}