package kr.ed.haebeop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Controller
@RequestMapping("/locale/")
public class LocaleCtrl {
    private static final Logger logger = LoggerFactory.getLogger(LocaleCtrl.class);
    @Autowired
    SessionLocaleResolver localeResolver;

    @Autowired
    MessageSource messageSource;

    @GetMapping("lang1")
    public String callLocale(Locale locale, HttpServletRequest request, Model model){
//        logger.info("Session locale is {}", localeResolver.resolveLocale(request));
        model.addAttribute("locale", locale);
        return "/test/localeTest";
    }

    @GetMapping("lang2")
    public String callLocale2(@RequestParam("lang") String language, HttpServletRequest request, HttpServletResponse response, Model model){
        Locale locale = new Locale(language);
        localeResolver.setLocale(request, response, locale);
//        logger.info("Session locale is {}", localeResolver.resolveLocale(request));
        model.addAttribute("locale", locale);
        return "/test/localeTest";
    }
}
