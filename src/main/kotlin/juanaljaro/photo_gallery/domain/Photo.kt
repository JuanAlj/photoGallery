package juanaljaro.photo_gallery.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.SequenceGenerator


@Entity
class Photo {

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

    @Column(nullable = false)
    var url: String? = null

    @Column(nullable = false)
    var thumbnailUrl: String? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "album_id",
        nullable = false
    )
    var album: Album? = null

}
