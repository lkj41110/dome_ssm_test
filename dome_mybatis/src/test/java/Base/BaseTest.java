package Base;

import dao.ArticleDao;
import dao.AuthorDao;
import model.Article;
import model.Author;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

/**
 * @author luokai
 * @date 2018/1/8
 */
public class BaseTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void prepare() throws IOException {
        String resource = "mybatis/config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        inputStream.close();
    }

    @Test
    public void testOne2One() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            ArticleDao articleDao = session.getMapper(ArticleDao.class);
            Article article = articleDao.findOne(2);
            Author author = article.getAuthor();
            //article.setAuthor(null);
            System.out.println("\nauthor info:");
            System.out.println(author);
            System.out.println("\narticles info:");
            System.out.println(article);
        } finally {
            session.close();
        }
    }

    @Test
    public void testCount() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            ArticleDao articleDao = session.getMapper(ArticleDao.class);
            Integer article = articleDao.count();
            System.out.println(article);
            /**
             * 测试一级缓存
             */
            //article = articleDao.count();
        } finally {
            session.close();
        }
    }

    @Test
    public void testList() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            ArticleDao articleDao = session.getMapper(ArticleDao.class);
            /**
             * 测试
             */
            List<Article> article = articleDao.findList(1, 2);
            System.out.println(article);

        } finally {
            session.close();
        }
    }

    @Test
    public void insert(){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            ArticleDao articleDao = session.getMapper(ArticleDao.class);
            /**
             * 测试
             */
            Article article = new Article();
            Author author = new Author();
            author.setId(1);
            article.setAuthor(author);
            article.setTitle("我是测试1");

            boolean insert = articleDao.insert(article);

            System.out.println(article);

        } finally {
            session.close();
        }
    }

    @Test
    public void testOne2Many() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            AuthorDao authorDao = session.getMapper(AuthorDao.class);
            Author author = authorDao.findOne(1);
            List<Article> arts = author.getArticles();
            List<Article> articles =
                    Arrays.asList(arts.toArray(new Article[arts.size()]));
            arts.clear();
            System.out.println("\nauthor info:");
            System.out.println(author);
            System.out.println("\narticles info:");
            articles.forEach(System.out::println);
        } finally {
            session.close();
        }
    }

}