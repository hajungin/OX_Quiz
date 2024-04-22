package com.example.OXQuiz.service;

import com.example.OXQuiz.dto.OxDto;
import com.example.OXQuiz.entity.Ox;
import com.example.OXQuiz.repository.OxRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OxService {
    private final OxRepository oxRepository;

    public OxService(OxRepository oxRepository) {
        this.oxRepository = oxRepository;
    }

    public List<OxDto> showQuiz() {
        List<OxDto> oxDtoList = new ArrayList<>();
        return oxRepository.findAll()
                .stream()
                .map(x -> OxDto.fromOxEntity(x))
                .toList();
    }

    public void insertOx(OxDto dto) {
        Ox ox = dto.fromOxDto(dto);
        oxRepository.save(ox);
    }

    public OxDto getOneOx(Long id) {
        return oxRepository.findById(id)
                .map(x -> OxDto.fromOxEntity(x))
                .orElse(null);
    }
    public void delete(Long id) {
        oxRepository.deleteById(id);
    }

    public void update(OxDto dto) {
        Ox ox = dto.fromOxDto(dto);
        oxRepository.save(ox);
    }

    public List<OxDto> playQuiz() {
        return oxRepository.findAll()
                .stream()
                .map(x -> OxDto.fromOxEntity(x))
                .toList();
    }

    public OxDto RRandom() {
        return OxDto.fromOxEntity(oxRepository.RandomQuery());
    }

    public String check(Long id, String answer) {
        OxDto oxDto = oxRepository.findById(id)
                .map(x->OxDto.fromOxEntity(x))
                .orElse(null);
        if (answer.equals(oxDto.getAnswer())){
            return "정답입니다.";
        }
        else {
            return "오답입니다.";
        }
    }

//    public List<OxDto> Random() {
//        List<OxDto> oxDtoList = new ArrayList<>();
//        oxDtoList = oxRepository.RandomQuery()
//                .stream()
//                .map(x-> OxDto.fromOxEntity(x))
//                .toList();
//        return oxDtoList;
//    }

//public List<OxDto> random() {
//    List<OxDto> oxDtoList = new ArrayList<>();
//    List<String> details = oxRepository.RandomQuery();
//    for (String detail : details) {
//        OxDto oxDto = new OxDto();
//        oxDto.setDetail(detail);
//        oxDtoList.add(oxDto);
//    }
//    return oxDtoList;
//}


//    public boolean checkAnswer(OxDto dto) {
//        String answer = dto.getAnswer();
//    }
}
