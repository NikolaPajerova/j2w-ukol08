package cz.czechitas.java2webapps.ukol8.controller;

import cz.czechitas.java2webapps.ukol8.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public ModelAndView uvodniSeznam() {
        Pageable strany = PageRequest.of(0, 20, Sort.by("published").descending());
        return new ModelAndView("uvod")
                .addObject("seznam", service.list(strany));
    }

    @GetMapping(path = "/", params = "slug")
    public ModelAndView vybranyPost(@RequestParam("slug") String vybrany, Pageable pageable) {
        return new ModelAndView("index")
                .addObject("vybrane", service.singlePost(vybrany, pageable));
    }
}
