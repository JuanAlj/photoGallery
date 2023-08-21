package juanaljaro.photo_gallery.service

import juanaljaro.photo_gallery.domain.Photo

interface IPhotoService {

    fun getAllPhotosByAlbumId(id: Long): Array<Photo>?
}