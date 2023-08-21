package juanaljaro.photo_gallery.controller

import juanaljaro.photo_gallery.domain.Album
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.client.RestTemplate

@Controller
class AlbumController {
    @GetMapping("/albums")
    @ResponseBody
    fun getAlbums(): String {
        val restTemplate = RestTemplate()
        val uri= "https://jsonplaceholder.typicode.com/albums/"

        val albums = restTemplate.getForObject(uri, Array<Album>::class.java)
        println("Albums: " + albums?.size)

        return "Albums: " + albums?.size + System.getProperty("line.separator") + albums?.joinToString(System.getProperty("line.separator")) { " Id: " + it.id + " Title: " + it.title }
    }

}
