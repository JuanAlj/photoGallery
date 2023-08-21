package juanaljaro.photo_gallery.service

import juanaljaro.photo_gallery.domain.Album
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class AlbumServiceImpl : IAlbumService {

    @Autowired
    var restTemplate: RestTemplate? = RestTemplate()

    override fun getAllAlbums(): Array<Album>? {
        val uri= "https://jsonplaceholder.typicode.com/albums/"
        return restTemplate?.getForObject(uri, Array<Album>::class.java)
    }

    override fun getAlbumTitle(id: Long): String? {
        val uri= "https://jsonplaceholder.typicode.com/albums/$id"
        return restTemplate?.getForObject(uri, Album::class.java)?.title
    }

}
