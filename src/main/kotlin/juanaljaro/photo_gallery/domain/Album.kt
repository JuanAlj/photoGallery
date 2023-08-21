package juanaljaro.photo_gallery.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.SequenceGenerator

@Entity
class Album() {

    constructor(id: Long? = null, title: String? = null) : this() {
        this.id = id
        this.title = title
    }

    @Id
    @Column(
        nullable = false,
        updatable = false
    )
    @SequenceGenerator(
        name = "primary_sequence",
        sequenceName = "primary_sequence",
        allocationSize = 1,
        initialValue = 10000
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "primary_sequence"
    )
    var id: Long? = null

    @Column(nullable = false)
    var title: String? = null

    @OneToMany(mappedBy = "album")
    var photos: MutableSet<Photo>? = null

}
