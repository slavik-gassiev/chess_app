package com.chess;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
    //    Board board = new Board();
    //    board.setupDefaulPiecesPositions();

    Board board = ((new BoardFactory()).fromFEN(
        "3k4/6r1/8/1P2Q3/2B5/6P1/2R1r3/3K4"
        ));

    //    BoardConsoleRenderer render = new BoardConsoleRenderer();
    //    render.render(board);

    //    Piece piece = board.getPiece(new Coordinates(File.B, 1));
    //    Set<Coordinates> availableMoveSquare = piece.getAvailableMoveSquares(board);
    //    int x = 3;

        Game game = new Game(board);
        game.gameLoop();
       
    }
}
