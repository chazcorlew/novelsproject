package novels;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;
@CrossOrigin(origins = "http://localhost:8080/", allowCredentials = "true")
@RestController
@RequestMapping("/novels")
public class NovelController {

    private static Logger logger = LogManager.getLogManager().getLogger(String.valueOf(NovelController.class));

    private final NovelService novelService;

    @Autowired
    public NovelController(NovelService novelService) {
        this.novelService = novelService;
    }


    @GetMapping(produces = "application/json")
    public List<UserResponse> getAllNovels(HttpServletRequest req) {
        logger.info("A GET request was received by /novels at {}");

        return novelService.getAllNovels();
    }

    @GetMapping(value = "/{novel}", produces = "application/json")
    public UserResponse getNovelByNovel(@PathVariable String novel, HttpSession userSession){
        logger.info("A GET request was received by /novels at {}");

        return novelService.getNovelByNovel(novel);
    }

}