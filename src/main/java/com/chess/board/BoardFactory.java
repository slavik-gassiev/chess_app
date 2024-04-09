package com.chess.board;

import com.chess.Coordinates;
import com.chess.File;
import com.chess.PieceFactory;
import com.chess.piece.Pawn;

public class BoardFactory {

    private PieceFactory pieceFactory = new PieceFactory();

    public Board fromFEN(String fen) {

        Board board = new Board(fen);

        String[] parts = fen.split(" ");
        String piecePositions = parts[0];

        String[] fenRows = piecePositions.split("/");

        for(int i = 0; i < fenRows.length; i++) {
            String fenRow = fenRows[i];
            int rank = 8 - i;

            int fileIndex = 0;
            for(int j = 0; j < fenRow.length(); j++){
                char fenChar = fenRow.charAt(j);

                if(Character.isDigit(fenChar)){
                    fileIndex += Character.getNumericValue(fenChar);
                } else{
                    File file = File.values()[fileIndex];
                    Coordinates coordinates = new Coordinates(file, rank);

                    board.setPiece(coordinates, pieceFactory.fromFenChar(fenChar, coordinates));

                    fileIndex++;
                }
            }
        }

        return board;
    }

    public Board copy(Board source) {
        Board clone = fromFEN(source.startingFen);

        for (Move move : source.moves) {
            clone.makeMove(move);
        }

        return clone;
    }
    
}
