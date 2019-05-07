package com.amm.scheduler.job

import com.amm.scheduler.service.UseCaseSampleService
import org.quartz.Job
import org.quartz.JobExecutionContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class SampleJob: Job {

    @Autowired
    lateinit var useCaseSample: UseCaseSampleService

    override fun execute(context: JobExecutionContext?) {
        println("Hellowwwww....")
        useCaseSample.execute()
    }
}