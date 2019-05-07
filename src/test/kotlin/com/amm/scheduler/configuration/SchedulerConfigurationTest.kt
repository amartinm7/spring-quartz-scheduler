package com.amm.scheduler.configuration

import com.amm.scheduler.SchedulerApplication
import org.junit.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.junit.runner.RunWith

@RunWith(SpringRunner::class)
@SpringBootTest(classes = [SchedulerApplication::class])
internal class SchedulerConfigurationShould{
    @Test
    fun whenSpringContextIsBootstrapped_thenNoExceptions() {
        Thread.sleep(20000)
    }
}