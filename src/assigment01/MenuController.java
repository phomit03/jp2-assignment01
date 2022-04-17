package assigment01;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void listStScreen() throws Exception{
        try{
            //tạo stage để tạo ra 2 cửa sổ
            Stage formStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("student/studentlist.fxml"));
            formStage.setTitle("Student list");
            formStage.setScene(new Scene(root, 1100, 650));
            formStage.show();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void listBookScreen() throws Exception{
        try{
            Stage formStage = new Stage();
            Parent root2 = FXMLLoader.load(getClass().getResource("book/booklist.fxml"));
            formStage.setTitle("Book list");
            formStage.setScene(new Scene(root2, 1100, 650));
            formStage.show();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void listLBScreen() throws Exception{
        try{
            Stage formStage = new Stage();
            Parent root3 = FXMLLoader.load(getClass().getResource("loanbook/loanbooklist.fxml"));
            formStage.setTitle("Loan book list");
            formStage.setScene(new Scene(root3, 1100, 650));
            formStage.show();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
