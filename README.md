# Kafka_Consumer_Producer_Proj

INSTRUCTION TO USE THE APPLICATION:

=========================prerequisites and configuration===========================

++ 	download the Kafka Binaries
	Extract the binaries into a software/kafka folder. For the current version it's software/kafka_2.11-0.9.0.0.

++	Change your current directory to point to the new folder and start Zookeeper
	Start the Zookeeper server by executing the command: bin/zookeeper-server-start.sh config/zookeeper.properties.
	
++	Start the Kafka server by executing: bin/kafka-server-start.sh config/server.properties.
	Create the topic that is used in the project: bin/kafka-topics.sh --create --zookeeper localhost:9093 --replication-factor 1 --partitions 1 --topic UserSTream.
	
++ 	list topic to make sure it is properlly created 
kafka/bin/kafka-topics.sh --list --zookeeper localhost:9093

++ compling the producer class and runing
-	javac -cp “/path/to/kafka/lib/*” *.java
-	java -cp “/path/to/kafka/lib/*”:. Generator

++ compling the consumer class and runing
-	javac -cp “/path/to/kafka/lib/*” *.java
-	java -cp “/path/to/kafka/lib/*”:. ConsumerGen
	
