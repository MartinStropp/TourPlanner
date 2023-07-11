package at.fhtw.swen2.tutorial.presentation.view;

import at.fhtw.swen2.tutorial.presentation.viewmodel.NewTourViewModel;
import at.fhtw.swen2.tutorial.service.TourService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
@Scope("prototype")
@Slf4j
public class NewTourView implements Initializable {

    @Autowired
    private TourService tourService;
    @Autowired
    private SearchView searchView;
    @Autowired
    private NewTourViewModel newTourViewModel;

    @FXML
    private Text feedbackText;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField descriptionTextField;
    @FXML
    private TextField startTextField;
    @FXML
    private TextField destinationTextField;
    @FXML
    private TextField transportTypeTextField;



    @Override
    public void initialize(URL location, ResourceBundle rb) {
        nameTextField.textProperty().bindBidirectional(newTourViewModel.nameProperty());
        descriptionTextField.textProperty().bindBidirectional(newTourViewModel.descriptionProperty());
        startTextField.textProperty().bindBidirectional(newTourViewModel.startProperty());
        destinationTextField.textProperty().bindBidirectional(newTourViewModel.destinationProperty());
        transportTypeTextField.textProperty().bindBidirectional(newTourViewModel.transportTypeProperty());

    }

    public void submitButtonAction(ActionEvent event) {
        if ((nameTextField.getText()==null) || (descriptionTextField.getText()==null) || (startTextField.getText()==null) || (destinationTextField.getText()==null) || (transportTypeTextField.getText()==null)) {
            feedbackText.setText("no correct input!");
            return;
        } else if ((nameTextField.getText().isEmpty()) || (startTextField.getText().isEmpty()) || (destinationTextField.getText().isEmpty()) || (transportTypeTextField.getText().isEmpty())) {
            feedbackText.setText("no correct input!");
            return;
        }

        feedbackText.setText("");
        newTourViewModel.addNewTour();
    }
}
