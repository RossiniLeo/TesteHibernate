import model.Posts;
import model.Usertable;
import org.hibernate.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import service.ICommentService;
import service.IPostService;
import service.IUserService;
import service.impl.PostService;
import service.impl.UserService;
import utils.HibernateUtils;
import utils.TimeUtils;

import java.util.List;

public class Testes {
    private static SessionFactory sessionFactory;
    private Session session;
    @Autowired
    private ICommentService commentService;
    @Autowired
    private IPostService postService;

    private IUserService userService;
    private Usertable user = new Usertable();

    @BeforeAll
    public static void setup() {
        sessionFactory = HibernateUtils.getSessionFactory();
    }

    @AfterAll
    public static void tearDown() {
        if (sessionFactory != null) sessionFactory.close();
    }

    @BeforeEach
    public void openSession() {
        session = sessionFactory.openSession();
    }

    @AfterEach
    public void closeSession() {
        if (session != null) session.close();
    }

    private static void setupUser(Usertable user) {
        user.setUsername("Usuario");
        user.setPassword("Senha");
        user.setMail("usuario@email.com");
        user.setSex("M");
        user.setId(2);
    }

    @Test
    public void createUserTest() {
        Usertable user = new Usertable();
        setupUser(user);
        userService.save(user);
    }

    @Test
    public void createPostTest() {
        Posts post = new Posts();
        setupUser(user);
        post.setUser(user);
        post.setTitle("Titulo");
        post.setContent("Conteudo do Post");
        post.setPostdate(TimeUtils.getTime(System.currentTimeMillis()));
        postService.save(post);
    }

    @Test
    public void searchPosts() {
        List<Posts> postsList = postService.findAll();
        postsList.forEach(System.out::println);
    }

    @Test
    public void createCommentTest() {

    }
}
