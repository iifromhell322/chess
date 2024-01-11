package com.damir;
// в данном enum мы пишем все возможные цвета (понадобится для расстановки фигур и закрашивания поля)
public enum Color {
    WHITE,
    BLACK;

    public Color opposite() {
        return this == WHITE ? BLACK : WHITE;
    }
}

