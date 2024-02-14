import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeService {

    @Autowired
    private LikeRepository likeRepository;

    public void like(int userId, int contentId) {
        likeRepository.save(userId, contentId);
    }
}