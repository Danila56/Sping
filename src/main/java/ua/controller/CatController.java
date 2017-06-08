package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ua.Service.CatSevice;
import ua.model.CatEntity;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
/**
 * Created by User on 07.06.2017.
 */
@Controller
public class CatController {
    CatSevice sevice;
    @Autowired(required = true)
    @Qualifier(value = "service")
    public void setSevice(CatSevice sevice) {
        this.sevice = sevice;
    }
    @SuppressWarnings("unchecked")
    @RequestMapping(value = {"index", "/"}, method = GET)
    public ModelAndView main(Model model){
        ModelAndView modelAndView = new ModelAndView("index");
        model.addAttribute("cat", new CatEntity());
        model.addAttribute("catList", sevice.showCat());
        return modelAndView;
    }
    @RequestMapping(value = "/add", method = GET)
    public ModelAndView addCat(@ModelAttribute("cat") CatEntity cat){
        sevice.addCat(cat);
        return new ModelAndView("redirect:/index");
    }
    @RequestMapping(value = "/delete/{id}", method = GET)
    public ModelAndView deleteCat(@PathVariable("id") int id){
        sevice.deleteCat(id);
        return new ModelAndView("redirect:/index");
    }
    @RequestMapping(value = "/edit/{id}", method = GET)
    public String editCat(@PathVariable("id") int id, Model model){
        model.addAttribute("cat", sevice.searchCat(id));
        return "edit";
    }
    @RequestMapping(value = "/edit", method = GET)
    public ModelAndView editCat(@ModelAttribute("cat") CatEntity cat){
        sevice.editCat(cat);
        return new ModelAndView("redirect:/index");
    }
}