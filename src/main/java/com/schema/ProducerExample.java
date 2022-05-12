/*
package com.schema;

import io.confluent.kafka.serializers.*;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class ProducerExample {

    private static final String TOPIC= "yogesh1";

    public static void main(String[] args) {
        System.out.println("Inside main");
        final Properties prop = new Properties();

        prop.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"10.151.32.238:9092");

        prop.put(ProducerConfig.CLIENT_ID_CONFIG,"Pr1");
        prop.put(ProducerConfig.ACKS_CONFIG,"1");
        prop.put(ProducerConfig.RETRIES_CONFIG,"1");
        prop.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        prop.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class);
        prop.put(AbstractKafkaSchemaSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG,"http://10.151.32.238:8081");


          try {
              KafkaProducer<String,Payment> producer = new KafkaProducer<String, Payment>(prop);
            for (long i = 1; i< 5; i++){
                System.out.println("Inside for "+ i);
                final String orderId = "id" + Long.toString(i);
                final Payment payment = new Payment(orderId,"dhule");
                final ProducerRecord<String,Payment> record = new ProducerRecord<String, Payment>(TOPIC,payment.getId().toString(),payment);
                producer.send(record);

                System.out.println("record for"+record);
                //Thread.sleep(1000L);

            }
            System.out.println("Outside for");

             producer.flush();
            System.out.println("Successfully produced 10 messages to a topic : "+TOPIC);

        }catch (Exception e){
            System.out.println("Inside Exception");
            e.printStackTrace();
        }



    }


}
*/
