package juanaljaro.photo_gallery.rest

import juanaljaro.photo_gallery.domain.Photo
import juanaljaro.photo_gallery.service.PhotoServiceImpl
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/api/photos"], produces = [MediaType.APPLICATION_JSON_VALUE])
class PhotoResource(private val photoServiceImpl: PhotoServiceImpl) {

    @GetMapping("/{id}")
    fun getAllPhotos(@PathVariable(name = "id") id: Long): Array<Photo>? = photoServiceImpl.getAllPhotosByAlbumId(id)
}
