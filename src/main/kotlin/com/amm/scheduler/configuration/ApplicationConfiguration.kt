package com.amm.scheduler.configuration

import com.amm.scheduler.service.UseCaseSampleService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ApplicationConfiguration {
    @Bean
    fun useCaseSampleService(): UseCaseSampleService {
        return UseCaseSampleService()
    }
}