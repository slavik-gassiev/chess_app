package com.chess.piece;

import java.util.HashSet;
import java.util.Set;

import com.chess.Color;
import com.chess.Coordinates;
import com.chess.board.Board;

public class King extends Piece{

    public King(Color color, Coordinates coordinates) {
        super(color, coordinates);
        //TODO Auto-generated constructor stub
    }

    @Override
    protected Set<CoordinatesShift> getPieceMoves() {
        Set<CoordinatesShift> result = new HashSet<>();

        for (int fileShift = -1; fileShift <= 1; fileShift++) {
            for (int rankSift = -1; rankSift <= 1; rankSift++) {
                if ((fileShift == 0) && (rankSift == 0)) continue;

                result.add(new CoordinatesShift(fileShift, rankSift));
            }
        }

        return result;
    }

    @Override
    protected boolean isSquareAvailableForMove(Coordinates coordinates, Board board) {
        // TODO Auto-generated method stub
        boolean result =  super.isSquareAvailableForMove(coordinates, board);

        if(result) {
            return !board.isSquareAttackedByColor(coordinates, color.opposite());
        }


        return false;
    }

    

}
