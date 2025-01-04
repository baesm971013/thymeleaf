package hello.thymeleaf_basic.basic;

import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/basic")
public class BasicController {

    @GetMapping("/text-basic")
    public String textBasic(Model model){
        model.addAttribute("data", "hello spring");
        return "basic/text-basic";
    }

    @GetMapping("/text-unescaped")
    public String unEscapted(Model model){
        model.addAttribute("data","Hello <b>Spring</b>");
        return "basic/text-unescaped";

    }

    @GetMapping("/variable")
    public String variable(Model model){
        User user = new User("sumin", 29);
        User user2 = new User("kim", 34);

        List<User> list = new ArrayList<>();
        list.add(user2);
        list.add(user);

        Map<String, User> map = new HashMap<>();
        map.put(user.getUsername(), user);
        map.put(user2.getUsername(), user2);

        model.addAttribute("user",user);
        model.addAttribute("users",list);
        model.addAttribute("userMap", map);

        return "basic/variable";

    }

    @Data
    static class User{
        private String username;
        private int age;

        public User(String username, int age){
            this.username = username;
            this.age = age;
        }
    }


}
