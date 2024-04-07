package com.chess;

import java.util.Set;
import static java.util.Collections.emptySet;
import com.chess.piece.Piece;

public class BoardConsoleRenderer {


    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_WHITE_PIECE_COLOR = "\u001B[97m";
    public static final String ANSI_BLACK_PIECE_COLOR = "\u001B[30m";

    public static final String ANSI_WHITE_SQUARE_BACKGROUND = "\u001B[47m";

    public static final String ANSI_BLACK_SQUARE_BACKGROUND = "\u001B[0;100m";

    public static final String ANSI_HIGHLIGHTED_SQUARE_BACKGROUND = "\u001B[45m";



    public void render(Board board, Piece pieceToMove) {

        Set<Coordinates> availableMoveSquare = emptySet();
        if(pieceToMove != null){
            availableMoveSquare =  pieceToMove.getAvailableMoveSquares(board);
        }
       

        for(int rank = 8; rank >= 1; rank--) {
            String line = "";
            
            for(File file : File.values()){
                Coordinates coordinates = new Coordinates(file, rank);
                boolean isHighLight = availableMoveSquare.contains(coordinates);
                if(board.isSquareEmpty(coordinates)) {
                    line += getSpriteForEmptySquary(coordinates, isHighLight);
                    
                    
                } else {
                    line += getPieceSprite(board.getPiece(coordinates), isHighLight);
                    
                }
                
            }
            line += ANSI_RESET;
            System.out.println(line);
        }
        
    }

    public void render(Board board) {
        render(board, null);
    }


    private String colorizeSprite(String sprite, Color pieceColor, boolean isSquareDark, boolean isHighLighted) {

        String result = sprite;

        if(pieceColor == Color.WHITE) {
            result = ANSI_WHITE_PIECE_COLOR + result;
        } else if(pieceColor == Color.BLACK){
            result = ANSI_BLACK_PIECE_COLOR + result;
        }

        if(isHighLighted) {
            result = ANSI_HIGHLIGHTED_SQUARE_BACKGROUND + result;
        } else if(isSquareDark) {
            result = ANSI_BLACK_SQUARE_BACKGROUND + result;
        } else {
            result = ANSI_WHITE_SQUARE_BACKGROUND + result;
        }


        return result;
    }

    private String getSpriteForEmptySquary(Coordinates coordinates, boolean isHighLight) {
        return colorizeSprite("   ", Color.BLACK, Board.isSquareDark(coordinates), isHighLight);
    }
    
    private String getPieceSprite(Piece piece, boolean isHighLight) {
        return colorizeSprite(" " + selectUnicodeSpriteForPiece(piece) + " ", piece.color,
         Board.isSquareDark(piece.coordinates), isHighLight);
    }

    private String selectUnicodeSpriteForPiece(Piece piece) {
        switch(piece.getClass().getSimpleName()) {
            case "Pawn":
                return "P";

            case "Knight":
                return "N";

            case "Bishop":
                return "B";

            case "Rook":
                return "R";

            case "Queen":
                return "Q";

            case "King":
                return "K";
                
        }
        return "";
    }


}
