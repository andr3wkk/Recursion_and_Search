module com.example.recursion_and_search {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.recursion_and_search to javafx.fxml;
    exports com.example.recursion_and_search;
}