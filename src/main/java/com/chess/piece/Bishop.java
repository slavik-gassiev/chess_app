package com.chess.piece;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.chess.Color;
import com.chess.Coordinates;
import com.chess.board.Board;
import com.chess.board.BoardUtils;


public class Bishop extends LongRangePiece implements IBishop{

    public Bishop(Color color, Coordinates coordinates) {
        super(color, coordinates);
        //TODO Auto-generated constructor stub
    }

    @Override
    protected Set<CoordinatesShift> getPieceMoves() {
        return getBishopMoves();
    }



    

}
