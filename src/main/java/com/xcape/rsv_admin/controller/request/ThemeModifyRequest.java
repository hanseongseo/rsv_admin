package com.xcape.rsv_admin.controller.request;

import com.xcape.rsv_admin.domain.dto.ThemeDto;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ThemeModifyRequest {

    private String name;
    private String mainImage;
    private String bgImage;
    private Long price;
    private String desc;
    private Integer reasoning;
    private Integer observation;
    private Integer activity;
    private Integer teamwork;
    private Integer minPersonnel;
    private Integer maxPersonnel;
    private Integer difficulty;
    private String genre;
    private String point;
    private String youtubeLink;
    private String colorCode;
    private Boolean hasXKit;
    private Boolean isCrimeScene;

    public static ThemeDto toDto(ThemeModifyRequest request) {
        return new ThemeDto(
                request.getName(),
                request.getMainImage(),
                request.getBgImage(),
                request.getPrice(),
                request.getDesc(),
                request.getReasoning(),
                request.getObservation(),
                request.getActivity(),
                request.getTeamwork(),
                request.getMinPersonnel(),
                request.getMaxPersonnel(),
                request.getDifficulty(),
                request.getGenre(),
                request.getPoint(),
                request.getYoutubeLink(),
                request.getColorCode(),
                request.getHasXKit(),
                request.getIsCrimeScene()
        );
    }
}
