package cz.ondrejvelisek.oauth.client.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestOperations;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author Ondrej Velisek <ondrejvelisek@gmail.com>
 */
@Controller
public class MainController {

    private final String USERINFO_ENDPOINT = "https://perun-dev.meta.zcu.cz/oauth/rpc-xvelisek/json/oidcManager/userinfo";

    @Resource
    private RestOperations elixirAAI;

    @RequestMapping("/")
    public String root(HttpServletRequest req) {

        Map<String, ?> userinfo = elixirAAI.getForObject(USERINFO_ENDPOINT, Map.class);

        req.setAttribute("userinfo", userinfo);

        return "index";
    }

}
