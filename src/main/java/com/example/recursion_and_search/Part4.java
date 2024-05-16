package com.example.recursion_and_search;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class Part4 extends Application {

    private ListView<Integer> arrayView;
    private int[] array;
    private int key;
    private int low;
    private int high;
    private int iterCount;
    private Timeline timeline;
    private int delay;

    private Label statusLabel;
    private Button startButton;
    private Button pauseButton;
    private Button resetButton;
    private Slider delaySlider;
    private TextField sizeInput;
    private TextField searchInput;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 400, 350);

        arrayView = new ListView<>();
        statusLabel = new Label();
        startButton = new Button("Start");
        startButton.setOnAction(event -> startVisualization());
        pauseButton = new Button("Pause");
        pauseButton.setOnAction(event -> pauseVisualization());
        resetButton = new Button("Reset");
        resetButton.setOnAction(event -> resetVisualization());

        HBox controlBox = new HBox(10, startButton, pauseButton, resetButton);
        controlBox.setPadding(new Insets(10));

        sizeInput = new TextField();
        sizeInput.setPromptText("Enter array size");
        searchInput = new TextField();
        searchInput.setPromptText("Enter search value");
        delaySlider = new Slider(0, 1000, 500);
        delaySlider.setShowTickLabels(true);
        delaySlider.setShowTickMarks(true);
        delaySlider.setMajorTickUnit(100);
        delaySlider.setMinorTickCount(5);
        delaySlider.setBlockIncrement(100);

        VBox inputBox = new VBox(10, sizeInput, searchInput, new Label("Delay:"), delaySlider, statusLabel);
        inputBox.setPadding(new Insets(10));

        root.setTop(controlBox);
        root.setLeft(inputBox);
        root.setCenter(arrayView);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Binary Search Visualizer");
        primaryStage.show();
    }

    // Method to start the visualization
    private void startVisualization() {
        try {
            // Parsing input values
            int size = Integer.parseInt(sizeInput.getText());
            array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = i + 1;
            }
            key = Integer.parseInt(searchInput.getText());
            low = 0;
            high = size - 1;
            iterCount = 0;
            delay = (int) delaySlider.getValue();

            // Populating the ListView with array values
            ObservableList<Integer> arrayValues = FXCollections.observableArrayList();
            for (int num : array) {
                arrayValues.add(num);
            }
            arrayView.setItems(arrayValues);

            // Timeline to animate the visualization
            timeline = new Timeline(new KeyFrame(Duration.millis(delay), event -> {
                // Binary search logic
                int mid = (low + high) / 2;
                iterCount++;
                statusLabel.setText("Iteration count: " + iterCount + ". Range: " + low + " - " + high + ". Mid: " + mid);
                highlightArrayPositions(low, mid, high);
                if (low <= high) {
                    if (array[mid] < key) {
                        low = mid + 1;
                    } else if (array[mid] > key) {
                        high = mid - 1;
                    } else {
                        statusLabel.setText("Value found at index: " + mid + " in " + iterCount + " iterations");
                        timeline.stop();
                    }
                } else {
                    statusLabel.setText("Value not found" + " in " + iterCount + " iterations");
                    timeline.stop();
                }
            }));
            timeline.setCycleCount(Timeline.INDEFINITE);
            timeline.play();
        } catch (NumberFormatException e) {
            statusLabel.setText("Invalid input. Please enter valid integers.");
        }
    }


    private void pauseVisualization() {
        if (timeline != null) {
            timeline.pause();
        }
    }

    private void resetVisualization() {
        if (timeline != null) {
            timeline.stop();
        }
        statusLabel.setText("");
        arrayView.getItems().clear();
    }

    private void highlightArrayPositions(int low, int mid, int high) {
        arrayView.getSelectionModel().clearSelection();
        arrayView.getSelectionModel().selectRange(low, high + 1);
    }
}
