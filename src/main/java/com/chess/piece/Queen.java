package com.chess.piece;

import java.util.Set;

import com.chess.Color;
import com.chess.Coordinates;

public class Queen extends LongRangePiece implements IBishop, IRook{

    public Queen(Color color, Coordinates coordinates) {
        super(color, coordinates);
        //TODO Auto-generated constructor stub
    }

    @Override
    protected Set<CoordinatesShift> getPieceMoves() {
        Set<CoordinatesShift> moves = getBishopMoves();
        moves.addAll(getRooksMoves());

        return moves;
    }

}
