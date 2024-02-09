Minimal reproducable sample of a demo Spring Boot app for wiring up Prometheus and Grafana

Spring application can be started with:
mvn package
java -jar target/rest-grpc-client-0.0.1-SNAPSHOT.jar

Prometheus and Grafana can be strarted:
docker-compose -f docker/monitoring.yml up

