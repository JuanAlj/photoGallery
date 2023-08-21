package juanaljaro.photo_gallery.util

import java.lang.RuntimeException


class NotFoundException : RuntimeException {

    constructor() : super()

    constructor(message: String) : super(message)

}