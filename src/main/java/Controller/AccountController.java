package Controller;

import Database.TextdbConnect;
import Model.Amount;
import Model.Income;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;



public class AccountController implements Showlist{

    @FXML
    TableColumn<Income, String> typetable;

    @FXML
    TableColumn<Income, String> informtable;

    @FXML
    TableColumn<Income, String> amounttable;

    @FXML
    TableView<Income> allTable;

    @FXML
    private ComboBox typecolumn;

    @FXML
    private TextField amountField;

    @FXML
    private Button addbt;

    @FXML
    private Button modbt;

    @FXML
    private TextField commentF;
    @FXML
    private Label totalbalance;

    private ObservableList<String> typ = FXCollections.observableArrayList("Income","Expense");
    private ObservableList<Income> data =FXCollections.observableArrayList();
    private Income in;
    private Amount newAmount = new Amount();




    @FXML
    public void initialize(){
        showAlllist();
    }

    @FXML
    public void handleAdd(ActionEvent e){
        String setType = typecolumn.getValue().toString();
        if (!setType.equals("Choose Type") && e.getSource().equals(addbt) && setType.equals("Income")){
            in = new Income(amountField.getText()+"",typecolumn.getValue()+"",commentF.getText()+"");
            newAmount.setTotalAmount(1,Integer.parseInt(amountField.getText())); // calculate new input.
            amountField.clear();
            TextdbConnect.writer(in);
            data.add(in);
            commentF.clear();
            setAmountfield();
        }else if ((!setType.equals("Choose Type") && e.getSource().equals(addbt) && setType.equals("Expense"))){
            in = new Income(amountField.getText()+"",typecolumn.getValue()+"",commentF.getText()+"");
            newAmount.setTotalAmount(0,Integer.parseInt(amountField.getText())); // calculate new input.
            amountField.clear();
            TextdbConnect.writer(in);
            data.add(in);
            commentF.clear();
            setAmountfield();
        }

    }

    @FXML
    public void setAmountfield(){
        totalbalance.setStyle("-fx-text-fill: green");
        totalbalance.setText(newAmount.getTotalAmount()+"");
    }

    @FXML
    public void showList(){
        String[] separateList = TextdbConnect.readFile().split("#");
        for (String i :separateList) {
            System.out.print(i);
        }
        for (int i = 0; i < separateList.length ; i++) {
            String[] toshowList = separateList[i].split(",");
            in = new Income(toshowList[2],toshowList[0],toshowList[1]);
            if (toshowList[0].equals("Income")) {
                newAmount.setTotalAmount(1,Integer.parseInt(toshowList[2]));
            }if (toshowList[0].equals("Expense")){
                newAmount.setTotalAmount(0,Integer.parseInt(toshowList[2]));
            }
            data.add(in);
        }
        totalbalance.setStyle("-fx-text-fill: green");
        totalbalance.setText(newAmount.getTotalAmount()+"");

    }


    @FXML
    public void showAlllist(){
        typecolumn.setValue("Choose Type");
        typecolumn.setItems(typ);
        ///
        typetable.setCellValueFactory(cellData->cellData.getValue().typeProperty());
        informtable.setCellValueFactory(cellData->cellData.getValue().commentProperty());
        amounttable.setCellValueFactory(cellData->cellData.getValue().incomeProperty());
        allTable.setItems(data);
        totalbalance.setText(newAmount.getTotalAmount()+"");//show the last input of column
        showList();
    }






}
