import model.Posts;
import model.Usertable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import service.IPostService;
import service.impl.PostService;
import utils.HibernateUtils;
import utils.TimeUtils;

public class Main {
    @Autowired
    static IPostService postService = new PostService();
    public static void main(String[] args) {

        System.out.println(postService.findAll());

    }
}
