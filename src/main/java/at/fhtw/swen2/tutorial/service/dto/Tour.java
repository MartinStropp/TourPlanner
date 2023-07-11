package at.fhtw.swen2.tutorial.service.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Tour {

    private Long id;
    private String name;
    private String description;
    private String start;
    private String destination;
    private String transportType;

}
