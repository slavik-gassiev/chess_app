package com.chess.piece;

import java.util.List;

import com.chess.Color;
import com.chess.Coordinates;
import com.chess.board.Board;
import com.chess.board.BoardUtils;

public abstract class LongRangePiece extends Piece{

    public LongRangePiece(Color color, Coordinates coordinates) {
        super(color, coordinates);
        //TODO Auto-generated constructor stub
    }


    @Override
    protected boolean isSquareAvailableForMove(Coordinates coordinates, Board board) {
        boolean result = super.isSquareAvailableForMove(coordinates, board);

        if (result) {
            return isSquareAvailableForAttack(coordinates, board);
        } else {
            return false;
        }
    }


    @Override
    protected boolean isSquareAvailableForAttack(Coordinates coordinates, Board board) {
        List<Coordinates> coordinatesBetween;
        if (this.coordinates.file == coordinates.file) {
            coordinatesBetween = BoardUtils.getVerticalCoordinatesBetween(this.coordinates, coordinates);
        } else if (this.coordinates.rank.equals(coordinates.rank)) {
            coordinatesBetween = BoardUtils.getHorizontalCoordinatesBetween(this.coordinates, coordinates);
        } else {
            coordinatesBetween = BoardUtils.getDiagonalCoordinatesBetween(this.coordinates, coordinates);
        }

        for (Coordinates c : coordinatesBetween) {
            if (!board.isSquareEmpty(c)) {
                return false;
            }
        }

        return true;
    }

    
}
