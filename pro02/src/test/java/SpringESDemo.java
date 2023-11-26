import cn.tbs.pojo.Article;
import cn.tbs.service.ArticleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SpringESDemo {
    @Autowired
    ArticleService articleService;

    @Test
    public void ts01() {
        Article article = new Article();
        article.setId(100);
        article.setTitle("测试SpringData ElasticSearch");
        article.setContent("Spring Data ElasticSearch 基于 spring data API 简化 elasticSearch操作，将原始操作elasticSearch的客户端API 进行封装 \n" +
                "    Spring Data为Elasticsearch Elasticsearch项目提供集成搜索引擎");
        articleService.save(article);
    }

    @Test
    public void update(){
        Article article = new Article();
        article.setId(100);
        article.setTitle("测试SpringData ElasticSearch222");
        article.setContent("Spring Data ElasticSearch 基于 spring data API 简化 elasticSearch操作，将原始操作elasticSearch的客户端API 进行封装 \n" +
                "    Spring Data为Elasticsearch Elasticsearch项目提供集成搜索引擎");
        articleService.save(article);
    }
    @Test
    public void save100(){
        for(int i=1;i<=100;i++){
            Article article = new Article();
            article.setId(i);
            article.setTitle(i+"elasticSearch 3.0版本发布..，更新");
            article.setContent(i+"ElasticSearch是一个基于Lucene的搜索服务器。它提供了一个分布式多用户能力的全文搜索引擎，基于RESTful web接口");
            articleService.save(article);
        }
    }
    @Test
    public void findAll(){
        Iterable<Article> all = articleService.findAll();
        for (Article article : all) {
            System.out.println(article);
        }
    }
    @Test
    public void findAllPage(){
        PageRequest pageRequest = new PageRequest(0, 5);
        Iterable<Article> all = articleService.findAll(pageRequest);
        for (Article article : all) {
            System.out.println(article);
        }
    }

    @Test
    public void findByTitle(){
        List<Article> list = articleService.findByTitle("版本");
        for (Article article : list) {
            System.out.println(article);
        }
    }

    @Test
    public void ts06(){
        Integer a = 200;
        Integer b = 200;
        System.out.println(a == b);
    }
}
