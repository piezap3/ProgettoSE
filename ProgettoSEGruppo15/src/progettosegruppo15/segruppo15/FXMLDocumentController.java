/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package segruppo15;

import Triggers.TriggerFactory;
import Actions.ActionFactory;
import MainClasses.EnumActivityType;
import MainClasses.Rule;
import MainClasses.RuleManager;
import java.io.File;
import java.net.URL;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import Actions.*;
import MainClasses.FileDirector;
import MainClasses.RuleChecker;
import Triggers.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.control.MenuItem;
import javafx.util.Duration;
/**
 *
 * @author andrea
 */
public class FXMLDocumentController implements Initializable {
     
    @FXML
    private Label label;
    @FXML
    private ComboBox<String> triggerComboBoxID;
    @FXML
    private ComboBox<String> actionsComboBoxID;
    @FXML
    private ComboBox<String> RuleTypeID;
    @FXML
    private TextField labelOrarioID;
    @FXML
    private Button FileAudioID;
    @FXML
    private TextField labelMessageActionID;
    private Stage stage;
    private TextField FilePathTextField;
    @FXML
    private Button CreaRegolaID;
    @FXML
    private MenuBar menuBar;
    @FXML
    private Button createButton;
    @FXML
    private Button activeButton;
    @FXML
    private Button disableButton;
    @FXML
    private Button deleteButton;
    @FXML
    private TableView<Rule> mainTab;
    @FXML
    private TableColumn<Rule, String> colTrigger;
    @FXML
    private TableColumn<Rule, String> colAction;
    @FXML
    private TableColumn<Rule, EnumActivityType> colMode;
    @FXML
    private TableColumn<Rule, String> stato;
    @FXML
    private Color x4;
    @FXML
    private Font x3;
    @FXML
    private VBox PrimaryVBox;
    @FXML
    private VBox SecondaryVBox;
    @FXML
    private TextField SleepingID;
    @FXML
    private MenuItem openFileID;
    @FXML
    private MenuItem saveFileID;
    
    private File selectedFile;
    private String audio_path;
    private RuleManager manager = new RuleManager();
    RuleChecker RuleChecker = new RuleChecker(manager.getList(),mainTab);
     
    
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Viene definita una struttura per contenere i diversi tipi di trigger
        ObservableList<String> itemsTriggers = FXCollections.observableArrayList("TimeOfDay");
        triggerComboBoxID.setItems(itemsTriggers);
        
        // Viene definita una struttura per contenere i diversi tipi di azioni
        ObservableList<String> itemsActions = FXCollections.observableArrayList("Audio", "Message");
        actionsComboBoxID.setItems(itemsActions);
        
        // Viene definita una struttura per contenere i tre comportamenti delle regole
        ObservableList<String> itemsRuleType = FXCollections.observableArrayList("NORMAL_FIRING", "FIRE_ONCE","SLEEP_AFTER_FIRING");
        RuleTypeID.setItems(itemsRuleType);
        
