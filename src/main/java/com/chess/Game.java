package com.chess;

import java.util.Set;

import com.chess.piece.Piece;

public class Game {

    private final Board board;
    private BoardConsoleRenderer renderer = new BoardConsoleRenderer();
   

    public Game(Board board) {
        this.board = board;
    }


    public void gameLoop() {
        boolean isWhiteToMove = true;

        while(true) {
            renderer.render(board);

            if(isWhiteToMove) {
                System.out.println("White to move");
            } else {
                System.out.println("Black to move");
            }

            // input
            Coordinates sourceCoordinates = InputCoordinates.inputpPieceCoordinatesForColor(
                isWhiteToMove ? Color.WHITE : Color.BLACK, board
                );

            Piece piece = board.getPiece(sourceCoordinates);
            Set<Coordinates>  availableMoveSquare = piece.getAvailableMoveSquares(board);


            renderer.render(board, piece);
            Coordinates targetCoordinates = InputCoordinates.inputAvailableSquare(availableMoveSquare);
            

            // make move
            board.movePiece(sourceCoordinates, targetCoordinates);

            // pass move

            isWhiteToMove =! isWhiteToMove;
        }
    }
}
