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
    private String description;
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

}
