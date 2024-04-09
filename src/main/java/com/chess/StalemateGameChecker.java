package com.chess;

import java.util.List;
import java.util.Set;

import com.chess.board.Board;
import com.chess.piece.Piece;

public class StalemateGameChecker extends GameStateChecker{

    @Override
    public GameState check(Board board, Color color) {
     List<Piece> pieces = board.getPiecesByColor(color);

     for (Piece piece : pieces) {
        Set<Coordinates> availableMoveSquare = piece.getAvailableMoveSquares(board);

        if(availableMoveSquare.size() > 0) {
            return GameState.ONGOING;
        }
        
     }
        return GameState.STALEMATE;
    }
    

}
