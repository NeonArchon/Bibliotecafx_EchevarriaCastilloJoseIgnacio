module org.example.bibliotecafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;


    opens org.example.bibliotecafx to javafx.fxml;
    exports org.example.bibliotecafx;
}