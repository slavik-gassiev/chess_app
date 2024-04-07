package com.chess;

import java.util.Scanner;
import java.util.Set;

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
}
