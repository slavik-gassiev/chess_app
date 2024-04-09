package com.chess;

import java.util.Scanner;
import java.util.Set;

import com.chess.board.Board;
import com.chess.board.BoardFactory;
import com.chess.board.Move;
import com.chess.piece.King;
import com.chess.piece.Piece;

public class InputCoordinates {

    public static Scanner scanner = new Scanner(System.in);

    public static Coordinates input() {
        while(true) {
            System.out.println("Please enter coordinates (ex. a1)");

            String line = scanner.nextLine();

            if(line.length() != 2) {
                System.out.println("Invaled format");
                continue;
            }

            char fileChar = line.charAt(0);
            char rankChar = line.charAt(1);

            if(!Character.isLetter(fileChar)) {
                System.out.println("Invaled format");
                continue;
            }

            if(!Character.isDigit(rankChar)) {
                System.out.println("Invaled format");
                continue;
            }

            int rank = Character.getNumericValue(rankChar);
            if(rank < 1 || rank > 8) {
                System.out.println("Invaled format");
                continue;
            }

            File file = File.fromChard(fileChar);
            if(file == null) {
                System.out.println("Invaled format");
                continue;
            }

            return new Coordinates(file, rank);
        }



    }

    public static Coordinates inputpPieceCoordinatesForColor(Color color, Board board) {
        while(true) {
            System.out.println("Enter coordinates for piece to move");
            Coordinates coordinates = input();

            if(board.isSquareEmpty(coordinates)){
                System.out.println("Empty square");
                continue;
            }

            Piece piece = board.getPiece(coordinates);
            if(piece.color != color) {
                System.out.println("Wrong color");
                continue;
            }

            Set<Coordinates> availableMoveSquare = piece.getAvailableMoveSquares(board);
            if(availableMoveSquare.size() == 0) {
                System.out.println("Bloced piece");
                continue;
            }

            return coordinates;
        }
    }

    public static Coordinates inputAvailableSquare(Set<Coordinates> coordinates) {
        while(true) {
            System.out.println("Enter your move for selected piece");
            Coordinates input = input();

            if(!coordinates.contains(input)) {
                System.out.println("Non-available square");
                continue;
            }

            return input;
        }
    }

    public static Move inputMove(Board board, Color color, BoardConsoleRenderer renderer) {
        
            while(true) {
            Coordinates sourceCoordinates = InputCoordinates.inputpPieceCoordinatesForColor(color, board);

            Piece piece = board.getPiece(sourceCoordinates);
            Set<Coordinates>  availableMoveSquare = piece.getAvailableMoveSquares(board);


            renderer.render(board, piece);
            Coordinates targetCoordinates = InputCoordinates.inputAvailableSquare(availableMoveSquare);

            Move move = new Move(sourceCoordinates, targetCoordinates);

            if(validateIfKingInCheckAfterMove(board, color, move)) {
                System.out.println("Your king is under attack!");
                continue;

            }

            return move;
        }
            
    }

    private static boolean validateIfKingInCheckAfterMove(Board board, Color color, Move move) {
        Board copy = new BoardFactory().copy(board);
        copy.makeMove(move);
        Piece king = copy.getPiecesByColor(color).stream().filter(piece -> piece instanceof King).findFirst().get();
        return copy.isSquareAttackedByColor(king.coordinates, color.opposite());
    }
}
