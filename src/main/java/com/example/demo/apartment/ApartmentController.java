package com.example.demo.apartment;

import com.example.demo.WebScrapper.MainPageTest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@SessionAttributes("name")
public class ApartmentController {

    private ApartmentService apartmentService;


    public ApartmentController(ApartmentService apartmentService) {
        this.apartmentService = apartmentService;
    }


    @RequestMapping("delete-apart")
    public String deleteApart(@RequestParam int id) {
        apartmentService.deleteById(id);
        return "redirect:list-apartments";
    }


    @RequestMapping("list-apartments")
    public String listAllApartments(ModelMap model){
        List<Apartment> apartmentList =apartmentService.getApartments();
        model.addAttribute("apartments",apartmentList);
        return "listApartments"; //jsp name
    }

    @RequestMapping("get-apartments")
    public String getApartments(){
        return "getApartments"; //jsp name
    }


    @RequestMapping("submit-form")
    public String handleFormSubmission(@RequestParam String city,
                                       @RequestParam String pricemin,
                                       @RequestParam String pricemax,
                                       @RequestParam String area_min,
                                       @RequestParam String area_max,
                                       @RequestParam int pages) throws InterruptedException {


        MainPageTest mainPageTest = new MainPageTest();
        mainPageTest.setValues(city,pricemin,pricemax,area_min,area_max,pages);
        mainPageTest.run();
        apartmentService.setApartments(mainPageTest.listOfApartments);
        return "welcome";
    }

}
