package io.educative.binary_tree;

import java.util.Objects;

class Coordinate {
    int r;
    int c;

    public Coordinate(int r, int c) {
        this.r = r;
        this.c = c;
    }

    /** ####### import when using hashset ####### **/
    @Override
    public int hashCode() {
        return Objects.hash(r, c);
    }

    @Override
    public boolean equals(Object c2) {
        if (c2 == null) {
            return false;
        }
        if (this == c2) {
            return true;
        }
        if (c2 instanceof Coordinate && ((Coordinate) c2).c == this.c && ((Coordinate) c2).r == this.r) {
            return true;
        }
        return false;
    }
    /** ####### import when using hashset ####### **/
}
