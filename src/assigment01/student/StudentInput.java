package assigment01.student;

import assigment01.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class StudentInput {
    public TextField inputsMaSV, inputsName, inputsDate, inputsGender;
    public TextArea inputsAddress;
    public Text errorMsg;

    public Student st;

    public final static String connectionString = "jdbc:mysql://localhost:3306/quanlythuvien";
    public final static String user = "root";
    public final static String password = "";

    public void backListSt() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("studentlist.fxml"));
        Main.rootStage.setScene(new Scene(root, 1100, 650));
    }

    public void submitSt() {   //cơ chế event-listener;
        //input
        String ma = this.inputsMaSV.getText();
        String name = this.inputsName.getText();
        String date = this.inputsDate.getText();
        String gender = this.inputsGender.getText();
        String address = this.inputsAddress.getText();

        //câu truy vấn sql: thêm sv vào database
        String sql_txt = "INSERT INTO sinhvien (maSV,hoTen,ngaySinh,gioiTinh,diaChi) " +
                " VALUES('"+ma+"','"+name+"','"+date+"','"+gender+"','"+address+"')";
        System.out.println(sql_txt);    //msg

        try {
            if (ma.isEmpty() || name.isEmpty() || date.equals("")  || gender.equals("") ||address.isEmpty()){
                throw new Exception("Please enter full product information!");
            }
            //kết nối với database
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(connectionString, user, password);
            Statement stt = conn.createStatement();

            // insert
            stt.execute(sql_txt);
            //dữ liệu đổ vào database, từ database tiếp tục đổ ngược lại tbStudent
            this.backListSt();  //tự động back lại nếu dữ liệu up lên và đổ về thành công


        } catch (NumberFormatException nf){
            errorMsg.setVisible(true);
            errorMsg.setFill(Color.RED);
            errorMsg.setText(nf.getMessage());
        }
        catch (Exception e) {
            errorMsg.setVisible(true);
            errorMsg.setFill(Color.RED);
            errorMsg.setText(e.getMessage());
        }
    }

        //không cần render vì tự động back lại list nếu ok
//    //reset input sau khi nhập xong
//    private void renderList() {
//        inputsName.setText("");
//        inputsName.setText("");
//        inputsDate.setText("");
//        inputsGender.setText("");
//        inputsAddress.setText("");
//    }

}
