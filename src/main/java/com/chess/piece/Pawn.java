package com.chess.piece;

import java.util.Set;

import com.chess.Color;
import com.chess.Coordinates;

public class Pawn extends Piece{

    public Pawn(Color color, Coordinates coordinates) {
        super(color, coordinates);
        //TODO Auto-generated constructor stub
    }

    @Override
    protected Set<CoordinatesShift> getPieceMoves() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPieceMoves'");
    }

}
