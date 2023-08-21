package juanaljaro.photo_gallery.rest

import io.swagger.v3.oas.annotations.responses.ApiResponse
import jakarta.validation.Valid
import java.lang.Void
import juanaljaro.photo_gallery.model.PhotoDTO
import juanaljaro.photo_gallery.service.PhotoService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping(
    value = ["/api/photos"],
    produces = [MediaType.APPLICATION_JSON_VALUE]
)
class PhotoResource(
    private val photoService: PhotoService
) {

    @GetMapping
    fun getAllPhotos(): ResponseEntity<List<PhotoDTO>> = ResponseEntity.ok(photoService.findAll())

    @GetMapping("/{id}")
    fun getPhoto(@PathVariable(name = "id") id: Long): ResponseEntity<PhotoDTO> =
            ResponseEntity.ok(photoService.get(id))

    @PostMapping
    @ApiResponse(responseCode = "201")
    fun createPhoto(@RequestBody @Valid photoDTO: PhotoDTO): ResponseEntity<Long> {
        val createdId = photoService.create(photoDTO)
        return ResponseEntity(createdId, HttpStatus.CREATED)
    }

    @PutMapping("/{id}")
    fun updatePhoto(@PathVariable(name = "id") id: Long, @RequestBody @Valid photoDTO: PhotoDTO):
            ResponseEntity<Long> {
        photoService.update(id, photoDTO)
        return ResponseEntity.ok(id)
    }

    @DeleteMapping("/{id}")
    @ApiResponse(responseCode = "204")
    fun deletePhoto(@PathVariable(name = "id") id: Long): ResponseEntity<Void> {
        photoService.delete(id)
        return ResponseEntity.noContent().build()
    }

}
