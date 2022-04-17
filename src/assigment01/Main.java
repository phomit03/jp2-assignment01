package assigment01;

import assigment01.student.Student;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main extends Application {
    public static ObservableList<Student> studentList = FXCollections.observableArrayList();

    public static Stage rootStage;
    public final static String connectionString = "jdbc:mysql://localhost:3306/quanlythuvien";
    public final static String user = "root";
    public final static String password = "";

    //methods gọi database
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
        primaryStage.initStyle(StageStyle.UNDECORATED); //không close window được
        primaryStage.setTitle("Quản Lý Thư Viện");
        primaryStage.setScene(new Scene(root, 900, 650));
        primaryStage.show();
    }

    public static void main(String[] args) {
        //kết nối dữ liệu database vào tableview
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(connectionString, user, password);
            Statement stt = conn.createStatement();

            //truy van sql
            String txt_sql = "SELECT * FROM sinhvien";
            ResultSet rs = stt.executeQuery(txt_sql);

            while (rs.next()) {
                studentList.add(new Student(rs.getString("maSV"), rs.getString("hoTen"), rs.getString("ngaySinh"), rs.getString("diaChi"), rs.getInt("gioiTinh")));
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        launch(args);
    }

}
