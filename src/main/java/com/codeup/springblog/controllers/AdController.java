package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Ad;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;

@Controller
public class AdController {

    @GetMapping("/ads")
    public String index(Model vModel) {
        ArrayList<Ad> consoles = new ArrayList<>();
        Ad ps4 = new Ad("ps4", "slight used ps4" );
        Ad switchNintendo = new Ad("switch", "brand new" );
        Ad threeDs = new Ad("3DS", "used" );

        consoles.add(ps4);
        consoles.add(switchNintendo);
        consoles.add(threeDs);

        vModel.addAttribute("ads", consoles);

        return "ads/index";

    }

    @GetMapping("/ads/{id}")
    public String show(@PathVariable long id, Model viewModel) {
        Ad ad = new Ad("ps4", "slight used ps4" );
        viewModel.addAttribute("ad", ad);
        return "ads/show";
    }

}
