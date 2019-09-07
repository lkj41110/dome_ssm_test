package dao;

import model.Author;
import org.apache.ibatis.annotations.Param;

public interface AuthorDao {
    Author findOne(@Param("id") int id);
}