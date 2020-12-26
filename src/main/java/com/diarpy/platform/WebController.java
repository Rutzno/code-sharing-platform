package com.diarpy.platform;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author Mack_TB
 * @version 1.0.7
 * @since 12/20/2020
 */

@Controller
@RequestMapping(path = "/code", produces = "text/html")
public class WebController {

    private String title;
    final ApiController apiController;

    public WebController(ApiController apiController) {
        this.apiController = apiController;
    }

    @GetMapping(path = "/{id}")
    public String getCode(@PathVariable String id,
                          HttpServletResponse response,
                          Model model) {
//        response.addHeader("Content-type", "text/html");
        Code code = apiController.getCode(id);
        title = "Code";
        model.addAttribute("title", title);
        model.addAttribute("code", code);
        return "code";
    }

    @GetMapping(path = "/new")
    public String addCode(Model model) {
        title = "Create";
        model.addAttribute("title", title);
        return "createCode";
    }

    @GetMapping("/latest")
    public String getCodeList(Model model) {
        title = "Latest";
        List<Code> codes = apiController.getCodeList();
        model.addAttribute("title", title);
        model.addAttribute("codes", codes);

        return "latest";
    }
}
