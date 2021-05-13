# Monitorando servicos em kotlin, com spring cloud admin.
- Spring cloud admin é uma solução simples, criada para gerir e monitorar aplicações spring boot.
- Usa como base os endpoints expostos pelo spring boot actuator
- Apenas permite monitaração, não possui recursos como criar novas intâncias ou reinicia-las.
- subindo uma imagem docker pelo maven: mvn spring-boot:build-image
- subindo uma imagem docker pelo gradlew: ./gradlew build bootBuildImage
