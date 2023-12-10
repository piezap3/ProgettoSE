/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Window;

/**
 * Composite class to run multiple actions for the same rule.
 * @author Marco
 */
public class MultiAction implements Action, Serializable {    
    private List<Action> childActions;
    private int quantity;
    private boolean valid;
    
    /**
     * Constructor. Creates and empty list of actions
     */
    public MultiAction() {
        this.childActions = new ArrayList<>();
        this.quantity = 0;
        this.valid = false;
    }
    
    /**
     * Add action to MultiAction
     * @param action 
     */
    public void addAction(Action action) {
        childActions.add(action);
    }
    /**
     * Add action to MultiAction
     * @param type type of action
     * @param str string of action
     */
    public void addAction(String type, String str) {
        childActions.add(ActionFactory.create(type, str));
    }

    /**
     * Exec all actions in MultiAction. Actions are executed in the order they are inserted
     */
    @Override
    public void exec() {
        childActions.forEach(Action::exec);
    }

    /**
     * String Property to show in JavaFX Tab
     * @return String Property
     */
    @Override
    public StringProperty actionAttribute() {
        StringProperty p;
        p = new SimpleStringProperty("MultiAction of "+this.getQuantity()+" actions");
        return p;
    }
    /**
     * Method to increase quantity
     */
    private void increaseQuantity() {
        this.quantity++;
    }
    /**
     * Method to get quantity of actions
     * @return number of elements in multiaction
     */
    public int getQuantity() {
        return this.quantity;
    }
    /**
     * Method to get validity of multiaction
     * @return True if all action are correcly formatted. False otherwise
     */
    public boolean isValid() {
        return this.valid;
    }
    /**
     * Prints in console all StringProperties of actions in multiactions
     */
    public void printActionList() {
        for (Action a : this.childActions) {
            System.out.println(a.actionAttribute());
        }
    }
    
