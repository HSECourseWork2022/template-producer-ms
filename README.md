# Template Producer Application

Ready to kick-start producer microservice template
* Java: 17
* Spring Boot: 2.7.5

# What do you need to update?
1. Rename `TemplateProducerApplication` in `dev.hse.template` package to `{{ Source }}ProducerApplication`
2. Under `src/main/java` rename `dev.hse.template` package to your preferred one
3. Change `artifactId` in pom from `template-producer-ms` to your project's
4. Change POJO models
   1. `TemplateRaw` to your raw model (be careful with LocalDateTime format) `{{ Subtheme }}Raw`
5. Change serialization classes according to your models
   1. `RawModelSerializer` to your model
6. Update `docker-compose.yml`
   1. Change application service name `template-producer` to `{{ source }}-producer`
   2. Change container name `template-producer-container` to `{{ source }}-producer-container`
   3. Change environment variables
      1. `PRODUCER_SOURCE` to your producer's source name
      2. `PRODUCER_SUBTHEME` to your producer's subtheme

# How to run

```bash
./mvnw clean
./mvnw package -Dmaven.test.skip
docker compose up
```

* kafka-ui on `localhost:8080`