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
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.beans.binding.Bindings;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuItem;
import javafx.stage.DirectoryChooser;
import javafx.util.Duration;
/**
 *
 * @author andrea
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField labelDayOfMonth;
    @FXML
    private TextField labelDayOfWeek;
    @FXML
    private DatePicker DatePickerID;
    @FXML
    private TextField labelWriteMessage;
    @FXML
    private Button FileButton;
    @FXML
    private TextField inputExternalProgram;
    @FXML
    private TextField outputExternalProgram;
    @FXML
    private Button ProgramButtonID;
    @FXML
    private TextField interpreteLabelID;
    @FXML
    private TextField commandProgramID;
    @FXML
    private TextField labelFileExistence;
    @FXML
    private TextField textFieldFileSize;
    @FXML
    private VBox MultiActionVBox;
    
    
    

    public void setStage(Stage stage) {
        this.stage = stage;
    }
    
    @FXML
    private ComboBox<String> triggerComboBoxID;
    @FXML
    private ComboBox<String> actionsComboBoxID;
    @FXML
    private ComboBox<String> RuleTypeID;
    @FXML
    private TextField labelOrarioID;
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
    private File selectedFileWrite;
    private File programSelected;
    private File selectedProgram;
    private File fileToCompare;
    private String audio_path;
    private String program_path;
    private String pathFileToCompare;
    private File directoryDestinazione=null;
    private RuleManager manager = RuleManager.getInstance();//new RuleManager();RuleManager.getInstance();
    RuleChecker RuleChecker = new RuleChecker(manager.getList(),mainTab);
    private MultiAction multiAc;
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Viene definita una struttura per contenere i diversi tipi di trigger
        ObservableList<String> itemsTriggers = FXCollections.observableArrayList("TimeOfDay", "DayOfMonth", "DayOfWeek", "Annual", "ExternalProgram", "FileExistence","FileSize");
        triggerComboBoxID.setItems(itemsTriggers);
        
        // Viene definita una struttura per contenere i diversi tipi di azioni
        ObservableList<String> itemsActions = FXCollections.observableArrayList("MultiAction","Audio", "Message", "Delete File", "MoveFile", "CopyFile", "WriteOnFile","ExternalProgram");
        actionsComboBoxID.setItems(itemsActions);
        
        // Viene definita una struttura per contenere i tre comportamenti delle regole
        ObservableList<String> itemsRuleType = FXCollections.observableArrayList("NORMAL_FIRING", "FIRE_ONCE","SLEEP_AFTER_FIRING");
        RuleTypeID.setItems(itemsRuleType);
        
        //disabilita i bottoni "elimina", "attiva" e "disattiva" se una regola non è selezionata
        disableButton.disableProperty().bind(Bindings.isEmpty(mainTab.getSelectionModel().getSelectedItems()));
        deleteButton.disableProperty().bind(Bindings.isEmpty(mainTab.getSelectionModel().getSelectedItems()));
        activeButton.disableProperty().bind(Bindings.isEmpty(mainTab.getSelectionModel().getSelectedItems()));
        
        // Imposta un listener sulla selezione della ComboBox
        triggerComboBoxID.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            // Controlla il valore selezionato e mostra/nascondi la Label in base ad esso
            clearTriggerItems();
            if (newValue != null)
                switch (newValue) {
                    case "TimeOfDay":
                        labelOrarioID.setVisible(true);
                        break;
                    case "DayOfMonth":
                        labelDayOfMonth.setVisible(true);
                        break;
                    case "DayOfWeek":
                        labelDayOfWeek.setVisible(true);
                        break;
                    case "Annual":
                        DatePickerID.setVisible(true);
                        break;
                    case "ExternalProgram":
                        inputExternalProgram.setVisible(true);
                        outputExternalProgram.setVisible(true);
                        interpreteLabelID.setVisible(true);
                        ProgramButtonID.setVisible(true);
                        break;
                    case "FileExistence":
                        labelFileExistence.setVisible(true);
                        break;
                    case "FileSize":
                        ProgramButtonID.setVisible(true);
                        textFieldFileSize.setVisible(true);
                        break;
                }
        });
        
        // Imposta un listener sulla selezione della ComboBox
        actionsComboBoxID.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            clearActionItems();
            if (newValue != null)
                switch (newValue) {
                    case "Audio":
                    case "Delete File":
                    case "MoveFile":
                    case "CopyFile":
                        FileButton.setVisible(true);
                        break;
                    case "Seleziona File":
                        FileButton.setVisible(true);
                        labelWriteMessage.setVisible(true);
                        break;
                    case "Message":
                        labelMessageActionID.setVisible(true);
                        break;
                    case "WriteOnFile":
                        FileButton.setVisible(true);
                        labelWriteMessage.setVisible(true);
                        break;
                    case "ExternalProgram":
                        FileButton.setVisible(true);
                        commandProgramID.setVisible(true);
                        break;
                    case "MultiAction":
                        MultiActionVBox.setSpacing(10);
                        multiAc = new MultiAction();
                        multiAc.initNewAction(MultiActionVBox,itemsActions);
                        break;
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
        DatePickerID.setOnAction(e -> updateStateButton());
        labelMessageActionID.textProperty().addListener((observable,oldValue,newValue) -> updateStateButton());
        SleepingID.textProperty().addListener((observable,oldValue,newValue) -> updateStateButton());
        RuleTypeID.setOnAction(e -> updateStateButton());
        labelDayOfMonth.textProperty().addListener((observable, oldvalue, newValue) -> updateStateButton());
        labelWriteMessage.textProperty().addListener((observable,oldvalue,newValue) -> updateStateButton());
        commandProgramID.textProperty().addListener((observable,oldvalue,newValue) -> updateStateButton());
        labelDayOfWeek.textProperty().addListener((observable,oldvalue,newValue) -> updateStateButton());
        inputExternalProgram.textProperty().addListener((observable,oldvalue,newValue) -> updateStateButton());
        outputExternalProgram.textProperty().addListener((observable,oldvalue,newValue) -> updateStateButton());
        interpreteLabelID.textProperty().addListener((observable,oldvalue,newValue) -> updateStateButton());
        labelFileExistence.textProperty().addListener((observable, oldvalue, newValue) -> updateStateButton());
        textFieldFileSize.textProperty().addListener((observable, oldvalue, newValue) -> updateStateButton());
        
        // Service
        RuleChecker rc = new RuleChecker(manager.getList(),mainTab);
        rc.setPeriod(Duration.seconds(5));
        rc.start();
        RuleChecker = rc;
        
        // LoadFile
        loadFile(null);
        
        //fa si che nel datepicker sia impossibile selezionare date precedenti a quella attuale
        DatePickerID.setDayCellFactory(picker -> new DateCell() {
        @Override
        public void updateItem(LocalDate date, boolean empty) {
            super.updateItem(date, empty);
            // Disabilita le date precedenti alla data attuale
            setDisable(date.isBefore(LocalDate.now()));
        }
        });
    }    

    // Clears all graphics items for triggers (configured to listener to combobox of triggers)
    private void clearTriggerItems() {
        labelOrarioID.setVisible(false);
        labelDayOfMonth.clear();
        labelDayOfMonth.setVisible(false);
        labelDayOfWeek.clear();
        labelDayOfWeek.setVisible(false);
        DatePickerID.setValue(null);
        DatePickerID.setVisible(false);
        labelFileExistence.clear();
        labelFileExistence.setVisible(false);
        inputExternalProgram.setVisible(false);
        interpreteLabelID.setVisible(false);
        outputExternalProgram.setVisible(false);
        inputExternalProgram.clear();
        outputExternalProgram.clear();
        interpreteLabelID.clear();
        programSelected=null;
        ProgramButtonID.setVisible(false);
        textFieldFileSize.setVisible(false);
        textFieldFileSize.clear();
        fileToCompare=null;
    }
    // Clears all graphics items for actions (configured to listener to combobox of actions)
    private void clearActionItems() {
        FileButton.setText("Seleziona File");
        FileButton.setVisible(false);
        labelMessageActionID.setVisible(false);
        labelWriteMessage.setVisible(false);
        commandProgramID.setVisible(false);
        CreaRegolaID.setDisable(true);
        selectedFile=null;
        directoryDestinazione=null;
        selectedFileWrite=null;
        selectedProgram=null;
        MultiActionVBox.getChildren().clear();
    }

    @FXML
    private void SelectFile(ActionEvent event) {
        // Finestra di selezione del File
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleziona il file");
        // Filtro se deve essere un File Audio
        if(actionsComboBoxID.getValue().equals("Audio")){
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("File audio", "*.mp3", "*.wav", "*.aac")
            );
        }
        // Mostra il dialogo di selezione file e ottieni il file selezionato
        if(actionsComboBoxID.getValue().equals("WriteOnFile")){
            selectedFileWrite=fileChooser.showOpenDialog(stage);
        }else if(actionsComboBoxID.getValue().equals("ExternalProgram")){
            selectedProgram=fileChooser.showOpenDialog(stage);
        }else
            selectedFile=fileChooser.showOpenDialog(stage);
        
        //mostro il dialogo di selezione cartella e ottengo la directory di destinazione
        if(actionsComboBoxID.getValue().equals("MoveFile") || actionsComboBoxID.getValue().equals("CopyFile")){
            if (fileChooser==null) return;
            DirectoryChooser directoryChooser = new DirectoryChooser();
            directoryChooser.setTitle("Seleziona la directory di destinazione");
            directoryDestinazione = directoryChooser.showDialog(stage);
        }
        
        
        // Se un file è stato selezionato, imposta il percorso nel TextField
        if (selectedFile != null && directoryDestinazione==null) {
            FileButton.setText(selectedFile.getName());
            audio_path=selectedFile.getAbsolutePath();
            System.out.println("percorso file: "+audio_path);
        } else if(selectedFile!=null && directoryDestinazione!=null){
            FileButton.setText(selectedFile.getName()+"/"+directoryDestinazione.getName());
            System.out.println("File e directory scelti: "+selectedFile.getAbsolutePath()+directoryDestinazione.getAbsolutePath());
        } else if(selectedFileWrite!=null){
            FileButton.setText(selectedFileWrite.getName());
        } else if(selectedProgram!=null){
            audio_path=selectedProgram.getAbsolutePath();
            FileButton.setText(selectedProgram.getName());
        } 
        updateStateButton();
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
        // controllo formato giorno del mese 
        boolean dayOfMonthValid=isValidDay(labelDayOfMonth.getText());
        //controllo giorno della settimana valido
        boolean dayOfWeekValid = isValidFormatDate(labelDayOfWeek.getText());
        //controllo giorno dell'anno valido
        boolean dayOfYear = isValidYear(DatePickerID.getValue());
        //controllo che il nome del file sia valido
        boolean fileName = isValidName(labelFileExistence.getText());
        // Controllo sulla size inserita nel textfield
        boolean stringaDim=isValidDim(textFieldFileSize.getText());
        
        // Controllo sulla presenza del messaggio nel textfield
        boolean messaggioVuoto = labelMessageActionID.getText().isEmpty();
        boolean inputVuoto = inputExternalProgram.getText().isEmpty();
        boolean outputVuoto = outputExternalProgram.getText().isEmpty();
        boolean interpreteVuoto = interpreteLabelID.getText().isEmpty();
        boolean writeMessage=labelWriteMessage.getText().isEmpty();
        boolean programSelect=commandProgramID.getText().isEmpty();
        //imposto false al file selezionato e alla directory selezionata
        boolean fileSelezionato=false;
        boolean fileSelezionatoWrite=false;
        boolean fileProgrammaSelezionato=false;
        boolean directorySelezionata=false;
        boolean fileProgramSelected=false;
        boolean fileToCompareSelected=false;
        
        // Ottiene il valore dall comboBox 
        String valoreRuleType = RuleTypeID.getValue(); 
        // Stringhe per enumerazione
        String NF = EnumActivityType.NORMAL_FIRING.toString();
        String FO = EnumActivityType.FIRE_ONCE.toString();
        String SLP = EnumActivityType.SLEEP_AFTER_FIRING.toString();
        
        // -- Controlli sui trigger
        // Controllo sulla presenza del messaggio nel textfield
        boolean orarioSleepingValido = isValidFormat(SleepingID.getText());
                
        // -- Controlli sulle azioni
        // Controllo sulla combobox per veder se è stato selezionato un valore
        boolean ruleTypeChecked = valoreRuleType!=null;
        
        // Controllo MultiAction
        boolean isMultiActionValid = false;
        if (actionsComboBoxID.getValue()!=null && actionsComboBoxID.getValue().equals("MultiAction"))
            isMultiActionValid = multiAc.isValid();
        
        // Controllo se il file è stato selezionato
        if(selectedFile!=null){
            fileSelezionato=true;
            if(directoryDestinazione!=null){
                directorySelezionata=true;
            }
        }
        if(selectedFileWrite!=null){
            fileSelezionatoWrite=true;
        }
        
        if(programSelected!=null){
            fileProgrammaSelezionato=true;
        }
        
        if(selectedProgram!=null){
            fileProgramSelected=true;
        }
        
        if(fileToCompare!=null){
            fileToCompareSelected=true;
        }
        
        // Attivazione e disattivazione del pulsante !messaggioVuoto || fileSelezionato || (directorySelezionata&&fileSelezionato) || (!writeMessage&&fileSelezionato)
        if(((fileName || orarioValido || dayOfYear || dayOfWeekValid || dayOfMonthValid || (!interpreteVuoto&&!inputVuoto&&!outputVuoto&&fileProgrammaSelezionato) ||
                (fileToCompareSelected&&stringaDim)) && (!messaggioVuoto || fileSelezionato || directorySelezionata ||
                !writeMessage&&fileSelezionatoWrite || !programSelect&&fileProgramSelected || isMultiActionValid) 
                &&  ruleTypeChecked)==true){
            if(valoreRuleType.equals(SLP)){
                if(orarioSleepingValido){
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
        switch(action) {
            case "Message":
                stringaAction=labelMessageActionID.getText();
                break;
            case "Audio":
            case "Delete File":
                stringaAction=audio_path;
                break;
            case "MoveFile":
            case "CopyFile":
                String path1 = selectedFile.toString();
                String path2 = directoryDestinazione.toString();
                stringaAction=path1+"//"+path2;
                break;
            case "WriteOnFile":
                String pathW1 = selectedFileWrite.toString();
                String pathW2 = labelWriteMessage.getText();
                stringaAction=pathW1+"//"+pathW2;
                break;
            case "ExternalProgram":
                String command=commandProgramID.getText();
                stringaAction=command+"//"+audio_path;
                break;
        }
        
        //type of trigger
        switch (trigger) {
            case "TimeOfDay":
                stringTrigger=labelOrarioID.getText();
                break;
            case "DayOfMonth":
                stringTrigger=labelDayOfMonth.getText();
                break;
            case "DayOfWeek":
                stringTrigger=labelDayOfWeek.getText();
                break;
            case "Annual":
                stringTrigger=DatePickerID.getValue().toString();
                break;
            case "ExternalProgram":
                String interprete=interpreteLabelID.getText();
                String input=inputExternalProgram.getText();
                String output=outputExternalProgram.getText();
                stringTrigger=program_path+"//"+interprete+"//"+input+"//"+output;
                break;
            case "FileExistence":
                stringTrigger=labelFileExistence.getText();
                break;
            case "FileSize":
                String size = textFieldFileSize.getText();
                stringTrigger=pathFileToCompare+"//"+size;
                break;
        }
        
        //prende il valore activity type e lo strasforma in enum
        String valoreSelezionato = RuleTypeID.getValue();
        EnumActivityType mioEnum = EnumActivityType.valueOf(valoreSelezionato);
        
        //trigger and action creation
        Trigger t=TriggerFactory.getTrigger(trigger, stringTrigger);
        Action a;
        if (actionsComboBoxID.getValue().equals("MultiAction")) a = multiAc;
        else a = ActionFactory.create(action, stringaAction);
        
        
        //rule creation
        if (mioEnum != EnumActivityType.SLEEP_AFTER_FIRING) sleep="00:00:00";
        Rule r=new Rule("regola1", t, a, mioEnum, sleep);
        manager.add(r);
        
        //popolo la tabella
        setTabColumns();
        mainTab.setItems(manager.getList());
        
        //click bottone
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
    
    //funzione per 
    private void resetSecondVBox() {
        triggerComboBoxID.getSelectionModel().clearSelection();
        actionsComboBoxID.getSelectionModel().clearSelection();
        RuleTypeID.getSelectionModel().clearSelection();
        
        labelOrarioID.clear();
        labelOrarioID.setVisible(false);
        labelMessageActionID.clear();
        labelMessageActionID.setVisible(false);
        labelDayOfMonth.clear();
        labelDayOfMonth.setVisible(false);
        labelDayOfWeek.clear();
        labelDayOfWeek.setVisible(false);
        selectedFile=null;
        selectedFileWrite=null;
        directoryDestinazione=null;
        FileButton.setVisible(false);
        labelWriteMessage.setVisible(false);
        labelWriteMessage.clear();
        commandProgramID.setVisible(false);
        commandProgramID.clear();
        DatePickerID.setValue(null);
        programSelected=null;
        inputExternalProgram.setVisible(false);
        inputExternalProgram.clear();
        outputExternalProgram.setVisible(false);
        outputExternalProgram.clear();
        interpreteLabelID.setVisible(false);
        interpreteLabelID.clear();
        ProgramButtonID.setVisible(false);
        textFieldFileSize.clear();
        fileToCompare=null;
        textFieldFileSize.setVisible(false);
        labelFileExistence.clear();
        labelFileExistence.setVisible(false);
        
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
    
    private boolean isValidDay(String day) {
        if(day.isEmpty() || (day.length()!=2) || !day.matches("\\d+"))return false;
        int numero = Integer.parseInt(day);
        return numero>=1 && numero<=31;
    }
    
    private boolean isValidFormatDate(String day) {
        if (day.equals("Monday") || day.equals("Tuesday") || day.equals("Wednesday") || day.equals("Thursday" )
                || day.equals("Friday") || day.equals("Saturday") || day.equals("Sunday"))
            return true;
        else
            return false;
    }
    
    private boolean isValidYear(LocalDate day) {
        return day!=null;
    }

    @FXML
    private void ProgramButton(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleziona il file");
        
        if(triggerComboBoxID.getValue().equals("ExternalProgram")){
            programSelected=fileChooser.showOpenDialog(stage);
        }else if(triggerComboBoxID.getValue().equals("FileSize")){
            fileToCompare=fileChooser.showOpenDialog(stage);
        }
        
        if(fileToCompare!=null){
            pathFileToCompare=fileToCompare.getAbsolutePath();
            ProgramButtonID.setText(fileToCompare.getName());
        }
        
        if(programSelected!=null){
            ProgramButtonID.setText(programSelected.getName());
            program_path=programSelected.getAbsolutePath();
            System.out.println("percorso file: "+program_path);
        }
        updateStateButton();
    }
    
    private boolean isValidName(String name){
        String regex="[a-zA-Z0-9_.-]+$";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(name);
        
        return matcher.matches();
    }
    
    private static boolean isValidDim(String inputString) {
        try {
            // Prova a convertire la stringa in un numero a virgola mobile
            double doubleValue = Double.parseDouble(inputString);
            return true;
        } catch (NumberFormatException e) {
            // Se la conversione fallisce, la stringa non è un numero
            return false;
        }
    }
}
