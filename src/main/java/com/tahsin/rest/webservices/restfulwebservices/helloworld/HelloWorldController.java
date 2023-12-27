package com.tahsin.rest.webservices.restfulwebservices.helloworld;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorldController {

    private final MessageSource messageSource;

    public HelloWorldController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping("/hello-world")
    public String helloWorld() {
        return "Hello World!! Dhet";
    }

    @GetMapping("/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello Spring.");
    }

    @GetMapping("/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathvariable(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello World %s", name));
    }

    @GetMapping("/hello-world-internationalization")
    public String helloWorldInternationalization() {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning", null, "Default Message", locale);
    }
}
