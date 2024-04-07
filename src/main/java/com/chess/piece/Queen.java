package com.chess.piece;

import java.util.Set;

import com.chess.Color;
import com.chess.Coordinates;
import com.chess.CoordinatesShift;

public class Queen extends Piece{

    public Queen(Color color, Coordinates coordinates) {
        super(color, coordinates);
        //TODO Auto-generated constructor stub
    }

    @Override
    protected Set<CoordinatesShift> getPieceMoves() {
        // TODO Auto-generated method stub
        return null;
    }

}