        // Imposta un listener sulla selezione della ComboBox
        triggerComboBoxID.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            // Controlla il valore selezionato e mostra/nascondi la Label in base ad esso
            if (newValue != null && newValue.equals("TimeOfDay")) {
                labelOrarioID.setVisible(true); // Mostra la Label se l'elemento selezionato è "Mostra Label"
            } else {
                labelOrarioID.setVisible(false); // Nascondi la Label per qualsiasi altro elemento selezionato
            }
        });
        
        // Imposta un listener sulla selezione della ComboBox
        actionsComboBoxID.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            // Controlla il valore selezionato e mostra/nascondi la Label in base ad esso
            if (newValue != null && newValue.equals("Audio")) {
                FileAudioID.setText("Seleziona File Audio");
                FileAudioID.setVisible(true);
                labelMessageActionID.setVisible(false);// Mostra la Label se l'elemento selezionato è "Mostra Label"
            } else if(newValue != null && newValue.equals("Message")){
                labelMessageActionID.setVisible(true);
                FileAudioID.setVisible(false);// Nascondi la Label per qualsiasi altro elemento selezionato
            }
        });
        
        // Mostra la selezione dell'orario in caso di Sleep After Firing
        RuleTypeID.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            // Controlla il valore selezionato e mostra/nascondi la Label in base ad esso
            if (newValue != null && newValue.equals(EnumActivityType.SLEEP_AFTER_FIRING.toString())) {
                SleepingID.setVisible(true);
            }
            else
                SleepingID.setVisible(false);
        });
             
        // Imposta un listener per la gestione del bottone Crea nella seconda schermata
        labelOrarioID.textProperty().addListener((observable,oldvalue,newValue) -> updateStateButton());
        labelMessageActionID.textProperty().addListener((observable,oldValue,newValue) -> updateStateButton());
        SleepingID.textProperty().addListener((observable,oldValue,newValue) -> updateStateButton());
        RuleTypeID.setOnAction(e -> updateStateButton());
        
        // Service
        RuleChecker rc = new RuleChecker(manager.getList(),mainTab);
        rc.setPeriod(Duration.seconds(5));
        rc.start();
        RuleChecker = rc;
        
        // LoadFile
        loadFile(null);
    }    

    @FXML
    private void triggerComboBox(ActionEvent event) {
    }

    @FXML
    private void actionsComboBox(ActionEvent event) {
    }

    @FXML
    private void labelOrario(ActionEvent event) {
    }

    @FXML
    private void FileAudio(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleziona file audio");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("File audio", "*.mp3", "*.wav", "*.aac")
        );

        // Mostra il dialogo di selezione file e ottieni il file selezionato
        selectedFile = fileChooser.showOpenDialog(stage);

        // Se un file è stato selezionato, imposta il percorso nel TextField
        if (selectedFile != null) {
            FileAudioID.setText(selectedFile.getName());
            audio_path=selectedFile.getAbsolutePath();
            System.out.println("percorso file: "+audio_path);
        }
    }

    @FXML
    private void labelMessageAction(ActionEvent event) {
    }

    private void creaRegola(ActionEvent event) {
        PrimaryVBox.setVisible(true);
        SecondaryVBox.setVisible(false);
    }

    @FXML
    private void creazioneRegola(ActionEvent event) {
        resetSecondVBox();
        PrimaryVBox.setVisible(false);
        SecondaryVBox.setVisible(true);
    }

    @FXML
    private void RuleType(ActionEvent event) {
    }

    @FXML
    private void Sleeping(ActionEvent event) {
    }
    
    // Funzione di utilità per controllare se i campi per gli orari sono compilati bene
    private boolean isValidFormat(String time) {
        String regex = "^([0-1]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(time);

        // Restituisci true se l'orario è nel formato corretto
        return matcher.matches();
    }
    
    // Metodo per attivare e disattivare il pulsante che "crea" durante la creazione delle regole
    private void updateStateButton(){
        CreaRegolaID.setDisable(true); // Bottone disabilitato
        // Controllo formato orario valido
        boolean orarioValido = isValidFormat(labelOrarioID.getText()); 
        // Controllo sulla presenza del messaggio nel textfield
        boolean messaggioVuoto = labelMessageActionID.getText().isEmpty();
        boolean fileSelezionato=false;
        String valoreRuleType = RuleTypeID.getValue(); // Ottiene il valore dall comboBox 
        // Stringhe per enumerazione
        String NF = EnumActivityType.NORMAL_FIRING.toString();
        String FO = EnumActivityType.FIRE_ONCE.toString();
        String SLP = EnumActivityType.SLEEP_AFTER_FIRING.toString();
        
        // -- Controlli sui trigger
        // Controllo sulla presenza del messaggio nel textfield
        boolean orarioSleepingValido = isValidFormat(SleepingID.getText());
        boolean ruleTypeChecked;
        
        // -- Controlli sulle azioni
        // Controllo sulla combobox per veder se è stato selezionato un valore
        if(RuleTypeID.getValue()!=null){
            ruleTypeChecked = true;
        }
        else ruleTypeChecked = false;
        
        // Controllo se il file audio è stato selezionato
        if(selectedFile!=null){
            fileSelezionato=true;
            FileAudioID.setText(selectedFile.getName());
        }
        
        // Attivazione e disattivazione del pulsante
        if((orarioValido && (!messaggioVuoto||fileSelezionato) && ruleTypeChecked)==true){
            if(valoreRuleType.equals(SLP)){
                if(orarioSleepingValido = isValidFormat(SleepingID.getText())){
                CreaRegolaID.setDisable(false);
                }
            }
            else if(valoreRuleType.equals(NF) || valoreRuleType.equals(FO)){
                CreaRegolaID.setDisable(false);
            }
        }
    }
    
    @FXML
    private void CreateAndAddRuleButton(ActionEvent event) {
        // Prendi i campi
        String trigger=triggerComboBoxID.getValue();
        String action=actionsComboBoxID.getValue();
        String type=RuleTypeID.getValue();
        String sleep=SleepingID.getText();
        String stringTrigger=null;
        String stringaAction=null;
        
        //type of action
        if(action.equals("Message")){
            stringaAction=labelMessageActionID.getText();
        }else if(action.equals("Audio")){
            //stringaAction=FilField.getText();
            stringaAction=audio_path;
        }
        
        //type of trigger
        if(trigger.equals("TimeOfDay")){
            stringTrigger=labelOrarioID.getText();
        }
        
        String valoreSelezionato = RuleTypeID.getValue();
        EnumActivityType mioEnum = EnumActivityType.valueOf(valoreSelezionato);
        
        //trigger and action creation
        Trigger t=TriggerFactory.getTrigger(trigger, stringTrigger);
        Action a=ActionFactory.create(action, stringaAction);
        
        
        //rule creation
        if (mioEnum != EnumActivityType.SLEEP_AFTER_FIRING) sleep="00:00:00";
        Rule r=new Rule("regola1", t, a, mioEnum, sleep);
        manager.add(r);
        
        setTabColumns();
        
        //popolo la tabella
        mainTab.setItems(manager.getList());
        creaRegola(event);
        
    }
    
    private void setTabColumns() {
        // colonna 1 (Trigger)
        colTrigger.setCellValueFactory(cellData -> cellData.getValue().getTrigger().triggerAttribute());
        // colonna 2 (Action)
        colAction.setCellValueFactory(cellData -> cellData.getValue().getAction().actionAttribute());
        // colonna 3 (Activity Type)
        colMode.setCellValueFactory(new PropertyValueFactory("activityType"));
        // colonna 4 (Activity)
        stato.setCellValueFactory(cellData -> cellData.getValue().getActivity());
    }
    
    @FXML
    private void ActivateRule(ActionEvent event){
        Rule r = mainTab.getSelectionModel().getSelectedItem();
        if (r == null) return;  // Return if rule isn't selected
        manager.activate(r);
        mainTab.refresh();
    }
    
    @FXML
    private void DeActivateRule(ActionEvent event){
        Rule r = mainTab.getSelectionModel().getSelectedItem();
        if (r == null) return;  // Return if rule isn't selected
        manager.deactivate(r);
        mainTab.refresh();
    }
    
    @FXML
    private void DeleteRule(ActionEvent event){
        Rule r = mainTab.getSelectionModel().getSelectedItem();
        if (r == null) return;
        manager.remove(r);
        mainTab.refresh();
    }
    
    private void resetSecondVBox() {
        triggerComboBoxID.getSelectionModel().clearSelection();
        actionsComboBoxID.getSelectionModel().clearSelection();
        RuleTypeID.getSelectionModel().clearSelection();
        
        labelMessageActionID.clear();
        labelMessageActionID.setVisible(false);
        selectedFile=null;
        FileAudioID.setVisible(false);
        
        labelOrarioID.clear();
        SleepingID.clear();
    }
    
    @FXML
    private void saveFile(ActionEvent event){
        FileDirector f=new FileDirector();
        f.saveRules(manager.getList());
    }
    
    @FXML
    private void loadFile(ActionEvent event){
        FileDirector f=new FileDirector();
        if (manager.loadList(f.loadRules()) == -1) return;
        RuleChecker.updateList(manager.getList());
        mainTab.setItems(manager.getList());
        setTabColumns();
    }
    
}
