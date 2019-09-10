package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Ad;
import com.codeup.springblog.repos.AdRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AdController {

    private final AdRepository adDao;

    public AdController(AdRepository adRepository) {
        adDao = adRepository;
    }


    @GetMapping("/ads")
    public String index(Model vModel) {
        Iterable<Ad> ads = adDao.findAll();


//        ArrayList<Ad> consoles = new ArrayList<>();
//        Ad ps4 = new Ad("ps4", "slight used ps4" );
//        Ad switchNintendo = new Ad("switch", "brand new" );
//        Ad threeDs = new Ad("3DS", "used" );
//
//        consoles.add(ps4);
//        consoles.add(switchNintendo);
//        consoles.add(threeDs);

        vModel.addAttribute("ads", ads);

        return "ads/index";

    }

    @GetMapping("/ads/{id}")
    public String show(@PathVariable long id, Model viewModel) {
        Ad ad = adDao.findOne(id);
        viewModel.addAttribute("ad", ad);
        return "ads/show";
    }

    @GetMapping("/ads/search/{term}")
    public String show(@PathVariable String term, Model viewModel) {
        List<Ad> ads = adDao.searchByTitleLike(term);
        viewModel.addAttribute("ads", ads);
        return "ads/index";
    }

}
