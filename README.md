# Template Application

Ready to kick-start preloader microservice template
* Java: 17
* Spring Boot: 2.7.5

# What do you need to update?
1. Rename `TemplateApplication` in `dev.hse.template` package
2. Under `src/main/java` rename `dev.hse.template` package to your preferred one
3. Change `artifactId` in pom from `template-preloader-ms` to your project's
4. Change POJO models
   1. `TemplateRaw` to your raw model (be careful with LocalDateTime format)
5. Change serialization classes according to your models
   1. `RawModelSerializer` to your model
6. Update `docker-compose.yml`
   1. Change application service name `template_producer`
   2. Change container name `template_producer`
   3. Change environment variables
      1. `FILTERED_TOPIC` to your filtered topic in kafka
      2. `LOADER_TOPIC` to your loader topic in kafka

# How to run

```bash
./mvnw clean
./mvnw package -Dmaven.test.skip
docker compose up
```

* kafka-ui on `localhost:8080`