package com.amm.scheduler.configuration

import org.quartz.JobDetail
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import com.amm.scheduler.job.SampleJob
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.JobDetailFactoryBean
import org.quartz.Trigger
import org.quartz.SimpleTrigger
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean
import org.springframework.core.io.ClassPathResource
import org.springframework.scheduling.quartz.SchedulerFactoryBean
import org.springframework.scheduling.quartz.SpringBeanJobFactory
import org.springframework.beans.factory.annotation.Autowired

@Configuration
class SchedulerConfiguration {

    // var logger = LoggerFactory.getLogger(javaClass)

    @Autowired
    lateinit var applicationContext: ApplicationContext

    @Bean
    fun sampleJobDetails(): JobDetailFactoryBean {
        val jobDetailFactory = JobDetailFactoryBean()
        jobDetailFactory.setJobClass(SampleJob::class.java)
        jobDetailFactory.setDescription("Invoke sampleJobDetails Job service...")
        jobDetailFactory.setDurability(true)
        return jobDetailFactory
    }

    @Bean
    fun sampleTrigger(sampleJobDetails: JobDetail): SimpleTriggerFactoryBean {
        val trigger = SimpleTriggerFactoryBean()
        trigger.setJobDetail(sampleJobDetails)
        trigger.setRepeatInterval(6000)
        trigger.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY)
        return trigger
    }

    @Bean
    fun anotherSampleJobDetails(): JobDetailFactoryBean {
        val jobDetailFactory = JobDetailFactoryBean()
        jobDetailFactory.setJobClass(SampleJob::class.java)
        jobDetailFactory.setDescription("Invoke anotherSampleJobDetails Job service...")
        jobDetailFactory.setDurability(true)
        return jobDetailFactory
    }

    @Bean
    fun anotherSampleTrigger(anotherSampleJobDetails: JobDetail): SimpleTriggerFactoryBean {
        val trigger = SimpleTriggerFactoryBean()
        trigger.setJobDetail(anotherSampleJobDetails)
        trigger.setRepeatInterval(10000)
        trigger.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY)
        return trigger
    }

    @Bean
    fun springBeanJobFactory(): SpringBeanJobFactory {
        val jobFactory = AutoWiringSpringBeanJobFactory()
        jobFactory.setApplicationContext(applicationContext)
        return jobFactory
    }

    @Bean
    fun scheduler(
            sampleTrigger: Trigger,
            anotherSampleTrigger: Trigger,
            springBeanJobFactory: SpringBeanJobFactory
    ): SchedulerFactoryBean {
        val schedulerFactory = SchedulerFactoryBean()
        schedulerFactory.setConfigLocation(ClassPathResource("quartz.properties"))
        schedulerFactory.setJobFactory(springBeanJobFactory)
        schedulerFactory.setTriggers(sampleTrigger, anotherSampleTrigger)
        return schedulerFactory
    }
}