    /**
     * Method to create a new action box in the create rule interface
     * @param vbox Vertical Box where actions boxes are added
     * @param itemsActions List to display in the combobox for each action
     */
    public void initNewAction(VBox vbox,ObservableList<String> itemsActions) {
        // Create empty HBox
        HBox ruleBox = new HBox();
        vbox.getChildren().add(ruleBox);
        ruleBox.setSpacing(20);
        // List with filtered options
        ObservableList<String> itemsAFiltered = FXCollections.observableArrayList();
        itemsAFiltered.addAll(itemsActions);
        itemsAFiltered.remove("MultiAction");
        // ComboBox for action selection
        ComboBox actionList = new ComboBox();
        actionList.setValue("Action"); // Title
        actionList.setItems(itemsAFiltered);
        ruleBox.getChildren().add(actionList);
        // VBox for items of action (like buttons and textboxes)
        VBox ruleItemsBox = new VBox();
        ruleBox.getChildren().add(ruleItemsBox);
        ruleItemsBox.setSpacing(5);
        // Increase Quantity
        this.increaseQuantity();
        // Add + button to create new rule
        HBox buttonBox = new HBox();
        buttonBox.setSpacing(5);
        Button addMA = new Button("+");
        Button doneB = new Button("Done");
        if (this.getQuantity()<5) {
            // if less than 5 actions
            buttonBox.getChildren().addAll(addMA,doneB);
            // addMA button event
            addMA.setOnAction(event -> {
                buttonBox.getChildren().clear();
                ruleItemsBox.setDisable(true);
                actionList.setDisable(true);
                this.addActionFromButtons(actionList.getSelectionModel().getSelectedItem().toString(),ruleItemsBox);
                this.initNewAction(vbox, itemsActions);
            });
        } else {
            // if 5 (or more) actions
            buttonBox.getChildren().add(doneB);
        }
        // Done Button
        doneB.setOnAction(event -> {
                buttonBox.getChildren().clear();
                ruleItemsBox.setDisable(true);
                actionList.setDisable(true);
                this.addActionFromButtons(actionList.getSelectionModel().getSelectedItem().toString(),ruleItemsBox);
                this.valid = true;
            });
        buttonBox.setDisable(true);
        vbox.getChildren().add(buttonBox);
        // ComboBox Listener
        this.addComboListener(actionList,ruleItemsBox,buttonBox);
    }
    /**
     * Adds listener to combobox and calls to add listeners to related items
     * @param cb combobox
     * @param itemBox vbox to place items for actions (like textboxes or buttons)
     * @param buttonBox hbox with the buttons to enable/disable
     */
    private void addComboListener(ComboBox cb, VBox itemBox, HBox buttonBox) {
        cb.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            buttonBox.setDisable(true);
            Button bt = new Button("Seleziona File");
            bt.setId("fileButton");
            TextField tf = new TextField();
            tf.setId("userText");
            switch ((String) newValue) {
                /* Foe each case:
                    - Remove items in itemBox and add only the ones needed
                    - Add listeners to items that need to be compiled by the user
                    - Make buttonBox appear only when items are compiled in the correct way
                    - Make multiaction valid if items are compiled in the correct way
                */
                case "Audio":
                case "Delete File":
                case "MoveFile":
                case "CopyFile":
                    itemBox.getChildren().clear();
                    bt.setOnAction(l -> {
                        addFileChoserToButton(bt, (String) newValue, buttonBox);
                    });
                    itemBox.getChildren().add(bt);
                    break;
                case "WriteOnFile":
                case "ExternalProgram":
                    itemBox.getChildren().clear();
                    bt.setOnAction(l -> {
                        addFileChoserToButton(bt, (String) newValue, buttonBox);
                    });
                    // Listeners
                    bt.textProperty().addListener((obv,oldV,newV) -> {
                        buttonBox.setDisable(true);
                        String btext = (String) newV;
                        if (!btext.equals("Seleziona File") &&
                                !tf.textProperty().getValue().isEmpty()) {
                            buttonBox.setDisable(false);
                        }
                    });
                    tf.textProperty().addListener(l -> {
                        buttonBox.setDisable(true);
                        if (!bt.textProperty().get().equals("Seleziona File") &&
                                !tf.textProperty().getValue().isEmpty()) {
                            buttonBox.setDisable(false);
                        }
                    });
                    itemBox.getChildren().addAll(bt,tf);
                    break;
                case "Message":
                    itemBox.getChildren().clear();
                    tf.textProperty().addListener(l -> {
                            buttonBox.setDisable(tf.textProperty().getValue().isEmpty());
                        });
                    itemBox.getChildren().add(tf);
                    break;
            }
        });
    }
    
    /**
     * Method that adds functionality to buttons of action items
     * @param bt Button for file selection
     * @param type Action type
     * @param buttonBox HBox with buttons
     */
    private void addFileChoserToButton(Button bt, String type, HBox buttonBox) {
        bt.setText("Seleziona File");
        buttonBox.setDisable(true);
        // FileChooser to select File
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleziona il file");
        // If Action is "Audio" filter for audio files
        if (type.equals("Audio"))
            fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Audio File", "*.mp3", "*.wav", "*.aac"));
        // If Action is "WriteOnFile" filter for text files
        if (type.equals("WriteOnFile"))
            fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text File", "*.txt"));
        // Open File Selection Window
        Window ownerWindow = null;
        File selectedFile = fileChooser.showOpenDialog(ownerWindow);
        if (selectedFile==null) return;
        String pathString = selectedFile.toString();
        File directoryDestinazione = null;
        // If Action is "MoveFile" or "CopyFile" open DirectoryChooser
        if (type.equals("MoveFile") || type.equals("CopyFile")) {
            DirectoryChooser directoryChooser = new DirectoryChooser();
            directoryChooser.setTitle("Seleziona la directory di destinazione");
            directoryDestinazione = directoryChooser.showDialog(ownerWindow);
            if (directoryDestinazione==null) return;
            pathString = pathString+"//"+directoryDestinazione.toString();
        }
        // Files correctly chosen
        bt.setText(pathString);
        if (!type.equals("WriteOnFile")) buttonBox.setDisable(false);
    }
    
    private void addActionFromButtons(String type, VBox itemBox) {
        TextField textF = (TextField) itemBox.lookup("#userText");
        Button bt = (Button) itemBox.lookup("#fileButton");
        String actionText;     // final string to create action
        String tfText="";      // string from textfield
        String btText="";      // string from button
        if (textF!=null) tfText = textF.textProperty().getValue();
        if (bt!=null) btText = bt.getText();
        /* Time to create string for action
            - Text string will be in tfText. Empty if textField is not present
            - Button string will be in btText. Empty if button is not present
        */
        switch (type) {
            case "WriteOnFile":
                actionText = btText+"//"+tfText;
                break;
            case "ExternalProgram":
                actionText = tfText+"//"+btText;
                break;
            default:
                actionText = btText+tfText;
                break;
        }
        this.addAction(type, actionText);
    }
}
