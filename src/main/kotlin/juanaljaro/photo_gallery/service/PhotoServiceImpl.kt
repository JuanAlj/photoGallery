package juanaljaro.photo_gallery.service

import juanaljaro.photo_gallery.domain.Photo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class PhotoServiceImpl : IPhotoService {

    @Autowired
    var restTemplate: RestTemplate? = RestTemplate()

    override fun getAllPhotosByAlbumId(id: Long): Array<Photo>? {
        val uri= "https://jsonplaceholder.typicode.com/albums/$id/photos/"
        return restTemplate?.getForObject(uri, Array<Photo>::class.java)
    }
}
