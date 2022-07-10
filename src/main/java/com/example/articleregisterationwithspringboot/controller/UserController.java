package com.example.articleregisterationwithspringboot.controller;


import com.example.articleregisterationwithspringboot.domains.Article;
import com.example.articleregisterationwithspringboot.domains.Category;
import com.example.articleregisterationwithspringboot.domains.User;
import com.example.articleregisterationwithspringboot.exception.InValidDataException;
import com.example.articleregisterationwithspringboot.service.ArticleService;
import com.example.articleregisterationwithspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;

    @Autowired
    @Qualifier("articleServiceImpl")
    private ArticleService articleService;

    private User accountUser;


    @GetMapping(value = "/home")
    public String homePage1() {
        return "home";
    }

    @GetMapping(value = "/signup")
    public String signup(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "signup";
    }


    @PostMapping(value = "/signup")
    public String register(@ModelAttribute("user") @Valid User user, Errors errors
            , RedirectAttributes redirectAttributes) {
        String msg = "";
        if (null != errors && errors.getErrorCount() > 0) {
            redirectAttributes.addFlashAttribute("user", user);
            return "signup";
        } else {

            try {
                userService.save(user);
                redirectAttributes.addFlashAttribute("msg", "ثبت نام شما با موفقیت انجام شد");
                return "redirect:/user/home";
            } catch (final InValidDataException e) {
                msg = e.getMessage();
                redirectAttributes.addFlashAttribute("msg", msg);
                return "redirect:/user/home";
            }
        }
    }


    @GetMapping(value = "/login")
    public String login(Model model) {
        model.addAttribute("user",new User());
        return "login";
    }

    @PostMapping(value = "/login")
    public String logIn(@ModelAttribute("user") User user) {
        User user1 = userService.findByUsername(user.getUserName());
        if (user1!=null){
            accountUser = user1;
            return "redirect:/user/welcome";
        }
        return "redirect:/user/home";
    }

    @GetMapping(value = "/welcome")
    public String welcome(Model model) {
        model.addAttribute("user",accountUser);
        return "welcome";
    }

    @GetMapping("/create")
    public String createArticle(Model model) {
        model.addAttribute("article",new Article());
        return "create";
    }


    @PostMapping(value = "/create")
    public String newArticle(@ModelAttribute("article") @Valid Article article,
                             Errors errors,
                             RedirectAttributes redirectAttributes) {
        String msg = "";
        if (null != errors && errors.getErrorCount() > 0) {
            redirectAttributes.addFlashAttribute("article", article);
            return "create";
        } else {

            try {
                article.setUser(accountUser);
                article.setCreateDate(LocalDate.now());
                articleService.save(article);
                redirectAttributes.addFlashAttribute("msg", "ثبت نام شما با موفقیت انجام شد");
                return "redirect:/user/welcome";
            } catch (final InValidDataException e) {
                redirectAttributes.addFlashAttribute("msg", msg);
                return "redirect:/user/welcome";
            }
        }

    }

    @GetMapping(value = "/edit-article")
    public String editArticle(Model model) {
        model.addAttribute("list",articleService.findByUserName(accountUser.getUserName()));
        return "edit-article";
    }


    @GetMapping( "/update/{id}")
    public ModelAndView updateArticle(Model model, @PathVariable("id") Long id) {
        ModelAndView mav = new ModelAndView("edit");
        if(id!=null) {
            Article article = articleService.findById(Article.class,id);
            model.addAttribute("article", article);
        }else {
            model.addAttribute("article", new Article());
        }
        return mav;
    }

    @PostMapping(value = "/edit")
    public String editMyArticle(@ModelAttribute("article") @Valid Article article,
                             Errors errors,
                             RedirectAttributes redirectAttributes) {
        String msg = "";
        if (null != errors && errors.getErrorCount() > 0) {
            redirectAttributes.addFlashAttribute("article", article);
            return "edit";
        } else {

            try {
                article.setUser(accountUser);
                article.setCreateDate(LocalDate.now());
                articleService.update(article);
                redirectAttributes.addFlashAttribute("msg", "ثبت نام شما با موفقیت انجام شد");
                return "redirect:/user/welcome";
            } catch (final InValidDataException e) {
                redirectAttributes.addFlashAttribute("msg", msg);
                return "redirect:/user/welcome";
            }
        }
    }


    @GetMapping( "/delete/{id}")
    public String deleteArticle(Model model, @PathVariable("id") Long id) {
        Article article = articleService.findById(Article.class,id);
         articleService.deleteById(article);
        return "redirect:/user/welcome";
    }

    @GetMapping( "/show")
    public String showAllArticle(Model model) {
        List<Article> articles = articleService.findPublishedArticles();
        model.addAttribute("articles",articles);
        return "show-article";
    }

    @GetMapping( "/see/{id}")
    public String showArticle(Model model, @PathVariable("id") Long id) {
        Article article = articleService.findById(Article.class,id);
        model.addAttribute("article",article);
        return "article";
    }


}
