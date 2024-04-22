package com.example.OXQuiz.controller;

import com.example.OXQuiz.dto.OxDto;
import com.example.OXQuiz.entity.Ox;
import com.example.OXQuiz.repository.OxRepository;
import com.example.OXQuiz.service.OxService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@Slf4j
@RequestMapping("ox")
public class OxController {
    private final OxService oxService;
    public OxController(OxService oxService) {
        this.oxService = oxService;
    }


    @GetMapping("quiz")
    public String showQuiz(Model model){
        List<OxDto> oxDtoList = oxService.showQuiz();
        model.addAttribute("oxDto", oxDtoList);
        return "showQuiz";
    }
    @GetMapping("start")
    public String startQuiz(Model model){
        List<OxDto> oxDtoList = oxService.showQuiz();
        model.addAttribute("oxDto", oxDtoList);
        return "startQuiz";
    }

    @GetMapping("insert")
    public String insertQuiz(Model model){
        model.addAttribute("oxDto", new OxDto());
        return "insertQuiz";
    }
    @PostMapping("insert")
    public String insertBack(@Valid @ModelAttribute("oxDto")OxDto dto,
                             BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "insertQuiz";
        }
        oxService.insertOx(dto);
        return "redirect:/ox/quiz";
    }
    @GetMapping("update")
    public String updateOx(@RequestParam("updateId")Long id,
                               Model model){
        OxDto oxDto = oxService.getOneOx(id);
        model.addAttribute("oxDto",oxDto);
        return "updateQuiz";
    }
    @PostMapping("update")
    public String update(@Valid @ModelAttribute("oxDto")OxDto dto,
                         BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "updateQuiz";
        }
        oxService.update(dto);
        return "redirect:/ox/quiz";
    }

    @PostMapping("/delete/{deleteId}")
    public String delete(@PathVariable("deleteId")Long id){
        oxService.delete(id);
        return "redirect:/ox/quiz";
    }
    @GetMapping("play")
    public String playQuiz(Model model) {
        OxDto oxDto = oxService.RRandom();
        log.info(oxDto.toString());
        model.addAttribute("oxDto", oxDto);
        return "playQuiz";
    }
    @PostMapping("check")
    public String checkQuiz(@RequestParam("id")Long id,
                            @RequestParam("answer")String answer,
                            Model model){
        String check = oxService.check(id,answer);
        model.addAttribute("check", check);
        return "checkQuiz";
    }

}
