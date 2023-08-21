package juanaljaro.photo_gallery.rest

import juanaljaro.photo_gallery.domain.Album
import juanaljaro.photo_gallery.service.AlbumServiceImpl
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/api/albums"], produces = [MediaType.APPLICATION_JSON_VALUE])
class AlbumResource(private val albumServiceImpl: AlbumServiceImpl) {

    @GetMapping
    fun getAllAlbums(): Array<Album>? = albumServiceImpl.getAllAlbums()
}
