package at.fhtw.swen2.tutorial.presentation.viewmodel;

import at.fhtw.swen2.tutorial.service.TourService;
import at.fhtw.swen2.tutorial.service.dto.Tour;
import javafx.beans.property.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class NewTourViewModel {
    private SimpleLongProperty id = new SimpleLongProperty();
    private SimpleStringProperty name = new SimpleStringProperty();
    private SimpleStringProperty description = new SimpleStringProperty();
    private SimpleStringProperty start = new SimpleStringProperty();
    private SimpleStringProperty destination = new SimpleStringProperty();
    private SimpleStringProperty transportType = new SimpleStringProperty();

    @Autowired
    private TourService tourService;
    @Autowired
    private TourListViewModel tourListViewModel;

    private Tour tour;


    public NewTourViewModel() {

    }

    public NewTourViewModel(Tour tour) {
        this.tour = tour;
        this.id = new SimpleLongProperty(tour.getId());
        this.name = new SimpleStringProperty(tour.getName());
        this.description = new SimpleStringProperty(tour.getDescription());
        this.start = new SimpleStringProperty(tour.getStart());
        this.destination = new SimpleStringProperty(tour.getDestination());
        this.transportType = new SimpleStringProperty(tour.getTransportType());
    }

    public long getId() {
        return id.get();
    }

    public LongProperty idProperty() {
        return id;
    }

    public void setId(long id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getDescription() {
        return description.get();
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public String getStart() {
        return start.get();
    }

    public StringProperty startProperty() {
        return start;
    }

    public void setStart(String start) {
        this.start.set(start);
    }

    public String getDestination() {
        return destination.get();
    }

    public StringProperty destinationProperty() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination.set(destination);
    }

    public String getTransportType() {
        return transportType.get();
    }

    public StringProperty transportTypeProperty() {
        return transportType;
    }

    public void addNewTour() {
        Tour tour = Tour.builder()
                .name(getName())
                .description(getDescription())
                .start(getStart())
                .destination(getDestination())
                .transportType(getTransportType())
                .build();
        tour = tourService.addNew(tour);
        tourListViewModel.addItem(tour);
    }


}
