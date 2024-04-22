package com.example.OXQuiz.dto;

import com.example.OXQuiz.entity.Ox;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OxDto {
    private Long id;

    @NotBlank(message = "공백일 수 없습니다.")
    private String detail;

    @NotBlank(message = "정답을 알려주세요")
    private String answer;

    @NotBlank(message = "이름을 꼭 입력해주세요")
    private String name;



    public static OxDto fromOxEntity(Ox ox){
        return new OxDto(
                ox.getId(),
                ox.getDetail(),
                ox.getAnswer(),
                ox.getName()
        );
    }

    public Ox fromOxDto(OxDto dto){
        Ox ox = new Ox();
        ox.setId(dto.getId());
        ox.setDetail(dto.getDetail());
        ox.setAnswer(dto.getAnswer());
        ox.setName(dto.getName());
        return ox;
    }
}
