# running in console mode (^C to terminate)
# running by specifying concrete JAR-file
java -jar ./target/java-web-1.0-SNAPSHOT-jar-with-dependencies.jar

# running in console mode (^C to terminate)
# running by specifying class-path and explicitly entry-point (mainClass)
java -cp ./target/java-web-1.0-SNAPSHOT-jar-with-dependencies.jar org.alexr.web.MinimalWebApplication

# running in detached mode (ps | grep java-web... kill process_ID)
java -jar ./target/java-web-1.0-SNAPSHOT-jar-with-dependencies.jar &
