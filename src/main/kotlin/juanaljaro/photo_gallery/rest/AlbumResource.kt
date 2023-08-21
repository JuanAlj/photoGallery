package juanaljaro.photo_gallery.rest

import io.swagger.v3.oas.annotations.responses.ApiResponse
import jakarta.validation.Valid
import java.lang.Void
import juanaljaro.photo_gallery.model.AlbumDTO
import juanaljaro.photo_gallery.service.AlbumService
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
    value = ["/api/albums"],
    produces = [MediaType.APPLICATION_JSON_VALUE]
)
class AlbumResource(
    private val albumService: AlbumService
) {

    @GetMapping
    fun getAllAlbums(): ResponseEntity<List<AlbumDTO>> = ResponseEntity.ok(albumService.findAll())

    @GetMapping("/{id}")
    fun getAlbum(@PathVariable(name = "id") id: Long): ResponseEntity<AlbumDTO> =
            ResponseEntity.ok(albumService.get(id))

    @PostMapping
    @ApiResponse(responseCode = "201")
    fun createAlbum(@RequestBody @Valid albumDTO: AlbumDTO): ResponseEntity<Long> {
        val createdId = albumService.create(albumDTO)
        return ResponseEntity(createdId, HttpStatus.CREATED)
    }

    @PutMapping("/{id}")
    fun updateAlbum(@PathVariable(name = "id") id: Long, @RequestBody @Valid albumDTO: AlbumDTO):
            ResponseEntity<Long> {
        albumService.update(id, albumDTO)
        return ResponseEntity.ok(id)
    }

    @DeleteMapping("/{id}")
    @ApiResponse(responseCode = "204")
    fun deleteAlbum(@PathVariable(name = "id") id: Long): ResponseEntity<Void> {
        albumService.delete(id)
        return ResponseEntity.noContent().build()
    }

}
