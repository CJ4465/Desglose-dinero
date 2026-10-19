module com.mycompany.gastos_semana {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.gastos_semana to javafx.fxml;
    exports com.mycompany.gastos_semana;
}
