package com.damir;
import com.damir.board.Board;
public abstract class GameStateChecker {
    public abstract GameState check(Board board, Color color);
}
