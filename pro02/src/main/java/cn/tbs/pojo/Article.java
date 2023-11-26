package cn.tbs.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "blog3",type = "article")
public class Article {
    @Id
    private Integer id;
    @Field(index = true,analyzer = "ik_smart",store = true,searchAnalyzer = "ik_smart",type = FieldType.text)
    private String title;
    @Field(index = true,analyzer = "ik_smart",store = true,searchAnalyzer = "ik_smart",type = FieldType.text)
    private String content;
}
