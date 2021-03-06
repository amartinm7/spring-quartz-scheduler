![Building web applications with Spring Boot and Kotlin](./_media/quartz-scheduler-logo.jpg)

# Scheduling in Spring with Quartz

initializr
https://start.spring.io

to start in intellij with gradle support
```bash
gradle cleanIdea idea
```
or choose import existing project and then select build.gradle

## 
The picture:
- Define the use case class or service class
- Define the job class which implements the Job interface and inject the use case class created before
- Define the jobDetail which is using the job class
- Define the trigger which is using the previous jobDetail
- Define a scheduler and register the different triggers
- Define a quartz.properties with the jobStore configuration.
- end

## Run it!
```bash
docker-compose up
./gradlew build integrationTest run
```

##
```bash
docker-compose down
```
 
 ## Quartz Scheduler 
 https://www.baeldung.com/spring-quartz-schedule
 
 ### Install gradle wrapper
```bash
gradle wrapper
```

create folders, gradle config files and so on... choose the 8 and 1 options
```bash
./gradlew init
```
