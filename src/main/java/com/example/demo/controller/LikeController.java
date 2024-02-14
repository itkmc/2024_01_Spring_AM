import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LikeController {

    @Autowired
    private LikeService likeService;

    @PostMapping("/like")
    public String like(@RequestParam("userId") int userId, @RequestParam("contentId") int contentId) {
        likeService.like(userId, contentId);
        return "redirect:/content"; // 좋아요 후에 콘텐츠 페이지로 리다이렉트
    }
}
