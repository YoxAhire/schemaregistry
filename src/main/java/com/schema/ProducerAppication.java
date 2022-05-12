package com.schema;

import io.confluent.kafka.serializers.AbstractKafkaSchemaSerDeConfig;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.List;
import java.util.Properties;

public class ProducerAppication {
    private static final String TOPIC= "yogesh4";

    public static void main(String[] args) {
        System.out.println("Inside main");
        final Properties prop = new Properties();

        prop.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "10.151.32.238:9092");

        prop.put(ProducerConfig.CLIENT_ID_CONFIG, "Pr1");
        prop.put(ProducerConfig.ACKS_CONFIG, "1");
        prop.put(ProducerConfig.RETRIES_CONFIG, "1");
        prop.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        prop.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class);
        prop.put(AbstractKafkaSchemaSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://10.151.32.238:8081");


        try {

            KafkaProducer<String, Payment> producer = new KafkaProducer<String, Payment>(prop);

            ReadCSV readCSV = new ReadCSV();
            List payList = readCSV.ReadCSVFile(); //It will return the student list


            for (Object payObject : payList) {
                Payment paymentobject = (Payment) payObject;

                producer.send(new ProducerRecord<String, Payment>(TOPIC,paymentobject.getId(),paymentobject));

            }


            producer.flush();
            System.out.println("Successfully produced  messages to a topic : " + TOPIC);

        } catch (Exception e) {
            System.out.println("Inside Exception");
            e.printStackTrace();
        }

    }
}
