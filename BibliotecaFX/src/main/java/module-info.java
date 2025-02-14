module org.example.bibliotecafx {
    requires javafx.controls;
    requires javafx.fxml;
    exports org.example.bibliotecafx.util;
    exports org.example.bibliotecafx.interfaz;
    exports org.example.entities;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.naming;

    requires java.sql;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;

    opens org.example.bibliotecafx.interfaz to javafx.fxml;

    //Abre los modulos de hibbernate
    opens org.example.entities to org.hibernate.orm.core, javafx.fxml, javafx.base;

}