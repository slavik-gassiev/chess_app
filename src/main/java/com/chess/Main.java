package com.chess;

import java.util.Set;

import com.chess.board.Board;
import com.chess.board.BoardFactory;

public class Main {
    public static void main(String[] args) {
    //    Board board = new Board();
    //    board.setupDefaulPiecesPositions();

    Board board = ((new BoardFactory()).fromFEN(
        // "3k4/6r1/8/1P2Q3/2B5/6P1/2R1r3/3K4"
        // "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1"
        "8/8/8/8/6p1/3k1pP1/3p1P2/3K3N w - - 0 1"
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
