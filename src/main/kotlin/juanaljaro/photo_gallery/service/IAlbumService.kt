package juanaljaro.photo_gallery.service

import juanaljaro.photo_gallery.domain.Album

interface IAlbumService {

    fun getAllAlbums(): Array<Album>?

    fun getAlbumTitle(id: Long): String?
}