package juanaljaro.photo_gallery.controller

import juanaljaro.photo_gallery.service.AlbumServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class AlbumController {

    @Autowired
    private val albumServiceImpl: AlbumServiceImpl? = null

    @GetMapping("/albums")
    fun getAllAlbums(model: Model): String {

        model.addAttribute("albums", albumServiceImpl?.getAllAlbums())
        return "albums"
    }
}
