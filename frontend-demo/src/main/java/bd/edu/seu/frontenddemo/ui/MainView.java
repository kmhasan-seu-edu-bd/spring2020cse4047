package bd.edu.seu.frontenddemo.ui;

import bd.edu.seu.frontenddemo.model.Student;
import bd.edu.seu.frontenddemo.service.StudentService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import java.time.LocalDate;

@Route("")
public class MainView extends VerticalLayout {
    private StudentService studentService;

    public MainView(StudentService studentService) {
        super();
        this.studentService = studentService;
        add(getStudentForm());
    }

    private FormLayout getStudentForm() {
        FormLayout studentForm = new FormLayout();

        TextField idField = new TextField("ID");
        TextField nameField = new TextField("Name");
        TextField cgpaField = new TextField("CGPA");
        DatePicker dateOfBirthPicker = new DatePicker("Date of Birth");
        Button saveButton = new Button("Save");
        saveButton.addClickListener(event -> {
            long id = Long.parseLong(idField.getValue());
            String name = nameField.getValue();
            double cgpa = Double.parseDouble(cgpaField.getValue());
            LocalDate dateOfBirth = dateOfBirthPicker.getValue();

            Student student = new Student(id, name, cgpa, dateOfBirth);

            saveStudent(student);
        });

        add(idField, nameField, cgpaField, dateOfBirthPicker, saveButton);

        return studentForm;
    }

    private void saveStudent(Student student) {
        try {
            Student savedStudent = studentService.saveStudent(student);
            Notification.show("Saved " + savedStudent.getName());
        } catch (Exception e) {
            Notification.show("Coudln't save " + student.getName());
        }
    }
}
