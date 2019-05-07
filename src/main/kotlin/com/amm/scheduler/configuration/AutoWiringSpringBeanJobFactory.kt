package com.amm.scheduler.configuration

import org.quartz.spi.TriggerFiredBundle
import org.springframework.beans.BeansException
import org.springframework.beans.factory.config.AutowireCapableBeanFactory
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.scheduling.quartz.SpringBeanJobFactory

/**
 * Enables spring autowire feature for the job beans.
 * So you can inject use cases into the job beans
 */
class AutoWiringSpringBeanJobFactory : SpringBeanJobFactory(), ApplicationContextAware {

    @Transient
    private lateinit var beanFactory: AutowireCapableBeanFactory

    @Throws(BeansException::class)
    override fun setApplicationContext(applicationContext: ApplicationContext) {
        beanFactory = applicationContext.autowireCapableBeanFactory
    }

    @Throws(Exception::class)
    override fun createJobInstance(bundle: TriggerFiredBundle): Any {
        val job = super.createJobInstance(bundle)
        beanFactory.autowireBean(job) //inject the usecase or service beans into the job
        return job
    }

}