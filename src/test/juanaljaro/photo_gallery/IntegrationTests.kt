package juanaljaro.photo_gallery

import org.junit.jupiter.api.Assertions.assertEquals
// import org.junit.jupiter.api.Assertions.assertContains
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.http.HttpStatus



@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IntegrationTests(@Autowired val restTemplate: TestRestTemplate) {

    @Test
    fun `Assert Photo Gallery page title, content and status code`() {
        val entity = restTemplate.getForEntity<String>("/")
        assertEquals(entity.statusCode, HttpStatus.OK)
        assertEquals(entity.body, "<h2>Photo Gallery</h2>");
    }

}

/*
public class IntegrationTests() {


    @Test
    fun `Assert Photo Gallery page title, content and status code`() {
        assertEquals(entity.statusCode, HttpStatus.OK)
        assertThat(entity.body).contains("<h2>Photo Gallery</h2>")
    }

}
        */