import org.springframework.beans.factory.annotation.Autowired;
import service.IPostService;
import service.impl.PostService;

public class Main {
    @Autowired
    static
    IPostService postService = new PostService();
    public static void main(String[] args) {

        System.out.println(postService.findAll());
    }
}
