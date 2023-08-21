package juanaljaro.photo_gallery.controller

import juanaljaro.photo_gallery.service.AlbumServiceImpl
import juanaljaro.photo_gallery.service.PhotoServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@Controller
class PhotoController {

    @Autowired
    private val albumServiceImpl: AlbumServiceImpl? = null
    @Autowired
    private val photoServiceImpl: PhotoServiceImpl? = null

    @GetMapping("/photos/{id}")
    fun getPhotosFromAlbum(@PathVariable id: Long, model: Model): String {

        model.addAttribute("photos", photoServiceImpl?.getAllPhotosByAlbumId(id))
        model.addAttribute("albumTitle", albumServiceImpl?.getAlbumTitle(id))
        return "photos"
    }

}