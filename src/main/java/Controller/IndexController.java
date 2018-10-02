package Controller;

import Database.TextdbConnect;
import Model.Amount;
import Model.Income;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;

public class IndexController implements Showlist{
    protected Button enter;
    @FXML
    protected Label indexBalance;
    private Amount showIndex = new Amount();

    @FXML
    public void initialize(){
        showList();
    }



    @Override
    public void showList() {
        String[] separateList = TextdbConnect.readFile().split("#");
        for (int i = 0; i < separateList.length ; i++) {
            String[] toshowList = separateList[i].split(",");
            if (toshowList[0].equals("Income")) {
                showIndex.setTotalAmount(1,Integer.parseInt(toshowList[2]));
            }if (toshowList[0].equals("Expense")){
                showIndex.setTotalAmount(0,Integer.parseInt(toshowList[2]));
            }
        }
        setIndexBalance();
    }

    @FXML
    public void setIndexBalance(){
        indexBalance.setText(String.valueOf(showIndex.getTotalAmount()));
    }


    @FXML
    public void handleEnter(ActionEvent e){
        enter = (Button) e.getSource();
        Stage stage = (Stage) enter.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/Account.fxml")) ;

        try {
            stage.setScene(new Scene(loader.load(),640,480));
            stage.setTitle("Register user");

            AccountController controller = (AccountController) loader.getController();

            stage.show();
        } catch (IOException e1){
            e1.printStackTrace();
        }

    }
}
