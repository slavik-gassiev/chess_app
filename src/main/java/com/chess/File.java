package com.chess;

public enum File {
    A, B, C, D, E, F, G, H;

    public static File fromChard(char c) {
    

        try {
            return File.valueOf(String.valueOf(c).toUpperCase());
        } catch (IllegalArgumentException e) {
            // TODO: handle exception
            return null;
        }
       
    }
}
