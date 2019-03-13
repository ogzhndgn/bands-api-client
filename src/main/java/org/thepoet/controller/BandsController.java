package org.thepoet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.thepoet.model.Band;
import org.thepoet.service.spec.BandsApiService;

import java.util.List;

/**
 * @author Oguzhan Dogan <dogan_oguzhan@hotmail.com>
 */
@Controller
public class BandsController {

    @Autowired
    BandsApiService bandsApiService;

    @GetMapping("/list")
    public ModelAndView handleRequest() {
        ModelAndView modelAndView = new ModelAndView("band-list");
        List<Band> bandList = bandsApiService.getListFromApi();
        modelAndView.addObject("bandList", bandList);
        return modelAndView;
    }
}
