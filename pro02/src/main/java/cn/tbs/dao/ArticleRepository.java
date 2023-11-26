package cn.tbs.dao;

import cn.tbs.pojo.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ArticleRepository extends ElasticsearchRepository<Article, Integer> {
    List<Article> findByTitle(String condition);
}
