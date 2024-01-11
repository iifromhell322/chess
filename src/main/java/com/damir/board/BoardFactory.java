package com.damir.board;
import com.damir.Coordinates;
import com.damir.File;
import com.damir.PieceFactory;
public class BoardFactory {

    private final PieceFactory pieceFactory = new PieceFactory();

    public Board fromFEN(String fen) {
        Board board = new Board(fen);

        String[] parts = fen.split(" ");
        String piecePositions = parts[0];

        String[] fenRows = piecePositions.split("/");

        for (int i = 0; i < fenRows.length; i++) {
            String row = fenRows[i];
            int rank = 8 - i;

            int fileIndex = 0;
            for (int j = 0; j < row.length(); j++) {
                char fenChar = row.charAt(j);

                if (Character.isDigit(fenChar)) {
                    fileIndex += Character.getNumericValue(fenChar);
                } else {
                    File file = File.values()[fileIndex];
                 Coordinates coordinates = new Coordinates(file, rank);  //создаем новый объекта типа Coordinates с использованием file и rank(параметры).

                    board.setPiece(coordinates, pieceFactory.fromFenChar(fenChar, coordinates));
                    fileIndex++;
                }
            }
        }

        return board;
    }

    public Board copy(Board source) { // объявляем  метод с возвращаемым типом Board и параметром source типа Board.
        Board clone = fromFEN(source.startingFen);

        for (Move move : source.moves) {
            clone.makeMove(move); //выполнение метода makeMove на объекте
        }

        return clone;
    }
}

