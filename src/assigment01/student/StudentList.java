package assigment01.student;

import assigment01.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class StudentList implements Initializable {
    public TableView<Student> tbView;
    public TableColumn<Student, String> cMaSt, cNameSt, cDateSt, cAddressSt;
    public TableColumn<Student, Integer> cGenderSt;
    public TableColumn<Student, Button> cEditSt;
    public TableColumn<Student, Button> cDelSt;
    public TextField txtSearchSt;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cMaSt.setCellValueFactory(new PropertyValueFactory<Student, String>("maSV"));
        cNameSt.setCellValueFactory(new PropertyValueFactory<Student, String>("hoTen"));
        cDateSt.setCellValueFactory(new PropertyValueFactory<Student, String>("ngaySinh"));
        cAddressSt.setCellValueFactory(new PropertyValueFactory<Student, String>("diaChi"));
        cGenderSt.setCellValueFactory(new PropertyValueFactory<Student, Integer>("gioiTinh"));
        cEditSt.setCellValueFactory(new PropertyValueFactory<Student, Button>("editSt"));
        cDelSt.setCellValueFactory(new PropertyValueFactory<Student, Button>("deleteSt"));

        tbView.setItems(Main.studentList);
    }

    public void searchSt(){
        String s = txtSearchSt.getText();
        List<Student> listSt = Main.studentList.stream()
                .filter(student -> student.getHoTen().contains(s))
                .collect(Collectors.toList());

        ObservableList result_St = FXCollections.observableArrayList();
        result_St.add(listSt);
        tbView.setItems(result_St);
    }
}
