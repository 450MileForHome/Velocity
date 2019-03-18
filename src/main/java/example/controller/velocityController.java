package example.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/hello")
public class velocityController {
    private static Logger logger = Logger.getLogger(velocityController.class);

    private class User{
        private int age;
        private Date date;
        private String id;
        private String name;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    @RequestMapping("/showAllUser")
    public String showAllUser(HttpServletRequest request, Model model){
        //volicaty放入集合
        List<User> list = new ArrayList<User>();
        User user = new User();
        user.setAge(1);
        user.setDate(new Date());
        user.setId("1");
        user.setName("张三");
        User user2 = new User();
        user2.setAge(1);
        user2.setDate(new Date());
        user2.setId("s");
        user2.setName("李四");
        list.add(user);
        list.add(user2);
        logger.info("userList's size==============" +list.size());
        model.addAttribute("userList",list);
        //放入单个数据
        model.addAttribute("user","测试数据");
        return "showAllUser";
    }
}
