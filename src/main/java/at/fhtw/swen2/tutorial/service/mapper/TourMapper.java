package at.fhtw.swen2.tutorial.service.mapper;

import at.fhtw.swen2.tutorial.persistence.entities.TourEntity;
import at.fhtw.swen2.tutorial.service.dto.Tour;
import org.springframework.stereotype.Component;

@Component
public class TourMapper extends AbstractMapper<TourEntity, Tour> {

    @Override
    public Tour fromEntity(TourEntity entity) {
        return Tour.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .start(entity.getStart())
                .destination(entity.getDestination())
                .transportType(entity.getTransportType())
                .build();
    }

    @Override
    public TourEntity toEntity(Tour tour) {
        return TourEntity.builder()
                .id(tour.getId())
                .name(tour.getName())
                .description(tour.getDescription())
                .start(tour.getStart())
                .destination(tour.getDestination())
                .transportType(tour.getTransportType())
                .build();
    }

}
