package com.chess;

import com.chess.piece.Pawn;

public class BoardFactory {

    private PieceFactory pieceFactory = new PieceFactory();

    public Board fromFEN(String fen) {

        // rnbqkbnr/pp1ppppp/8/2p5/4P3/5N2/PPPP1PPP/RNBQKB1R b KQkq - 1 2

        Board board = new Board();

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
    
}
