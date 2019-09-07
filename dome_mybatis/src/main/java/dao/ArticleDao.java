package dao;

import model.Article;
import org.apache.ibatis.annotations.Param;

public interface ArticleDao {
    Article findOne(@Param("id") int id);
}
