package com.skilllab.portfolio.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.skilllab.portfolio.model.Skill;
@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Model model) {
        // ---- hero ---
        model.addAttribute("name", "Aryan Patel");
        model.addAttribute("title", "Java Backend Developer");
        model.addAttribute("tagline",
            "I build web applications with Java and Spring Boot - "
            + "and I'm looking for my first role as a backend developer.");
        // ---- about ---
        model.addAttribute("about",
            "I'm a final-year B.Tech (CSE) student at SHEAT College of Engineering,"
            + "Varanasi. I like building things that actually run, and I've spent the "
            + "last year learning Java and Spring Boot properly.");
        model.addAttribute("location", "Varanasi, India");
        model.addAttribute("email", "ap2005aryanpatel@gmail.com");
        model.addAttribute("github", "https://github.com/ARYAN4940");
        model.addAttribute("linkedin", "www.linkedin.com/in/aryan-patel-b60ba7359");
        model.addAttribute("resumeUrl", "https://drive.google.com/");

        List<Skill> skills = new ArrayList<>();

        skills.add(new Skill("HTML", "Frontend"));
        skills.add(new Skill("CSS", "Frontend"));
        skills.add(new Skill("JavaScript", "Frontend"));
        skills.add(new Skill("Thymeleaf", "Frontend"));

        skills.add(new Skill("Java", "Backend"));
        skills.add(new Skill("Spring Boot", "Backend"));
        skills.add(new Skill("Spring MVC", "Backend"));

        skills.add(new Skill("Git & GitHub", "Tools"));
        skills.add(new Skill("IntelliJ IDEA", "Tools"));
        skills.add(new Skill("Maven", "Tools"));
        skills.add(new Skill("Postman", "Tools"));

        Map<String, List<Skill>> skillsByCategory = new LinkedHashMap<>();

            for (Skill skill : skills) {

                skillsByCategory.putIfAbsent(skill.getCategory(), new ArrayList<>());

                skillsByCategory.get(skill.getCategory()).add(skill);
            }

            model.addAttribute("skillsByCategory", skillsByCategory);

        return "index";
    }
}
