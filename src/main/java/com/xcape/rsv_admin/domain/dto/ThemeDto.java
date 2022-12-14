package com.xcape.rsv_admin.domain.dto;

import com.xcape.rsv_admin.domain.entity.Theme;
import lombok.*;

/**
 * A DTO for the {@link com.xcape.rsv_admin.domain.entity.Theme} entity
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class ThemeDto {

    private Long id;
    private Long merchantId;
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

    public static ThemeDto fromEntity(Theme entity) {
        return new ThemeDto(entity.getId(), entity.getMerchant().getId(), entity.getName(), entity.getMainImage(), entity.getBgImage(), entity.getPrice(), entity.getDesc(), entity.getReasoning(), entity.getObservation(), entity.getActivity(), entity.getTeamwork(), entity.getMinPersonnel(), entity.getMaxPersonnel(), entity.getDifficulty(), entity.getGenre(), entity.getPoint(), entity.getYoutubeLink(), entity.getColorCode(), entity.getHasXKit(), entity.getIsCrimeScene());
    }
}