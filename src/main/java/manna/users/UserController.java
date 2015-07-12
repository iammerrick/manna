package manna.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    UserRepository repository;

    @RequestMapping("/")
    public String index() {
        return "users/index";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public User register(@RequestBody @Valid final User user) {
        repository.save(user);
        return user;
    }


}
