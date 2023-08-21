package juanaljaro.photo_gallery

import org.hamcrest.CoreMatchers.containsString
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.http.HttpStatus

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IntegrationTests(@Autowired val restTemplate: TestRestTemplate) {

    @Test
    fun `Assert Photo Gallery home's page content and status code`() {
        val entity = restTemplate.getForEntity<String>("/")

        assertEquals(entity.statusCode, HttpStatus.OK)
        assertThat(entity.body, containsString("<h2>Galería de fotos</h2>"))
    }

    @Test
    fun `Assert Photo Gallery albums' page content and status code`() {
        val entity = restTemplate.getForEntity<String>("/albums")

        assertEquals(entity.statusCode, HttpStatus.OK)
        assertThat(entity.body, containsString("<h2>Álbumes</h2>"))
    }

    @Test
    fun `Assert Photo Gallery photos' page content and status code for album with id 1`() {
        val entity = restTemplate.getForEntity<String>("/photos/1")

        assertEquals(entity.statusCode, HttpStatus.OK)
        assertThat(entity.body, containsString("<h2>Fotos en álbum \"quidem molestiae enim\"</h2>"))
    }
}