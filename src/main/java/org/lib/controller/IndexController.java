package org.lib.controller;

import org.lib.dto.BookDTO;
import org.lib.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class IndexController {
    @Autowired
    private BookService bookService;


    @GetMapping("/")
    public String login(Authentication authentication, Model model,
                        @RequestParam(required = false) String open,
                        @RequestParam(required = false) String toCart,
                        HttpServletResponse response) {
        if (!model.containsAttribute("saveForm")) {
            model.addAttribute("saveForm", new BookDTO());
        }
        model.addAttribute("name", authentication.getName());
        model.addAttribute("booksList", bookService.getBooksList());
        response.addCookie(new Cookie("login", authentication.getName()));
        if (open != null) {
            model.addAttribute("open", open);
            model.addAttribute("openedBook", bookService.findByName(open));
        }
        return "index";
    }

}
