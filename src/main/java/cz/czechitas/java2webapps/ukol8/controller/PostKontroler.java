package cz.czechitas.java2webapps.ukol8.controller;

import cz.czechitas.java2webapps.ukol8.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PostKontroler {
    private final PostService service;

    @Autowired
    public PostKontroler(PostService service) {
        this.service = service;
    }

    @GetMapping("/")
    public ModelAndView uvodniSeznam(@PageableDefault(sort = {"prijmeni", "jmeno"}) Pageable pageable) {
        return new ModelAndView("uvod")
                .addObject("uvod", service.list(pageable));
    }

    @GetMapping("/vybrane")
    public ModelAndView vybranyPost(@RequestParam("slug") String vybrany, Pageable pageable) {
        return new ModelAndView("index")
                .addObject("vybrane", service.singlePost(vybrany, pageable));
    }
}
