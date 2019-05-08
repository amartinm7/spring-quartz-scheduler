package com.schibsted.msmastalkeralerts

import com.schibsted.msmastalkeralerts.infrastructure.framework.Application
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringRunner

@ActiveProfiles("integration-test")
@RunWith(SpringRunner::class)
@SpringBootTest(
    classes = [Application::class],
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@DirtiesContext
abstract class IntegrationTestCase
