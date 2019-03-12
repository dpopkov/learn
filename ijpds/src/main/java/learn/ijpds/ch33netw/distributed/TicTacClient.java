package learn.ijpds.ch33netw.distributed;

import javafx.application.Application;
import javafx.application.Platform;
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

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;

public class TicTacClient extends Application implements TicTacToeConstants {
    private static final int SIZE = 3;
    private static final int PORT = 8000;

    /** Indicate whether the player has the turn. */
    private boolean myTurn = false;
    /** Indicate the token for the player. */
    private char myToken = ' ';
    /** Indicate the token for the other player. */
    private char otherToken = ' ';
    private final Cell[][] cells = new Cell[SIZE][SIZE];
    private final Label lblTitle = new Label();
    private final Label lblStatus = new Label();
    private int rowSelected;
    private int columnSelected;
    private Socket socket;
    private DataInputStream fromServer;
    private DataOutputStream toServer;
    private boolean continueToPlay = true;
    private volatile boolean waiting = true;
    private String host = "localhost";
    // TODO: get non-default host from command line argument

    @Override
    public void start(Stage primaryStage) {
        initGUI(primaryStage);
        connectToServer();
    }

    @Override
    public void stop() throws Exception {
        if (socket != null) {
            socket.close();
        }
    }

    private void initGUI(Stage stage) {
        GridPane pane = new GridPane();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                pane.add(cells[i][j] = new Cell(i, j), j, i);
            }
        }
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(lblTitle);
        borderPane.setCenter(pane);
        borderPane.setBottom(lblStatus);
        stage.setTitle("TicTacToeClient");
        stage.setScene(new Scene(borderPane, 320, 350));
        stage.show();
    }

    private void connectToServer() {
        try {
            socket = new Socket(host, PORT);
            fromServer = new DataInputStream(socket.getInputStream());
            toServer = new DataOutputStream(socket.getOutputStream());
        } catch (ConnectException ce) {
            System.err.println("Cannot connect to server. Check that the server is running.");
            System.exit(-1);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-2);
        }
        new Thread(() -> {
            try {
                int player = fromServer.readInt();
                if (player == PLAYER1) {
                    myToken = 'X';
                    otherToken = 'O';
                    setTitleStatusText("Player 1 with token 'X'", "Waiting for player 2 to join");
                    waitForStart();
                    setStatusText("Player 2 has joined. I start first");
                    myTurn = true;
                } else if (player == PLAYER2) {
                    myToken = 'O';
                    otherToken = 'X';
                    setTitleStatusText("Player 2 with token 'O'", "Waiting for player 1 to move");
                }
                while (continueToPlay) {
                    if (player == PLAYER1) {
                        waitForPlayerAction();
                        sendMove();
                        receiveInfoFromServer();
                    } else if (player == PLAYER2) {
                        receiveInfoFromServer();
                        waitForPlayerAction();
                        sendMove();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void waitForStart() throws IOException {
        System.out.println("waitForStart...");
        fromServer.readInt();   // receive signal to start
    }

    private void waitForPlayerAction() throws InterruptedException {
        System.out.println("waitForPlayerAction...");
        while (waiting) {
            Thread.sleep(100);
        }
    }

    private void sendMove() throws IOException {
        System.out.println("sendMove:");
        System.out.println("rowSelected = " + rowSelected);
        System.out.println("columnSelected = " + columnSelected);
        toServer.writeInt(rowSelected);
        toServer.writeInt(columnSelected);
    }

    private void receiveInfoFromServer() throws IOException {
        int status = fromServer.readInt();
        System.out.println("status = " + status);
        if (status == PLAYER1_WON) {
            continueToPlay = false;
            if (myToken == 'X') {
                setStatusText("I won! (X)");
            } else if (myToken == 'O') {
                setStatusText("Player 1 (X) has won!");
                receiveMove();
            }
        } else if (status == PLAYER2_WON) {
            continueToPlay = false;
            if (myToken == 'O') {
                setStatusText("I won! (O)");
            } else if (myToken == 'X') {
                setStatusText("Player 2 (O) has won!");
                receiveMove();
            }
        } else if (status == DRAW) {
            continueToPlay = false;
            setStatusText("Game is over, no winner");
            if (myToken == 'O') {
                receiveMove();
            }
        } else if (status == CONTINUE) {
            receiveMove();
            setStatusText("My turn");
            myTurn = true;
            waiting = true;
        } else {
            throw new IllegalStateException("Illegal status: " + status);
        }
    }

    private void receiveMove() throws IOException {
        int row = fromServer.readInt();
        int column = fromServer.readInt();
        System.out.println("Received a move:");
        System.out.println("row = " + row);
        System.out.println("column = " + column);
        Platform.runLater(() -> cells[row][column].setToken(otherToken));
    }

    private void setStatusText(String status) {
        Platform.runLater(() -> lblStatus.setText(status));
    }

    private void setTitleStatusText(String title, String status) {
        Platform.runLater(() -> {
            lblTitle.setText(title);
            lblStatus.setText(status);
        });
    }

    public class Cell extends Pane {
        /** Padding. */
        private static final int P = 10;

        private int row;
        private int column;
        /** Token used for this cell. */
        private char token = ' ';

        public Cell(int row, int column) {
            this.row = row;
            this.column = column;
            setStyle("-fx-border-color: black");
            setPrefSize(2000, 2000);
            setOnMouseClicked(e -> handleMouseClick());
        }

        public void setToken(char c) {
            token = c;
            repaint();
        }

        protected void repaint() {
            if (token == 'X') {
                createLines();
            } else if (token == 'O') {
                createEllipse();
            }
        }

        private void handleMouseClick() {
            if (token == ' ' && myTurn) {
                setToken(TicTacClient.this.myToken);
                TicTacClient.this.myTurn = false;
                TicTacClient.this.rowSelected = row;
                TicTacClient.this.columnSelected = column;
                TicTacClient.this.lblStatus.setText("Waiting for the other player to move");
                TicTacClient.this.waiting = false;
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
