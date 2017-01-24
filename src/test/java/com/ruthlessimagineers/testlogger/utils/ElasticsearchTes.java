package com.ruthlessimagineers.testlogger.utils;

import gherkin.deps.com.google.gson.Gson;
import gherkin.deps.com.google.gson.GsonBuilder;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.entity.ContentType;
import org.apache.http.nio.entity.NStringEntity;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequestBuilder;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.node.Node;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collections;

import static org.elasticsearch.node.NodeModule.*;

/**
 * Created by krishnanand on 21/01/17.
 */
public class ElasticsearchTes {

//    public static void main(String[] args) throws UnknownHostException {
//        Settings settings = Settings.builder().put("cluster.name", "elasticsearch").put("client.transport.sniff",false).build();
//        Node node = new Node(settings);
//        Client client = node.client();
////        TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
////                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));
//        CreateIndexRequestBuilder createIndexRequestBuilder = client.admin().indices().prepareCreate("test1");
//        CreateIndexResponse response = createIndexRequestBuilder.execute().actionGet();
//        System.out.println(response.isAcknowledged());
////        client.listedNodes().stream().forEach(discoveryNode -> System.out.println(discoveryNode.getName()));
//
//    }

    @Test
    public void test() throws IOException {
        RestClient restClient = RestClient.builder(new HttpHost("localhost",9200,"http")).build();
        HttpEntity entity = new NStringEntity("{\n" +
                "    \"user\" : \"kimchy\",\n" +
                "    \"post_date\" : \"2009-11-15T14:12:12\",\n" +
                "    \"message\" : \"trying out Elasticsearch for fun\"\n" +
                "}", ContentType.APPLICATION_JSON);
        Response response = restClient.performRequest("POST","/testvaizle/type/1", Collections.emptyMap(),entity);
        System.out.println(response.getEntity());
    }
}
