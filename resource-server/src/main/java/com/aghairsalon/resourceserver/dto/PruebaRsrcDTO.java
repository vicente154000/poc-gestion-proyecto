package com.aghairsalon.resourceserver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PruebaRsrcDTO {
    private int id;
    private String userKey;
    private String value;
}
