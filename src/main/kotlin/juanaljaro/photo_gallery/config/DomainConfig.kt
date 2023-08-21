package juanaljaro.photo_gallery.config

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement


@Configuration
@EntityScan("juanaljaro.photo_gallery.domain")
@EnableJpaRepositories("juanaljaro.photo_gallery.repos")
@EnableTransactionManagement
class DomainConfig
