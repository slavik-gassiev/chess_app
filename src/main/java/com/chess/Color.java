package com.chess;


public enum Color {
    WHITE,
    BLACK;

    public Color opposite() {
        return this.WHITE == WHITE ? BLACK : WHITE;
    }
}
