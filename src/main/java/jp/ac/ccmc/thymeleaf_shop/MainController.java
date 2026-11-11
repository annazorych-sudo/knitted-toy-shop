package jp.ac.ccmc.thymeleaf_shop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {

    @GetMapping("/")
    public String showTopPage(Model model) {
        return "index";
    }

    @GetMapping("/item/{id}")
    public String showItemPage(@PathVariable("id") String id, Model model) {

        String name = "";
        String article = "";
        String manufacturer = "";
        String material = "";
        String size = "";
        String image = "";

        switch (id) {
            case "1":
                name = "人形の女の子";
                article = "001";
                manufacturer = "祖母";
                material = "ウール、コットン";
                size = "25cm";
                image = "001.jpg";
                break;

            case "2":
                name = "疲れたウサギ";
                article = "002";
                manufacturer = "Brand NITORI";
                material = "ポリエステル";
                size = "20cm";
                image = "002.jpg";
                break;

            case "3":
                name = "眠りたいひよこ";
                article = "003";
                manufacturer = "MADE IN CHINA";
                material = "ポリエステル";
                size = "10cm";
                image = "003.jpg";
                break;

            case "4":
                name = "クレイジーハート";
                article = "004";
                manufacturer = "MADE IN CHINA";
                material = "金属製ホルダー、ポリエステル";
                size = "15cm";
                image = "004.jpg";
                break;

            default:
                name = "NOT FOUND";
                article = "-";
                manufacturer = "-";
                material = "-";
                size = "-";
                image = "no-image.jpg";
                break;
        }

        model.addAttribute("itemId", id);
        model.addAttribute("name", name);
        model.addAttribute("article", article);
        model.addAttribute("manufacturer", manufacturer);
        model.addAttribute("material", material);
        model.addAttribute("size", size);
        model.addAttribute("image", image);

        return "item";
    }
}