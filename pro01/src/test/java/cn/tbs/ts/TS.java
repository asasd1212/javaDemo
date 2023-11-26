package cn.tbs.ts;

import cn.tbs.pojo.Article;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.admin.indices.mapping.put.PutMappingRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Requests;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.concurrent.ExecutionException;

public class TS {
    Settings elasticsearch;
    TransportClient client;
    @Before
    public void ts01() throws UnknownHostException {
         elasticsearch = Settings.builder().put("cluster.name", "elasticsearch").build();
        client = new PreBuiltTransportClient(elasticsearch)
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300));


    }
    @Test
    public void ts02() throws IOException {
        try {
            Settings settings = Settings.builder().put("cluster.name", "elasticsearch").build();
            TransportClient client = new PreBuiltTransportClient(settings)
                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
            /**
             {
             "article": {			表
             "properties": {		属性
             "id": {				列
             "type": "long",
             "store": true,
             "index":"not_analyzed"
             },
             "title": {				列
             "type": "text",
             "index":"analyzed",
             "analyzer":"ik_smart"
             },
             "content": {			列
             "type": "text",
             "index":"analyzed",
             "analyzer":"ik_smart"
             }
             }
             }
             }
             */
            //创建名称为blog2的索引
            XContentBuilder xContentBuilder = XContentFactory.jsonBuilder()
                    .startObject()
                    .startObject("article")
                    .startObject("properties")
                    .startObject("id")
                    .field("type", "long")
                    .field("index", "not_analyzed")
                    .endObject()
                    .startObject("title")
                    .field("type", "text")
                    .field("index", "analyzed")
                    .field("analyzer", "ik_smart")
                    .endObject()
                    .startObject("content")
                    .field("type", "text")
                    .field("index", "analyzed")
                    .field("analyzer", "ik_smart")
                    .endObject()
                    .endObject()
                    .endObject()
                    .endObject();
            //获取创建映射对象
            PutMappingRequest putMappingRequest = Requests.putMappingRequest("blog2")
                    .type("article").source(xContentBuilder);
            //
            client.admin().indices().putMapping(putMappingRequest).get();
            client.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Test
    public void ts03() throws IOException {
        XContentBuilder builder = XContentFactory.jsonBuilder()
                .startObject()
                .field("id", "1")
                .field("title", "ElasticSearch是一个基于Lucene的搜索服务器")
                .field("content",
                        "它提供了一个分布式多用户能力的全文搜索引擎，基于RESTful web接口。Elasticsearch是用Java开发的，并作为Apache许可条款下的开放源码发布，是当前流行的企业级搜索引擎。设计用于云计算中，能够达到实时搜索，稳定，可靠，快速，安装使用方便。")
                .endObject();

        // 建立文档对象
        /**
         * 参数一blog1：表示索引对象
         * 参数二article：类型
         * 参数三1：建立id
         */
        client.prepareIndex("blog2", "article", "1").setSource(builder).get();
    }
    @Test
    public void ts4() throws Exception{
        // 创建Client连接对象
        Settings settings = Settings.builder().put("cluster.name", "elasticsearch").build();
        TransportClient client = new PreBuiltTransportClient(settings)
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300));

        // 描述json 数据
        Article article = new Article("2","搜索工作其实很快乐","我们希望我们的搜索解决方案要快，我们希望有一个零配置和一个完全免费的搜索模式，我们希望能够简单地使用JSON通过HTTP的索引数据，我们希望我们的搜索服务器始终可用，我们希望能够一台开始并扩展到数百，我们要实时搜索，我们要简单的多租户，我们希望建立一个云的解决方案。Elasticsearch旨在解决所有这些问题和更多的问题。");

        //最终变成json字节
        com.fasterxml.jackson.databind.ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();
        client.prepareIndex("blog2","article","2").
                setSource(objectMapper.writeValueAsBytes(article),XContentType.JSON).get();
        //释放资源
        client.close();
    }
    @Test
    public void ts05() throws ExecutionException, InterruptedException {
        DeleteRequest deleteRequest = new DeleteRequest("blog2", "article", "1");
        client.delete(deleteRequest).get();
    }
    @Test
    public void ts06(){
        SearchResponse searchResponse = client.prepareSearch("blog2")
                .setTypes("article")
                .setQuery(QueryBuilders.termQuery("content", "搜索")).get();
        SearchHits hits = searchResponse.getHits(); // 获取命中次数，查询结果有多少对象
        System.out.println("查询结果有：" + hits.getTotalHits() + "条");
        Iterator<SearchHit> iterator = hits.iterator();
        while (iterator.hasNext()) {
            SearchHit searchHit = iterator.next(); // 每个查询对象
            System.out.println(searchHit.getSourceAsString());
            // 获取字符串格式打印
            System.out.println("title:" + searchHit.getSource().get("title"));
        }
    }
    @Test
    public void ts07(){
        SearchResponse searchResponse = client.prepareSearch("blog2")
                .setTypes("article")
                .setQuery(QueryBuilders.queryStringQuery("搜索")).get();



        //3、遍历搜索结果数据
        SearchHits hits = searchResponse.getHits(); // 获取命中次数，查询结果有多少对象
        System.out.println("查询结果有：" + hits.getTotalHits() + "条");
        Iterator<SearchHit> iterator = hits.iterator();
        while (iterator.hasNext()) {
            SearchHit searchHit = iterator.next(); // 每个查询对象
            System.out.println(searchHit.getSourceAsString()); // 获取字符串格式打印
            System.out.println("title:" + searchHit.getSource().get("title"));
        }
    }
    @Test
    public void ts08(){
        SearchResponse response = client.prepareSearch("blog1")
                .setTypes("article")
                //设置要查询的id
                .setQuery(QueryBuilders.idsQuery().addIds("1"))
                //执行查询
                .get();
        //取查询结果
        SearchHits searchHits = response.getHits();
        //取查询结果总记录数
        System.out.println(searchHits.getTotalHits());
        Iterator<SearchHit> hitIterator = searchHits.iterator();
        while(hitIterator.hasNext()) {
            SearchHit searchHit = hitIterator.next();
            //打印整行数据
            System.out.println(searchHit.getSourceAsString());
        }
    }
    @Test
    public void ts09() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        for (int i = 1; i <= 100; i++) {
            // 描述json 数据
            Article article = new Article();
            article.setId(String.valueOf(i));
            article.setTitle(i + "搜索工作其实很快乐");
            article.setContent(i
                    + "我们希望我们的搜索解决方案要快，我们希望有一个零配置和一个完全免费的搜索模式，我们希望能够简单地使用JSON通过HTTP的索引数据，我们希望我们的搜索服务器始终可用，我们希望能够一台开始并扩展到数百，我们要实时搜索，我们要简单的多租户，我们希望建立一个云的解决方案。Elasticsearch旨在解决所有这些问题和更多的问题。");

            // 建立文档
            client.prepareIndex("blog2", "article", article.getId())
                    //.setSource(objectMapper.writeValueAsString(article)).get();
                    .setSource(objectMapper.writeValueAsString(article).getBytes(),XContentType.JSON).get();
        }
    }
    @Test
    public void ts10(){
        SearchRequestBuilder searchRequestBuilder = client.prepareSearch("blog2").setTypes("article")
                .setQuery(QueryBuilders.matchAllQuery());//默认每页10条记录

        //setFrom()：从第几条开始检索，默认是0。分页公式:(pageNo-1)*pageSize
        //setSize():每页最多显示的记录数。

        searchRequestBuilder.setFrom(0).setSize(5);
        SearchResponse searchResponse = searchRequestBuilder.get();

        //下面还是之前的查询
        SearchHits hits = searchResponse.getHits(); // 获取命中次数，查询结果有多少对象
        System.out.println("查询结果有：" + hits.getTotalHits() + "条");
        Iterator<SearchHit> iterator = hits.iterator();
        while (iterator.hasNext()) {
            SearchHit searchHit = iterator.next(); // 每个查询对象
            System.out.println(searchHit.getSourceAsString()); // 获取字符串格式打印
            System.out.println("id:" + searchHit.getSource().get("id"));
            System.out.println("title:" + searchHit.getSource().get("title"));
            System.out.println("content:" + searchHit.getSource().get("content"));
            System.out.println("-----------------------------------------");
        }

    }
    @Test
    public void ts11() throws UnknownHostException {
        Settings settings = Settings.builder().put("cluster.name", "elasticsearch").build();
        TransportClient client = new PreBuiltTransportClient(settings)
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300));

        SearchRequestBuilder searchRequestBuilder = client
                .prepareSearch("blog2").setTypes("article")
                .setQuery(QueryBuilders.termQuery("title", "搜索"));

        HighlightBuilder hiBuilder=new HighlightBuilder();
        hiBuilder.preTags("<font style='color:red'>");
        hiBuilder.postTags("</font>");
        hiBuilder.field("title");
        searchRequestBuilder.highlighter(hiBuilder);
        SearchResponse searchResponse = searchRequestBuilder.get();

        //3、遍历搜索结果数据
        SearchHits SearchHit = searchResponse.getHits(); // 获取命中次数，查询结果有多少对象
        System.out.println("查询结果有：" + SearchHit.getTotalHits() + "条");
        for(SearchHit hit:SearchHit){
            System.out.println("String方式打印文档搜索内容:");
            System.out.println(hit.getSourceAsString());
            System.out.println("Map方式打印高亮内容");
            System.out.println(hit.getHighlightFields());

            System.out.println("遍历高亮集合，打印高亮片段:");
            Text[] text = hit.getHighlightFields().get("title").getFragments();
            for (Text str : text) {
                System.out.println(str);
            }
        }
    }
    @After
    public void after(){
        if(client != null){
            client.close();
        }
    }
}
