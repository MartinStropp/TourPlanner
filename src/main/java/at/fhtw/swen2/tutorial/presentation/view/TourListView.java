package at.fhtw.swen2.tutorial.presentation.view;

import at.fhtw.swen2.tutorial.presentation.viewmodel.TourListViewModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
@Scope("prototype")
public class TourListView implements Initializable{

    @Autowired
    public TourListViewModel tourListViewModel;

    @FXML
    public TableView tableView = new TableView<>();
    @FXML
    private VBox dataContainer;

    @Override
    public void initialize(URL location, ResourceBundle rb){
        tableView.setItems(tourListViewModel.getTourListItems());
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        TableColumn id = new TableColumn("ID");
        id.setCellValueFactory(new PropertyValueFactory("id"));
        TableColumn name = new TableColumn("NAME");
        name.setCellValueFactory(new PropertyValueFactory("name"));
        TableColumn description = new TableColumn("DESCRIPTION");
        description.setCellValueFactory(new PropertyValueFactory("description"));
        TableColumn start = new TableColumn("START");
        start.setCellValueFactory(new PropertyValueFactory("start"));
        TableColumn destination = new TableColumn("DESTINATION");
        start.setCellValueFactory(new PropertyValueFactory("destination"));
        TableColumn transportType = new TableColumn("TRANSPORT_TYPE");
        start.setCellValueFactory(new PropertyValueFactory("transportType"));
        tableView.getColumns().addAll(id, name, description, start, destination, transportType);

        dataContainer.getChildren().add(tableView);
        tourListViewModel.initList();
    }

}
