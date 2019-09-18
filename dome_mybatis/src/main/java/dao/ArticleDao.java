package dao;

import model.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleDao {
    Article findOne(@Param("id") int id);

    Integer count();

    List<Article> findList(int start,int offert);
}
