/* 16.13 */
package learn.ijpds.ch16fxui.tictactoe;

import javafx.application.Application;
import javafx.beans.binding.DoubleBinding;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class TicTacToe extends Application {
    private static final int SIZE = 3;

    /** Indicate which player has a turn, initially it is the X player. */
    private char whoseTurn = 'X';

    private final Cell[][] cells = new Cell[SIZE][SIZE];

    /** Status label. */
    private final Label lblStatus = new Label("X's turn to play");

    @Override
    public void start(Stage primaryStage) {
        GridPane pane = new GridPane();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                pane.add(cells[i][j] = new Cell(), j, i);
            }
        }
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(pane);
        borderPane.setBottom(lblStatus);

        Scene scene = new Scene(borderPane, 320, 300);
        primaryStage.setTitle("TicTacToe");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /** Determine if all cells are occupied. */
    public boolean isFull() {
        boolean full = true;
        for (int i = 0; full && i < SIZE; i++) {
            for (int j = 0; full && j < SIZE; j++) {
                if (cells[i][j].getToken() == ' ') {
                    full = false;
                }
            }
        }
        return full;
    }

    /** Determine if the player with the specified token wins. */
    @SuppressWarnings("RedundantIfStatement")
    public boolean isWon(char token) {
        for (int i = 0; i < SIZE; i++) {
            if (cells[i][0].getToken() == token
                    && cells[i][1].getToken() == token
                    && cells[i][2].getToken() == token) {
                return true;
            }
        }
        for (int j = 0; j < SIZE; j++) {
            if (cells[0][j].getToken() == token
                    && cells[1][j].getToken() == token
                    && cells[2][j].getToken() == token) {
                return true;
            }
        }
        if (cells[0][0].getToken() == token
                && cells[1][1].getToken() == token
                && cells[2][2].getToken() == token) {
            return true;
        }
        if (cells[0][2].getToken() == token
                && cells[1][1].getToken() == token
                && cells[2][0].getToken() == token) {
            return true;
        }
        return false;
    }

    private void updateStatus() {
        if (isWon(whoseTurn)) {
            whoseTurn = ' ';
            lblStatus.setText(whoseTurn + " won! The game is over");
        } else if (isFull()) {
            whoseTurn = ' ';
            lblStatus.setText("Draw! The game is over");
        } else {
            whoseTurn = (whoseTurn == 'X') ? 'O' : 'X';
            lblStatus.setText(whoseTurn + "'s turn");
        }
    }

    public class Cell extends Pane {
        /** Padding. */
        private static final int P = 10;

        /** Token used for this cell. */
        private char token = ' ';

        public Cell() {
            setStyle("-fx-border-color: black");
            setPrefSize(2000, 2000);
            setOnMouseClicked(e -> handleMouseClick());
        }

        public char getToken() {
            return token;
        }

        public void setToken(char c) {
            token = c;
            if (token == 'X') {
                createLines();
            } else if (token == 'O') {
                createEllipse();
            }
        }

        private void handleMouseClick() {
            if (token == ' ' && TicTacToe.this.whoseTurn != ' ') {
                setToken(TicTacToe.this.whoseTurn);
                TicTacToe.this.updateStatus();
            }
        }

        private void createLines() {
            DoubleBinding endX = widthProperty().subtract(P);
            DoubleBinding endY = heightProperty().subtract(P);

            Line line1 = new Line(P, P, getWidth() - P, getHeight() - P);
            line1.endXProperty().bind(endX);
            line1.endYProperty().bind(endY);
            Line line2 = new Line(P, getHeight() - P, getWidth() - P, P);
            line2.startYProperty().bind(endY);
            line2.endXProperty().bind(endX);

            this.getChildren().addAll(line1, line2);
        }

        private void createEllipse() {
            Ellipse ellipse = new Ellipse(getWidth() / 2, getHeight() / 2, getWidth() / 2 - P,
                    getHeight() / 2 - P);
            ellipse.centerXProperty().bind(widthProperty().divide(2));
            ellipse.centerYProperty().bind(heightProperty().divide(2));
            ellipse.radiusXProperty().bind(widthProperty().divide(2).subtract(P));
            ellipse.radiusYProperty().bind(heightProperty().divide(2).subtract(P));
            ellipse.setStroke(Color.BLACK);
            ellipse.setFill(Color.TRANSPARENT);
            this.getChildren().add(ellipse);
        }
    }
}
