# Builder container
FROM bellsoft/liberica-runtime-container:jdk-21-stream-musl AS builder
WORKDIR /builder

# This points to the built jar file in the target folder
ARG JAR_FILE=build/libs/*.jar

COPY ${JAR_FILE} application.jar

# Extract the jar file using an efficient layout
RUN java -Djarmode=tools -jar application.jar extract --layers --destination extracted

# Runtime container
FROM bellsoft/liberica-runtime-container:jre-21-musl
WORKDIR /application

# Copy the extracted jar contents, every copy creates layer
COPY --from=builder /builder/extracted/dependencies/ ./
COPY --from=builder /builder/extracted/spring-boot-loader/ ./
COPY --from=builder /builder/extracted/snapshot-dependencies/ ./
COPY --from=builder /builder/extracted/application/ ./

# CDS training run
RUN java -XX:ArchiveClassesAtExit=application.jsa -Dspring.context.exit=onRefresh -jar application.jar

# Start the application jar with CDS enabled
ENTRYPOINT ["java", "-XX:SharedArchiveFile=application.jsa", "-jar", "application.jar"]
