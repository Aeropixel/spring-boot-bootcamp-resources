package pt.aeropixel.workbook21;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TopEpisodes {

    @GetMapping("/")
    public String getEpisodes() {
        return "episodes";
    }
}
