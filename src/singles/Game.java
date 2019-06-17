package singles;

import java.util.ArrayList;

public class Game {

    Matrix map;
    Matrix tmp;
    Matrix last;
    public int db = 0;
    private State state;

    public State getState() {
        return state;
    }

    int array[][][] = {{{3, 2, 4, 5, 1}, {2, 1, 1, 3, 2}, {1, 1, 2, 4, 3}, {1, 3, 5, 3, 4}, {1, 5, 4, 1, 2}},
            {{2, 2, 3, 1, 2}, {4, 3, 3, 5, 2}, {1, 4, 5, 5, 1}, {2, 1, 2, 3, 5}, {1, 1, 2, 4, 5}},
            {{5, 1, 2, 4, 2}, {5, 5, 4, 4, 1}, {1, 5, 5, 2, 3}, {4, 3, 2, 5, 5}, {3, 1, 1, 5, 3}},
            {{2, 2, 5, 5, 1}, {5, 4, 2, 1, 3}, {4, 3, 3, 3, 2}, {3, 5, 3, 2, 3}, {2, 2, 4, 3, 5}},
            {{4, 1, 2, 2, 5}, {2, 3, 5, 5, 1}, {5, 4, 1, 1, 2}, {4, 5, 5, 1, 3}, {5, 5, 3, 5, 4}},
            {{3, 5, 2, 4, 1}, {5, 4, 1, 4, 4}, {4, 3, 4, 1, 1}, {4, 1, 2, 5, 2}, {3, 4, 5, 2, 4}},
            {{4, 1, 5, 5, 4}, {1, 2, 3, 4, 5}, {4, 2, 2, 5, 1}, {2, 4, 1, 1, 3}, {2, 3, 1, 4, 4}},
            {{2, 1, 5, 3, 5}, {5, 1, 2, 4, 2}, {1, 2, 3, 1, 4}, {3, 4, 5, 1, 2}, {4, 2, 1, 2, 2}},
            {{1, 1, 3, 4, 2}, {4, 3, 1, 2, 1}, {1, 2, 4, 3, 3}, {2, 4, 5, 3, 1}, {2, 1, 4, 5, 3}},
            {{3, 4, 1, 2, 3}, {1, 5, 2, 1, 3}, {4, 5, 3, 5, 4}, {5, 1, 2, 3, 4}, {2, 3, 5, 5, 2}},
            {{5, 3, 2, 5, 3}, {3, 1, 5, 3, 4}, {3, 2, 3, 4, 3}, {2, 4, 3, 1, 5}, {3, 5, 2, 3, 3}},
            {{4, 3, 4, 5, 5}, {4, 2, 3, 1, 2}, {5, 2, 3, 3, 2}, {1, 3, 5, 2, 3}, {3, 1, 2, 2, 5}},
            {{3, 3, 5, 4, 4}, {1, 2, 3, 4, 5}, {1, 1, 2, 2, 1}, {3, 5, 1, 5, 2}, {4, 5, 2, 2, 1}},
            {{2, 2, 4, 5, 2}, {4, 1, 2, 1, 5}, {2, 1, 1, 3, 4}, {2, 5, 1, 4, 1}, {5, 4, 1, 2, 1}},
            {{2, 5, 3, 3, 4}, {1, 4, 2, 3, 5}, {4, 2, 5, 4, 3}, {5, 1, 4, 2, 1}, {3, 5, 4, 4, 3}},
            {{4, 2, 1, 1, 3}, {2, 1, 3, 2, 5}, {1, 5, 2, 2, 4}, {2, 3, 5, 4, 1}, {5, 2, 3, 1, 5}},
            {{5, 2, 5, 4, 5}, {5, 4, 2, 5, 3}, {4, 1, 2, 3, 2}, {5, 3, 4, 3, 5}, {3, 5, 1, 2, 3}},
            {{5, 5, 2, 3, 5}, {3, 4, 2, 5, 1}, {5, 4, 1, 3, 4}, {5, 2, 3, 1, 4}, {2, 1, 1, 4, 3}},
            {{3, 3, 5, 3, 1}, {2, 1, 3, 4, 5}, {5, 3, 4, 3, 2}, {5, 2, 2, 5, 3}, {1, 5, 2, 4, 4}},
            {{4, 1, 4, 5, 3}, {4, 3, 5, 2, 2}, {3, 2, 1, 3, 1}, {3, 5, 2, 5, 1}, {1, 3, 3, 2, 5}},
            {{3, 2, 3, 4, 3}, {3, 4, 2, 3, 1}, {1, 3, 5, 5, 4}, {2, 3, 3, 1, 4}, {5, 1, 5, 3, 3}},
            {{2, 3, 4, 1, 2}, {5, 2, 3, 2, 4}, {3, 5, 4, 4, 2}, {5, 2, 5, 2, 1}, {1, 4, 3, 5, 3}},
            {{2, 2, 4, 5, 5}, {2, 1, 1, 5, 4}, {3, 4, 1, 2, 3}, {3, 5, 2, 1, 1}, {3, 3, 2, 1, 2}},
            {{2, 1, 5, 5, 3}, {4, 4, 1, 5, 2}, {5, 2, 3, 3, 3}, {3, 1, 2, 1, 4}, {3, 4, 3, 3, 5}},
            {{3, 3, 4, 5, 4}, {3, 2, 4, 1, 1}, {5, 5, 1, 4, 1}, {4, 5, 5, 2, 4}, {5, 4, 1, 3, 2}},
            {{5, 5, 5, 3, 4}, {2, 1, 3, 5, 4}, {4, 4, 2, 4, 3}, {4, 3, 5, 2, 4}, {3, 5, 1, 4, 5}},
            {{2, 3, 3, 1, 5}, {1, 2, 3, 3, 1}, {4, 5, 1, 4, 2}, {4, 1, 1, 5, 3}, {1, 3, 4, 3, 1}},
            {{4, 5, 5, 3, 2}, {1, 3, 5, 4, 2}, {2, 4, 2, 5, 5}, {5, 1, 5, 2, 4}, {4, 1, 1, 5, 5}},
            {{5, 5, 2, 1, 3}, {2, 1, 4, 3, 2}, {3, 5, 3, 4, 2}, {4, 3, 3, 1, 1}, {4, 3, 5, 2, 4}},
            {{2, 2, 5, 3, 5}, {3, 5, 4, 4, 2}, {2, 5, 3, 1, 1}, {4, 3, 2, 3, 1}, {5, 4, 4, 2, 3}},
            {{2, 5, 3, 4, 5}, {4, 5, 1, 3, 1}, {5, 3, 5, 4, 4}, {5, 2, 4, 1, 3}, {3, 2, 2, 3, 1}},
            {{4, 2, 3, 3, 4}, {4, 4, 3, 5, 2}, {2, 1, 1, 4, 4}, {3, 5, 5, 1, 4}, {1, 1, 4, 2, 1}},
            {{4, 5, 1, 3, 5}, {3, 5, 1, 1, 5}, {2, 3, 3, 5, 1}, {1, 3, 5, 3, 2}, {5, 2, 4, 2, 5}},
            {{1, 4, 2, 3, 4}, {5, 3, 1, 4, 3}, {2, 1, 2, 5, 3}, {2, 4, 5, 2, 5}, {4, 2, 5, 1, 5}},
            {{2, 2, 3, 3, 5}, {3, 5, 2, 1, 4}, {1, 3, 1, 2, 2}, {1, 4, 4, 2, 3}, {1, 2, 4, 2, 1}},
            {{3, 5, 5, 1, 1}, {1, 2, 3, 5, 3}, {4, 5, 2, 3, 1}, {5, 3, 3, 5, 4}, {4, 3, 1, 4, 3}},
            {{1, 4, 1, 5, 3}, {3, 2, 1, 1, 2}, {1, 1, 3, 4, 2}, {5, 1, 2, 5, 4}, {3, 3, 2, 2, 1}},
            {{2, 4, 4, 3, 5}, {3, 5, 1, 2, 5}, {1, 4, 2, 1, 2}, {4, 3, 2, 5, 2}, {1, 5, 5, 4, 3}},
            {{2, 4, 4, 3, 5}, {3, 5, 1, 2, 5}, {1, 4, 2, 1, 2}, {4, 3, 2, 5, 2}, {1, 5, 5, 4, 3}},
            {{3, 4, 5, 4, 5}, {5, 1, 4, 3, 3}, {1, 1, 2, 5, 4}, {2, 4, 4, 3, 5}, {4, 1, 3, 1, 4}},
            {{4, 4, 3, 5, 2}, {4, 2, 5, 2, 4}, {5, 2, 3, 3, 1}, {3, 3, 1, 4, 1}, {3, 5, 1, 1, 4}},
            {{1, 3, 1, 5, 3}, {1, 2, 5, 3, 1}, {3, 5, 1, 2, 5}, {2, 3, 3, 2, 5}, {3, 1, 2, 4, 3}},
            {{1, 5, 5, 3, 2}, {2, 4, 4, 5, 3}, {5, 3, 4, 3, 1}, {4, 2, 3, 1, 2}, {4, 1, 2, 2, 5}}};

    public Game(int cols, int rows) {
        Ranges.setSize(new Coord(cols, rows));
    }

    public Box getBox(Coord coord) {
        return map.get(coord);
    }

    public void start() {
        state = State.NEW_GAME;
        map = new Matrix(array[db]);
        tmp = new Matrix(array[db]);
        last = new Matrix(array[db]);
        db++;
        if (db == array.length)
            db = 0;

    }

    public void startlast() {
        state = State.NEW_GAME;
        db--;
        map = new Matrix(array[db]);
        tmp = new Matrix(array[db]);
        last = new Matrix(array[db]);
        db++;
        if (db == array.length)
            db = 0;

    }


    public void findAllPosibleCircle() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = -4; k < 5; k++) {
                    if (k == 0)
                        continue;

                    if (Ranges.inRange(new Coord(i, j + k)))
                        if (isNum(new Coord(i, j))) {
                            if (isCircle(new Coord(i, j + k)))
                                if (map.get(new Coord(i, j)) == circleToNum(new Coord(i, j + k)))
                                    break;
                            if (isNum(new Coord(i, j + k)))
                                if (map.get(new Coord(i, j)) == map.get(new Coord(i, j + k)))
                                    break;
                        }

                    if (Ranges.inRange(new Coord(i + k, j))) {
                        if (isNum(new Coord(i, j)))
                            if (isCircle(new Coord(i + k, j)))
                                if (map.get(new Coord(i, j)) == circleToNum(new Coord(i + k, j)))
                                    break;
                        if (isNum(new Coord(i + k, j)))
                            if (map.get(new Coord(i, j)) == map.get(new Coord(i + k, j)))
                                break;
                    }


                    if (k == 4)
                        if (isNum(new Coord(i, j)))
                            map.set(new Coord(i, j), goodNumber(new Coord(i, j)));
                }
            }

        }
    }

    public void solve_singlesep() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (Ranges.inRange(new Coord(i, j - 1)) && Ranges.inRange(new Coord(i, j + 1)))
                    if (isNum(new Coord(i, j - 1)) && isNum(new Coord(i, j + 1)) && isNum(new Coord(i, j)))
                        if (map.get(new Coord(i, j - 1)) == map.get(new Coord(i, j + 1)) && map.get(new Coord(i, j - 1)) != map.get(new Coord(i, j)))
                            map.set(new Coord(i, j), goodNumber(new Coord(i, j)));

                if (Ranges.inRange(new Coord(i + 1, j)) && Ranges.inRange(new Coord(i - 1, j)))
                    if (isNum(new Coord(i - 1, j)) && isNum(new Coord(i + 1, j)) && isNum(new Coord(i, j)))
                        if (map.get(new Coord(i - 1, j)) == map.get(new Coord(i + 1, j)) && map.get(new Coord(i - 1, j)) != map.get(new Coord(i, j)))
                            map.set(new Coord(i, j), goodNumber(new Coord(i, j)));
            }
        }
    }

    public void solve_doubles() {
        for (int i = 0; i < 5; i++) {
            if (isNum(new Coord(i, 0)) && isNum(new Coord(i, 1)) && isNum(new Coord(i, 3)))
                if (map.get(new Coord(i, 0)) == map.get(new Coord(i, 1)) && map.get(new Coord(i, 0)) == map.get(new Coord(i, 3)))
                    map.set(new Coord(i, 3), Box.BLACK);

            if (isNum(new Coord(i, 0)) && isNum(new Coord(i, 1)) && isNum(new Coord(i, 4)))
                if (map.get(new Coord(i, 0)) == map.get(new Coord(i, 1)) && map.get(new Coord(i, 0)) == map.get(new Coord(i, 4)))
                    map.set(new Coord(i, 4), Box.BLACK);

            if (isNum(new Coord(i, 1)) && isNum(new Coord(i, 2)) && isNum(new Coord(i, 4)))
                if (map.get(new Coord(i, 1)) == map.get(new Coord(i, 2)) && map.get(new Coord(i, 1)) == map.get(new Coord(i, 4)))
                    map.set(new Coord(i, 4), Box.BLACK);

            if (isNum(new Coord(i, 2)) && isNum(new Coord(i, 3)) && isNum(new Coord(i, 0)))
                if (map.get(new Coord(i, 2)) == map.get(new Coord(i, 3)) && map.get(new Coord(i, 2)) == map.get(new Coord(i, 0)))
                    map.set(new Coord(i, 0), Box.BLACK);

            if (isNum(new Coord(i, 3)) && isNum(new Coord(i, 4)) && isNum(new Coord(i, 0)))
                if (map.get(new Coord(i, 3)) == map.get(new Coord(i, 4)) && map.get(new Coord(i, 3)) == map.get(new Coord(i, 0)))
                    map.set(new Coord(i, 0), Box.BLACK);

            if (isNum(new Coord(i, 3)) && isNum(new Coord(i, 4)) && isNum(new Coord(i, 1)))
                if (map.get(new Coord(i, 3)) == map.get(new Coord(i, 4)) && map.get(new Coord(i, 3)) == map.get(new Coord(i, 1)))
                    map.set(new Coord(i, 1), Box.BLACK);
        }

        for (int i = 0; i < 5; i++) {
            if (isNum(new Coord(0, i)) && isNum(new Coord(1, i)) && isNum(new Coord(3, i)))
                if (map.get(new Coord(0, i)) == map.get(new Coord(1, i)) && map.get(new Coord(0, i)) == map.get(new Coord(3, i)))
                    map.set(new Coord(3, i), Box.BLACK);

            if (isNum(new Coord(0, i)) && isNum(new Coord(1, i)) && isNum(new Coord(4, i)))
                if (map.get(new Coord(0, i)) == map.get(new Coord(1, i)) && map.get(new Coord(0, i)) == map.get(new Coord(4, i)))
                    map.set(new Coord(4, i), Box.BLACK);

            if (isNum(new Coord(1, i)) && isNum(new Coord(2, i)) && isNum(new Coord(4, i)))
                if (map.get(new Coord(1, i)) == map.get(new Coord(3, i)) && map.get(new Coord(1, i)) == map.get(new Coord(4, i)))
                    map.set(new Coord(4, i), Box.BLACK);

            if (isNum(new Coord(2, i)) && isNum(new Coord(3, i)) && isNum(new Coord(0, i)))
                if (map.get(new Coord(2, i)) == map.get(new Coord(3, i)) && map.get(new Coord(2, i)) == map.get(new Coord(0, i)))
                    map.set(new Coord(0, i), Box.BLACK);

            if (isNum(new Coord(3, i)) && isNum(new Coord(4, i)) && isNum(new Coord(0, i)))
                if (map.get(new Coord(3, i)) == map.get(new Coord(4, i)) && map.get(new Coord(3, i)) == map.get(new Coord(0, i)))
                    map.set(new Coord(0, i), Box.BLACK);

            if (isNum(new Coord(3, i)) && isNum(new Coord(4, i)) && isNum(new Coord(1, i)))
                if (map.get(new Coord(3, i)) == map.get(new Coord(4, i)) && map.get(new Coord(3, i)) == map.get(new Coord(1, i)))
                    map.set(new Coord(1, i), Box.BLACK);
        }
    }

    public void solve_triangle() {
        for (int i = 0; i < 5; i++) {
            if (Ranges.inRange(new Coord(0, i + 2)) && Ranges.inRange(new Coord(1, i + 1))) {
                if (map.get(new Coord(0, i)) == Box.BLACK && map.get(new Coord(0, i + 2)) == Box.BLACK)
                    if (isNum(new Coord(1, i + 1)))
                        map.set(new Coord(1, i + 1), goodNumber(new Coord(1, i + 1)));

                if (map.get(new Coord(0, i)) == Box.BLACK && map.get(new Coord(1, i + 1)) == Box.BLACK)
                    if (isNum(new Coord(0, i + 2)))
                        map.set(new Coord(0, i + 2), goodNumber(new Coord(0, i + 2)));

                if (map.get(new Coord(1, i + 1)) == Box.BLACK && map.get(new Coord(0, i + 2)) == Box.BLACK)
                    if (isNum(new Coord(0, i)))
                        map.set(new Coord(0, i), goodNumber(new Coord(0, i)));
            }


            if (Ranges.inRange(new Coord(4, i + 2)) && Ranges.inRange(new Coord(3, i + 1))) {
                if (map.get(new Coord(4, i)) == Box.BLACK && map.get(new Coord(4, i + 2)) == Box.BLACK)
                    if (isNum(new Coord(3, i + 1)))
                        map.set(new Coord(3, i + 1), goodNumber(new Coord(3, i + 1)));

                if (map.get(new Coord(4, i)) == Box.BLACK && map.get(new Coord(3, i + 1)) == Box.BLACK)
                    if (isNum(new Coord(4, i + 2)))
                        map.set(new Coord(4, i + 2), goodNumber(new Coord(4, i + 2)));

                if (map.get(new Coord(3, i + 1)) == Box.BLACK && map.get(new Coord(4, i + 2)) == Box.BLACK)
                    if (isNum(new Coord(4, i)))
                        map.set(new Coord(4, i), goodNumber(new Coord(4, i)));
            }

        }
        for (int i = 0; i < 5; i++) {
            if (Ranges.inRange(new Coord(i + 2, 0)) && Ranges.inRange(new Coord(i + 1, 1))) {
                if (map.get(new Coord(i, 0)) == Box.BLACK && map.get(new Coord(i + 2, 0)) == Box.BLACK)
                    if (isNum(new Coord(i + 1, 1)))
                        map.set(new Coord(i + 1, 1), goodNumber(new Coord(i + 1, 1)));

                if (map.get(new Coord(i, 0)) == Box.BLACK && map.get(new Coord(i + 1, 1)) == Box.BLACK)
                    if (isNum(new Coord(i + 2, 0)))
                        map.set(new Coord(i + 2, 0), goodNumber(new Coord(i + 2, 0)));

                if (map.get(new Coord(i + 2, 0)) == Box.BLACK && map.get(new Coord(i + 1, 1)) == Box.BLACK)
                    if (isNum(new Coord(i, 0)))
                        map.set(new Coord(i, 0), goodNumber(new Coord(i, 0)));
            }

            if (Ranges.inRange(new Coord(i + 2, 4)) && Ranges.inRange(new Coord(i + 1, 3))) {
                if (map.get(new Coord(i, 4)) == Box.BLACK && map.get(new Coord(i + 2, 4)) == Box.BLACK)
                    if (isNum(new Coord(i + 1, 3)))
                        map.set(new Coord(i + 1, 3), goodNumber(new Coord(i + 1, 3)));

                if (map.get(new Coord(i, 4)) == Box.BLACK && map.get(new Coord(i + 1, 3)) == Box.BLACK)
                    if (isNum(new Coord(i + 2, 4)))
                        map.set(new Coord(i + 2, 4), goodNumber(new Coord(i + 2, 4)));

                if (map.get(new Coord(i + 2, 4)) == Box.BLACK && map.get(new Coord(i + 1, 3)) == Box.BLACK)
                    if (isNum(new Coord(i, 4)))
                        map.set(new Coord(i, 4), goodNumber(new Coord(i, 4)));
            }
        }
    }

    public void solver_op_circle() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (isCircle(new Coord(i, j))) {
                    for (int k = -4; k < 5; k++) {
                        if (k == 0)
                            continue;
                        if (Ranges.inRange(new Coord(i + k, j)))
                            if (isNum(new Coord(i + k, j)) && circleToNum(new Coord(i, j)) == map.get(new Coord(i + k, j))) {
                                if (canIBlackit(new Coord(i + k, j)))
                                    map.set(new Coord(i + k, j), Box.BLACK);

                            }


                        if (Ranges.inRange(new Coord(i, j + k)))
                            if (isNum(new Coord(i, j + k)) && circleToNum(new Coord(i, j)) == map.get(new Coord(i, j + k))) {
                                if (canIBlackit(new Coord(i, j + k)))
                                    map.set(new Coord(i, j + k), Box.BLACK);

                            }

                    }
                }
            }
        }
    }

    public void solver_op_blacken() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (map.get(new Coord(i, j)) == Box.BLACK) {
                    if (Ranges.inRange(new Coord(i, j + 1)))
                        if (isNum(new Coord(i, j + 1)))
                            map.set(new Coord(i, j + 1), goodNumber(new Coord(i, j + 1)));

                    if (Ranges.inRange(new Coord(i, j - 1)))
                        if (isNum(new Coord(i, j - 1)))
                            map.set(new Coord(i, j - 1), goodNumber(new Coord(i, j - 1)));

                    if (Ranges.inRange(new Coord(i + 1, j)))
                        if (isNum(new Coord(i + 1, j)))
                            map.set(new Coord(i + 1, j), goodNumber(new Coord(i + 1, j)));

                    if (Ranges.inRange(new Coord(i - 1, j)))
                        if (isNum(new Coord(i - 1, j)))
                            map.set(new Coord(i - 1, j), goodNumber(new Coord(i - 1, j)));

                }
            }
        }
    }

    public void solve_corners() {
        if (isNum(new Coord(0, 0)) && isNum(new Coord(0, 1)) && isNum(new Coord(1, 0)))
            if (map.get(new Coord(0, 0)) == map.get(new Coord(0, 1)) && map.get(new Coord(0, 0)) == map.get(new Coord(1, 0)))
                map.set(new Coord(0, 0), Box.BLACK);

        if (isNum(new Coord(4, 0)) && isNum(new Coord(4, 1)) && isNum(new Coord(3, 0)))
            if (map.get(new Coord(4, 0)) == map.get(new Coord(4, 1)) && map.get(new Coord(4, 0)) == map.get(new Coord(3, 0)))
                map.set(new Coord(4, 0), Box.BLACK);

        if (isNum(new Coord(0, 4)) && isNum(new Coord(1, 4)) && isNum(new Coord(0, 3)))
            if (map.get(new Coord(0, 4)) == map.get(new Coord(1, 4)) && map.get(new Coord(0, 4)) == map.get(new Coord(0, 3)))
                map.set(new Coord(0, 4), Box.BLACK);

        if (isNum(new Coord(4, 4)) && isNum(new Coord(4, 3)) && isNum(new Coord(3, 4)))
            if (map.get(new Coord(4, 4)) == map.get(new Coord(4, 3)) && map.get(new Coord(4, 4)) == map.get(new Coord(3, 4)))
                map.set(new Coord(4, 4), Box.BLACK);
        //L
        if (isNum(new Coord(0, 0)) && isNum(new Coord(0, 1)) && isNum(new Coord(1, 0)) && isNum(new Coord(2, 0)))
            if (map.get(new Coord(0, 0)) == map.get(new Coord(0, 1)) && map.get(new Coord(1, 0)) == map.get(new Coord(2, 0)))
                map.set(new Coord(2, 0), Box.BLACK);

        if (isNum(new Coord(0, 0)) && isNum(new Coord(1, 0)) && isNum(new Coord(0, 1)) && isNum(new Coord(0, 2)))
            if (map.get(new Coord(0, 0)) == map.get(new Coord(1, 0)) && map.get(new Coord(0, 1)) == map.get(new Coord(0, 2)))
                map.set(new Coord(0, 2), Box.BLACK);

        if (isNum(new Coord(2, 0)) && isNum(new Coord(3, 0)) && isNum(new Coord(4, 0)) && isNum(new Coord(4, 1)))
            if (map.get(new Coord(2, 0)) == map.get(new Coord(3, 0)) && map.get(new Coord(4, 0)) == map.get(new Coord(4, 1)))
                map.set(new Coord(2, 0), Box.BLACK);

        if (isNum(new Coord(3, 0)) && isNum(new Coord(4, 0)) && isNum(new Coord(4, 1)) && isNum(new Coord(4, 2)))
            if (map.get(new Coord(3, 0)) == map.get(new Coord(4, 0)) && map.get(new Coord(4, 1)) == map.get(new Coord(4, 2)))
                map.set(new Coord(4, 2), Box.BLACK);

        if (isNum(new Coord(4, 4)) && isNum(new Coord(4, 3)) && isNum(new Coord(3, 4)) && isNum(new Coord(2, 4)))
            if (map.get(new Coord(4, 4)) == map.get(new Coord(4, 3)) && map.get(new Coord(3, 4)) == map.get(new Coord(2, 4)))
                map.set(new Coord(2, 4), Box.BLACK);

        if (isNum(new Coord(4, 2)) && isNum(new Coord(4, 3)) && isNum(new Coord(4, 4)) && isNum(new Coord(3, 4)))
            if (map.get(new Coord(4, 2)) == map.get(new Coord(4, 3)) && map.get(new Coord(4, 4)) == map.get(new Coord(3, 4)))
                map.set(new Coord(4, 2), Box.BLACK);

        if (isNum(new Coord(0, 4)) && isNum(new Coord(1, 4)) && isNum(new Coord(0, 3)) && isNum(new Coord(0, 2)))
            if (map.get(new Coord(0, 4)) == map.get(new Coord(1, 4)) && map.get(new Coord(0, 3)) == map.get(new Coord(0, 2)))
                map.set(new Coord(0, 2), Box.BLACK);

        if (isNum(new Coord(0, 3)) && isNum(new Coord(0, 4)) && isNum(new Coord(1, 4)) && isNum(new Coord(2, 4)))
            if (map.get(new Coord(0, 3)) == map.get(new Coord(0, 4)) && map.get(new Coord(1, 4)) == map.get(new Coord(2, 4)))
                map.set(new Coord(2, 4), Box.BLACK);

    }

    public void solve_diagonal() {
        //5diagonal
        if (map.get(new Coord(0, 0)) == Box.BLACK && map.get(new Coord(1, 1)) == Box.BLACK
                && map.get(new Coord(2, 2)) == Box.BLACK && map.get(new Coord(3, 3)) == Box.BLACK && isNum(new Coord(4, 4)))
            map.set(new Coord(4, 4), goodNumber(new Coord(4, 4)));

        if (map.get(new Coord(0, 0)) == Box.BLACK && map.get(new Coord(1, 1)) == Box.BLACK
                && map.get(new Coord(2, 2)) == Box.BLACK && map.get(new Coord(4, 4)) == Box.BLACK && isNum(new Coord(3, 3)))
            map.set(new Coord(3, 3), goodNumber(new Coord(3, 3)));

        if (map.get(new Coord(0, 0)) == Box.BLACK && map.get(new Coord(1, 1)) == Box.BLACK
                && map.get(new Coord(3, 3)) == Box.BLACK && map.get(new Coord(4, 4)) == Box.BLACK && isNum(new Coord(2, 2)))
            map.set(new Coord(2, 2), goodNumber(new Coord(2, 2)));

        if (map.get(new Coord(0, 0)) == Box.BLACK && map.get(new Coord(3, 3)) == Box.BLACK
                && map.get(new Coord(2, 2)) == Box.BLACK && map.get(new Coord(4, 4)) == Box.BLACK && isNum(new Coord(1, 1)))
            map.set(new Coord(1, 1), goodNumber(new Coord(1, 1)));

        if (map.get(new Coord(3, 3)) == Box.BLACK && map.get(new Coord(1, 1)) == Box.BLACK
                && map.get(new Coord(2, 2)) == Box.BLACK && map.get(new Coord(4, 4)) == Box.BLACK && isNum(new Coord(0, 0)))
            map.set(new Coord(0, 0), goodNumber(new Coord(0, 0)));


        if (map.get(new Coord(1, 3)) == Box.BLACK && map.get(new Coord(2, 2)) == Box.BLACK
                && map.get(new Coord(3, 1)) == Box.BLACK && map.get(new Coord(4, 0)) == Box.BLACK && isNum(new Coord(0, 4)))
            map.set(new Coord(0, 4), goodNumber(new Coord(0, 4)));

        if (map.get(new Coord(0, 4)) == Box.BLACK && map.get(new Coord(2, 2)) == Box.BLACK
                && map.get(new Coord(3, 1)) == Box.BLACK && map.get(new Coord(4, 0)) == Box.BLACK && isNum(new Coord(1, 3)))
            map.set(new Coord(1, 3), goodNumber(new Coord(1, 3)));

        if (map.get(new Coord(1, 3)) == Box.BLACK && map.get(new Coord(0, 4)) == Box.BLACK
                && map.get(new Coord(3, 1)) == Box.BLACK && map.get(new Coord(4, 0)) == Box.BLACK && isNum(new Coord(2, 2)))
            map.set(new Coord(2, 2), goodNumber(new Coord(2, 2)));

        if (map.get(new Coord(1, 3)) == Box.BLACK && map.get(new Coord(2, 2)) == Box.BLACK
                && map.get(new Coord(0, 4)) == Box.BLACK && map.get(new Coord(4, 0)) == Box.BLACK && isNum(new Coord(3, 1)))
            map.set(new Coord(3, 1), goodNumber(new Coord(3, 1)));

        if (map.get(new Coord(1, 3)) == Box.BLACK && map.get(new Coord(2, 2)) == Box.BLACK
                && map.get(new Coord(3, 1)) == Box.BLACK && map.get(new Coord(0, 4)) == Box.BLACK && isNum(new Coord(4, 0)))
            map.set(new Coord(4, 0), goodNumber(new Coord(4, 0)));

        //4diagonal
        if (map.get(new Coord(0, 1)) == Box.BLACK && map.get(new Coord(1, 2)) == Box.BLACK
                && map.get(new Coord(2, 3)) == Box.BLACK && isNum(new Coord(3, 4)))
            map.set(new Coord(3, 4), goodNumber(new Coord(3, 4)));

        if (map.get(new Coord(0, 1)) == Box.BLACK && map.get(new Coord(1, 2)) == Box.BLACK
                && map.get(new Coord(3, 4)) == Box.BLACK && isNum(new Coord(2, 3)))
            map.set(new Coord(2, 3), goodNumber(new Coord(2, 3)));

        if (map.get(new Coord(0, 1)) == Box.BLACK && map.get(new Coord(3, 4)) == Box.BLACK
                && map.get(new Coord(2, 3)) == Box.BLACK && isNum(new Coord(1, 2)))
            map.set(new Coord(1, 2), goodNumber(new Coord(1, 2)));

        if (map.get(new Coord(3, 4)) == Box.BLACK && map.get(new Coord(1, 2)) == Box.BLACK
                && map.get(new Coord(2, 3)) == Box.BLACK && isNum(new Coord(0, 1)))
            map.set(new Coord(0, 1), goodNumber(new Coord(0, 1)));

        if (map.get(new Coord(1, 0)) == Box.BLACK && map.get(new Coord(2, 1)) == Box.BLACK
                && map.get(new Coord(3, 2)) == Box.BLACK && isNum(new Coord(4, 3)))
            map.set(new Coord(4, 3), goodNumber(new Coord(4, 3)));

        if (map.get(new Coord(1, 0)) == Box.BLACK && map.get(new Coord(2, 1)) == Box.BLACK
                && map.get(new Coord(4, 3)) == Box.BLACK && isNum(new Coord(3, 2)))
            map.set(new Coord(3, 2), goodNumber(new Coord(3, 2)));

        if (map.get(new Coord(1, 0)) == Box.BLACK && map.get(new Coord(4, 3)) == Box.BLACK
                && map.get(new Coord(3, 2)) == Box.BLACK && isNum(new Coord(2, 1)))
            map.set(new Coord(2, 1), goodNumber(new Coord(2, 1)));

        if (map.get(new Coord(4, 3)) == Box.BLACK && map.get(new Coord(2, 1)) == Box.BLACK
                && map.get(new Coord(3, 2)) == Box.BLACK && isNum(new Coord(1, 0)))
            map.set(new Coord(1, 0), goodNumber(new Coord(1, 0)));


        if (map.get(new Coord(0, 3)) == Box.BLACK && map.get(new Coord(1, 2)) == Box.BLACK
                && map.get(new Coord(2, 1)) == Box.BLACK && isNum(new Coord(3, 0)))
            map.set(new Coord(3, 0), goodNumber(new Coord(3, 0)));

        if (map.get(new Coord(0, 3)) == Box.BLACK && map.get(new Coord(1, 2)) == Box.BLACK
                && map.get(new Coord(3, 0)) == Box.BLACK && isNum(new Coord(2, 1)))
            map.set(new Coord(2, 1), goodNumber(new Coord(2, 1)));

        if (map.get(new Coord(0, 3)) == Box.BLACK && map.get(new Coord(3, 0)) == Box.BLACK
                && map.get(new Coord(2, 1)) == Box.BLACK && isNum(new Coord(1, 2)))
            map.set(new Coord(1, 2), goodNumber(new Coord(1, 2)));

        if (map.get(new Coord(1, 2)) == Box.BLACK && map.get(new Coord(3, 0)) == Box.BLACK
                && map.get(new Coord(2, 1)) == Box.BLACK && isNum(new Coord(0, 3)))
            map.set(new Coord(0, 3), goodNumber(new Coord(0, 3)));

        if (map.get(new Coord(4, 1)) == Box.BLACK && map.get(new Coord(3, 2)) == Box.BLACK
                && map.get(new Coord(2, 3)) == Box.BLACK && isNum(new Coord(1, 4)))
            map.set(new Coord(1, 4), goodNumber(new Coord(1, 4)));

        if (map.get(new Coord(4, 1)) == Box.BLACK && map.get(new Coord(3, 2)) == Box.BLACK
                && map.get(new Coord(1, 4)) == Box.BLACK && isNum(new Coord(2, 3)))
            map.set(new Coord(2, 3), goodNumber(new Coord(2, 3)));

        if (map.get(new Coord(4, 1)) == Box.BLACK && map.get(new Coord(1, 4)) == Box.BLACK
                && map.get(new Coord(2, 3)) == Box.BLACK && isNum(new Coord(3, 2)))
            map.set(new Coord(3, 2), goodNumber(new Coord(3, 2)));

        if (map.get(new Coord(1, 4)) == Box.BLACK && map.get(new Coord(3, 2)) == Box.BLACK
                && map.get(new Coord(2, 3)) == Box.BLACK && isNum(new Coord(4, 1)))
            map.set(new Coord(4, 1), goodNumber(new Coord(4, 1)));

        //3diagonal
        if (map.get(new Coord(0, 2)) == Box.BLACK && map.get(new Coord(1, 3)) == Box.BLACK
                && isNum(new Coord(2, 4)))
            map.set(new Coord(2, 4), goodNumber(new Coord(2, 4)));

        if (map.get(new Coord(0, 2)) == Box.BLACK && map.get(new Coord(2, 4)) == Box.BLACK
                && isNum(new Coord(1, 3)))
            map.set(new Coord(1, 3), goodNumber(new Coord(1, 3)));

        if (map.get(new Coord(2, 4)) == Box.BLACK && map.get(new Coord(1, 3)) == Box.BLACK
                && isNum(new Coord(0, 2)))
            map.set(new Coord(0, 2), goodNumber(new Coord(0, 2)));

        if (map.get(new Coord(4, 2)) == Box.BLACK && map.get(new Coord(3, 1)) == Box.BLACK
                && isNum(new Coord(2, 0)))
            map.set(new Coord(2, 0), goodNumber(new Coord(2, 0)));

        if (map.get(new Coord(4, 2)) == Box.BLACK && map.get(new Coord(2, 0)) == Box.BLACK
                && isNum(new Coord(3, 1)))
            map.set(new Coord(3, 1), goodNumber(new Coord(3, 1)));

        if (map.get(new Coord(2, 0)) == Box.BLACK && map.get(new Coord(3, 1)) == Box.BLACK
                && isNum(new Coord(4, 2)))
            map.set(new Coord(4, 2), goodNumber(new Coord(4, 2)));


        if (map.get(new Coord(2, 0)) == Box.BLACK && map.get(new Coord(1, 1)) == Box.BLACK
                && isNum(new Coord(0, 2)))
            map.set(new Coord(0, 2), goodNumber(new Coord(0, 2)));

        if (map.get(new Coord(2, 0)) == Box.BLACK && map.get(new Coord(0, 2)) == Box.BLACK
                && isNum(new Coord(1, 1)))
            map.set(new Coord(1, 1), goodNumber(new Coord(1, 1)));

        if (map.get(new Coord(0, 2)) == Box.BLACK && map.get(new Coord(1, 1)) == Box.BLACK
                && isNum(new Coord(2, 0)))
            map.set(new Coord(2, 0), goodNumber(new Coord(2, 0)));

        if (map.get(new Coord(4, 2)) == Box.BLACK && map.get(new Coord(3, 3)) == Box.BLACK
                && isNum(new Coord(2, 4)))
            map.set(new Coord(2, 4), goodNumber(new Coord(2, 4)));

        if (map.get(new Coord(4, 2)) == Box.BLACK && map.get(new Coord(2, 4)) == Box.BLACK
                && isNum(new Coord(3, 3)))
            map.set(new Coord(3, 3), goodNumber(new Coord(3, 3)));

        if (map.get(new Coord(2, 4)) == Box.BLACK && map.get(new Coord(3, 3)) == Box.BLACK
                && isNum(new Coord(4, 2)))
            map.set(new Coord(4, 2), goodNumber(new Coord(4, 2)));

        //2diagonal
        if (map.get(new Coord(0, 1)) == Box.BLACK && isNum(new Coord(1, 0)))
            map.set(new Coord(1, 0), goodNumber(new Coord(1, 0)));

        if (map.get(new Coord(1, 0)) == Box.BLACK && isNum(new Coord(0, 1)))
            map.set(new Coord(0, 1), goodNumber(new Coord(0, 1)));

        if (map.get(new Coord(4, 3)) == Box.BLACK && isNum(new Coord(3, 4)))
            map.set(new Coord(3, 4), goodNumber(new Coord(3, 4)));

        if (map.get(new Coord(4, 3)) == Box.BLACK && isNum(new Coord(4, 3)))
            map.set(new Coord(4, 3), goodNumber(new Coord(4, 3)));

        if (map.get(new Coord(3, 0)) == Box.BLACK && isNum(new Coord(4, 1)))
            map.set(new Coord(4, 1), goodNumber(new Coord(4, 1)));

        if (map.get(new Coord(4, 1)) == Box.BLACK && isNum(new Coord(3, 0)))
            map.set(new Coord(3, 0), goodNumber(new Coord(3, 0)));

        if (map.get(new Coord(0, 3)) == Box.BLACK && isNum(new Coord(1, 4)))
            map.set(new Coord(1, 4), goodNumber(new Coord(1, 4)));

        if (map.get(new Coord(1, 4)) == Box.BLACK && isNum(new Coord(0, 3)))
            map.set(new Coord(0, 3), goodNumber(new Coord(0, 3)));

    }

    public void solve_big_triangle() {
        //top
        if (map.get(new Coord(0, 0)) == Box.BLACK && map.get(new Coord(1, 1)) == Box.BLACK
                && map.get(new Coord(2, 2)) == Box.BLACK && map.get(new Coord(1, 3)) == Box.BLACK && isNum(new Coord(0, 4)))
            map.set(new Coord(0, 4), goodNumber(new Coord(0, 4)));

        if (map.get(new Coord(0, 0)) == Box.BLACK && map.get(new Coord(1, 1)) == Box.BLACK
                && map.get(new Coord(2, 2)) == Box.BLACK && map.get(new Coord(0, 4)) == Box.BLACK && isNum(new Coord(1, 3)))
            map.set(new Coord(1, 3), goodNumber(new Coord(1, 3)));

        if (map.get(new Coord(0, 0)) == Box.BLACK && map.get(new Coord(1, 1)) == Box.BLACK
                && map.get(new Coord(0, 4)) == Box.BLACK && map.get(new Coord(1, 3)) == Box.BLACK && isNum(new Coord(2, 2)))
            map.set(new Coord(2, 2), goodNumber(new Coord(2, 2)));

        if (map.get(new Coord(0, 0)) == Box.BLACK && map.get(new Coord(0, 4)) == Box.BLACK
                && map.get(new Coord(2, 2)) == Box.BLACK && map.get(new Coord(1, 3)) == Box.BLACK && isNum(new Coord(1, 1)))
            map.set(new Coord(1, 1), goodNumber(new Coord(1, 1)));

        if (map.get(new Coord(0, 4)) == Box.BLACK && map.get(new Coord(1, 1)) == Box.BLACK
                && map.get(new Coord(2, 2)) == Box.BLACK && map.get(new Coord(1, 3)) == Box.BLACK && isNum(new Coord(0, 0)))
            map.set(new Coord(0, 0), goodNumber(new Coord(0, 0)));

        //bot
        if (map.get(new Coord(4, 0)) == Box.BLACK && map.get(new Coord(3, 1)) == Box.BLACK
                && map.get(new Coord(2, 2)) == Box.BLACK && map.get(new Coord(3, 3)) == Box.BLACK && isNum(new Coord(4, 4)))
            map.set(new Coord(4, 4), goodNumber(new Coord(4, 4)));

        if (map.get(new Coord(4, 0)) == Box.BLACK && map.get(new Coord(3, 1)) == Box.BLACK
                && map.get(new Coord(2, 2)) == Box.BLACK && map.get(new Coord(4, 4)) == Box.BLACK && isNum(new Coord(3, 3)))
            map.set(new Coord(3, 3), goodNumber(new Coord(3, 3)));

        if (map.get(new Coord(4, 0)) == Box.BLACK && map.get(new Coord(3, 1)) == Box.BLACK
                && map.get(new Coord(4, 4)) == Box.BLACK && map.get(new Coord(3, 3)) == Box.BLACK && isNum(new Coord(2, 2)))
            map.set(new Coord(2, 2), goodNumber(new Coord(2, 2)));

        if (map.get(new Coord(4, 0)) == Box.BLACK && map.get(new Coord(4, 4)) == Box.BLACK
                && map.get(new Coord(2, 2)) == Box.BLACK && map.get(new Coord(3, 3)) == Box.BLACK && isNum(new Coord(3, 1)))
            map.set(new Coord(3, 1), goodNumber(new Coord(3, 1)));

        if (map.get(new Coord(4, 4)) == Box.BLACK && map.get(new Coord(3, 1)) == Box.BLACK
                && map.get(new Coord(2, 2)) == Box.BLACK && map.get(new Coord(3, 3)) == Box.BLACK && isNum(new Coord(4, 0)))
            map.set(new Coord(4, 0), goodNumber(new Coord(4, 0)));

        //left
        if (map.get(new Coord(0, 0)) == Box.BLACK && map.get(new Coord(1, 1)) == Box.BLACK
                && map.get(new Coord(2, 2)) == Box.BLACK && map.get(new Coord(3, 1)) == Box.BLACK && isNum(new Coord(4, 0)))
            map.set(new Coord(4, 0), goodNumber(new Coord(4, 0)));

        if (map.get(new Coord(0, 0)) == Box.BLACK && map.get(new Coord(1, 1)) == Box.BLACK
                && map.get(new Coord(2, 2)) == Box.BLACK && map.get(new Coord(4, 0)) == Box.BLACK && isNum(new Coord(3, 1)))
            map.set(new Coord(3, 1), goodNumber(new Coord(3, 1)));

        if (map.get(new Coord(0, 0)) == Box.BLACK && map.get(new Coord(1, 1)) == Box.BLACK
                && map.get(new Coord(4, 0)) == Box.BLACK && map.get(new Coord(3, 1)) == Box.BLACK && isNum(new Coord(2, 2)))
            map.set(new Coord(2, 2), goodNumber(new Coord(2, 2)));

        if (map.get(new Coord(0, 0)) == Box.BLACK && map.get(new Coord(4, 0)) == Box.BLACK
                && map.get(new Coord(2, 2)) == Box.BLACK && map.get(new Coord(3, 1)) == Box.BLACK && isNum(new Coord(1, 1)))
            map.set(new Coord(1, 1), goodNumber(new Coord(1, 1)));

        if (map.get(new Coord(4, 0)) == Box.BLACK && map.get(new Coord(1, 1)) == Box.BLACK
                && map.get(new Coord(2, 2)) == Box.BLACK && map.get(new Coord(3, 1)) == Box.BLACK && isNum(new Coord(0, 0)))
            map.set(new Coord(0, 0), goodNumber(new Coord(0, 0)));

        //right
        if (map.get(new Coord(0, 4)) == Box.BLACK && map.get(new Coord(1, 3)) == Box.BLACK
                && map.get(new Coord(2, 2)) == Box.BLACK && map.get(new Coord(3, 3)) == Box.BLACK && isNum(new Coord(4, 4)))
            map.set(new Coord(4, 4), goodNumber(new Coord(4, 4)));

        if (map.get(new Coord(0, 4)) == Box.BLACK && map.get(new Coord(1, 3)) == Box.BLACK
                && map.get(new Coord(2, 2)) == Box.BLACK && map.get(new Coord(4, 4)) == Box.BLACK && isNum(new Coord(3, 3)))
            map.set(new Coord(3, 3), goodNumber(new Coord(3, 3)));

        if (map.get(new Coord(0, 4)) == Box.BLACK && map.get(new Coord(1, 3)) == Box.BLACK
                && map.get(new Coord(4, 4)) == Box.BLACK && map.get(new Coord(3, 3)) == Box.BLACK && isNum(new Coord(2, 2)))
            map.set(new Coord(2, 2), goodNumber(new Coord(2, 2)));

        if (map.get(new Coord(0, 4)) == Box.BLACK && map.get(new Coord(4, 4)) == Box.BLACK
                && map.get(new Coord(2, 2)) == Box.BLACK && map.get(new Coord(3, 3)) == Box.BLACK && isNum(new Coord(1, 3)))
            map.set(new Coord(1, 3), goodNumber(new Coord(1, 3)));

        if (map.get(new Coord(4, 4)) == Box.BLACK && map.get(new Coord(1, 3)) == Box.BLACK
                && map.get(new Coord(2, 2)) == Box.BLACK && map.get(new Coord(3, 3)) == Box.BLACK && isNum(new Coord(0, 4)))
            map.set(new Coord(0, 4), goodNumber(new Coord(0, 4)));


    }

    public void solve_big_figure() {
        //4 diagonal + 1
        if (map.get(new Coord(0, 0)) == Box.BLACK && map.get(new Coord(1, 1)) == Box.BLACK && map.get(new Coord(2, 2)) == Box.BLACK
                && map.get(new Coord(3, 3)) == Box.BLACK && isNum(new Coord(4, 2)))
            map.set(new Coord(4, 2), goodNumber(new Coord(4, 2)));

        if (map.get(new Coord(0, 0)) == Box.BLACK && map.get(new Coord(1, 1)) == Box.BLACK && map.get(new Coord(2, 2)) == Box.BLACK
                && map.get(new Coord(4, 2)) == Box.BLACK && isNum(new Coord(3, 3)))
            map.set(new Coord(3, 3), goodNumber(new Coord(3, 3)));

        if (map.get(new Coord(0, 0)) == Box.BLACK && map.get(new Coord(1, 1)) == Box.BLACK && map.get(new Coord(4, 2)) == Box.BLACK
                && map.get(new Coord(3, 3)) == Box.BLACK && isNum(new Coord(2, 2)))
            map.set(new Coord(2, 2), goodNumber(new Coord(2, 2)));

        if (map.get(new Coord(0, 0)) == Box.BLACK && map.get(new Coord(4, 2)) == Box.BLACK && map.get(new Coord(2, 2)) == Box.BLACK
                && map.get(new Coord(3, 3)) == Box.BLACK && isNum(new Coord(1, 1)))
            map.set(new Coord(1, 1), goodNumber(new Coord(1, 1)));

        if (map.get(new Coord(4, 2)) == Box.BLACK && map.get(new Coord(1, 1)) == Box.BLACK && map.get(new Coord(2, 2)) == Box.BLACK
                && map.get(new Coord(3, 3)) == Box.BLACK && isNum(new Coord(0, 0)))
            map.set(new Coord(0, 0), goodNumber(new Coord(0, 0)));

        if (map.get(new Coord(0, 0)) == Box.BLACK && map.get(new Coord(1, 1)) == Box.BLACK && map.get(new Coord(2, 2)) == Box.BLACK
                && map.get(new Coord(3, 3)) == Box.BLACK && isNum(new Coord(2, 4)))
            map.set(new Coord(2, 4), goodNumber(new Coord(2, 4)));

        if (map.get(new Coord(0, 0)) == Box.BLACK && map.get(new Coord(1, 1)) == Box.BLACK && map.get(new Coord(2, 2)) == Box.BLACK
                && map.get(new Coord(2, 4)) == Box.BLACK && isNum(new Coord(3, 3)))
            map.set(new Coord(3, 3), goodNumber(new Coord(3, 3)));

        if (map.get(new Coord(0, 0)) == Box.BLACK && map.get(new Coord(1, 1)) == Box.BLACK && map.get(new Coord(2, 4)) == Box.BLACK
                && map.get(new Coord(3, 3)) == Box.BLACK && isNum(new Coord(2, 2)))
            map.set(new Coord(2, 2), goodNumber(new Coord(2, 2)));

        if (map.get(new Coord(0, 0)) == Box.BLACK && map.get(new Coord(2, 4)) == Box.BLACK && map.get(new Coord(2, 2)) == Box.BLACK
                && map.get(new Coord(3, 3)) == Box.BLACK && isNum(new Coord(1, 1)))
            map.set(new Coord(1, 1), goodNumber(new Coord(1, 1)));

        if (map.get(new Coord(2, 4)) == Box.BLACK && map.get(new Coord(1, 1)) == Box.BLACK && map.get(new Coord(2, 2)) == Box.BLACK
                && map.get(new Coord(3, 3)) == Box.BLACK && isNum(new Coord(0, 0)))
            map.set(new Coord(0, 0), goodNumber(new Coord(0, 0)));


        if (map.get(new Coord(4, 4)) == Box.BLACK && map.get(new Coord(1, 1)) == Box.BLACK && map.get(new Coord(2, 2)) == Box.BLACK
                && map.get(new Coord(3, 3)) == Box.BLACK && isNum(new Coord(0, 2)))
            map.set(new Coord(0, 2), goodNumber(new Coord(0, 2)));

        if (map.get(new Coord(4, 4)) == Box.BLACK && map.get(new Coord(1, 1)) == Box.BLACK && map.get(new Coord(2, 2)) == Box.BLACK
                && map.get(new Coord(0, 2)) == Box.BLACK && isNum(new Coord(3, 3)))
            map.set(new Coord(3, 3), goodNumber(new Coord(3, 3)));

        if (map.get(new Coord(4, 4)) == Box.BLACK && map.get(new Coord(1, 1)) == Box.BLACK && map.get(new Coord(0, 2)) == Box.BLACK
                && map.get(new Coord(3, 3)) == Box.BLACK && isNum(new Coord(2, 2)))
            map.set(new Coord(2, 2), goodNumber(new Coord(2, 2)));

        if (map.get(new Coord(4, 4)) == Box.BLACK && map.get(new Coord(0, 2)) == Box.BLACK && map.get(new Coord(2, 2)) == Box.BLACK
                && map.get(new Coord(3, 3)) == Box.BLACK && isNum(new Coord(1, 1)))
            map.set(new Coord(1, 1), goodNumber(new Coord(1, 1)));

        if (map.get(new Coord(0, 2)) == Box.BLACK && map.get(new Coord(1, 1)) == Box.BLACK && map.get(new Coord(2, 2)) == Box.BLACK
                && map.get(new Coord(3, 3)) == Box.BLACK && isNum(new Coord(4, 4)))
            map.set(new Coord(4, 4), goodNumber(new Coord(4, 4)));

        if (map.get(new Coord(4, 4)) == Box.BLACK && map.get(new Coord(1, 1)) == Box.BLACK && map.get(new Coord(2, 2)) == Box.BLACK
                && map.get(new Coord(3, 3)) == Box.BLACK && isNum(new Coord(2, 0)))
            map.set(new Coord(2, 0), goodNumber(new Coord(2, 0)));

        if (map.get(new Coord(4, 4)) == Box.BLACK && map.get(new Coord(1, 1)) == Box.BLACK && map.get(new Coord(2, 2)) == Box.BLACK
                && map.get(new Coord(2, 0)) == Box.BLACK && isNum(new Coord(3, 3)))
            map.set(new Coord(3, 3), goodNumber(new Coord(3, 3)));

        if (map.get(new Coord(4, 4)) == Box.BLACK && map.get(new Coord(1, 1)) == Box.BLACK && map.get(new Coord(2, 0)) == Box.BLACK
                && map.get(new Coord(3, 3)) == Box.BLACK && isNum(new Coord(2, 2)))
            map.set(new Coord(2, 2), goodNumber(new Coord(2, 2)));

        if (map.get(new Coord(4, 4)) == Box.BLACK && map.get(new Coord(2, 0)) == Box.BLACK && map.get(new Coord(2, 2)) == Box.BLACK
                && map.get(new Coord(3, 3)) == Box.BLACK && isNum(new Coord(1, 1)))
            map.set(new Coord(1, 1), goodNumber(new Coord(1, 1)));

        if (map.get(new Coord(2, 0)) == Box.BLACK && map.get(new Coord(1, 1)) == Box.BLACK && map.get(new Coord(2, 2)) == Box.BLACK
                && map.get(new Coord(3, 3)) == Box.BLACK && isNum(new Coord(4, 4)))
            map.set(new Coord(4, 4), goodNumber(new Coord(4, 4)));


        if (map.get(new Coord(0, 4)) == Box.BLACK && map.get(new Coord(1, 3)) == Box.BLACK && map.get(new Coord(2, 2)) == Box.BLACK
                && map.get(new Coord(3, 1)) == Box.BLACK && isNum(new Coord(4, 2)))
            map.set(new Coord(4, 2), goodNumber(new Coord(4, 2)));

        if (map.get(new Coord(0, 4)) == Box.BLACK && map.get(new Coord(1, 3)) == Box.BLACK && map.get(new Coord(2, 2)) == Box.BLACK
                && map.get(new Coord(4, 2)) == Box.BLACK && isNum(new Coord(3, 1)))
            map.set(new Coord(3, 1), goodNumber(new Coord(3, 1)));

        if (map.get(new Coord(0, 4)) == Box.BLACK && map.get(new Coord(1, 3)) == Box.BLACK && map.get(new Coord(4, 2)) == Box.BLACK
                && map.get(new Coord(3, 1)) == Box.BLACK && isNum(new Coord(2, 2)))
            map.set(new Coord(2, 2), goodNumber(new Coord(2, 2)));

        if (map.get(new Coord(0, 4)) == Box.BLACK && map.get(new Coord(4, 2)) == Box.BLACK && map.get(new Coord(2, 2)) == Box.BLACK
                && map.get(new Coord(3, 1)) == Box.BLACK && isNum(new Coord(1, 3)))
            map.set(new Coord(1, 3), goodNumber(new Coord(1, 3)));

        if (map.get(new Coord(4, 2)) == Box.BLACK && map.get(new Coord(1, 3)) == Box.BLACK && map.get(new Coord(2, 2)) == Box.BLACK
                && map.get(new Coord(3, 1)) == Box.BLACK && isNum(new Coord(0, 4)))
            map.set(new Coord(0, 4), goodNumber(new Coord(0, 4)));

        if (map.get(new Coord(0, 4)) == Box.BLACK && map.get(new Coord(1, 3)) == Box.BLACK && map.get(new Coord(2, 2)) == Box.BLACK
                && map.get(new Coord(3, 1)) == Box.BLACK && isNum(new Coord(2, 0)))
            map.set(new Coord(2, 0), goodNumber(new Coord(2, 0)));

        if (map.get(new Coord(0, 4)) == Box.BLACK && map.get(new Coord(1, 3)) == Box.BLACK && map.get(new Coord(2, 2)) == Box.BLACK
                && map.get(new Coord(2, 0)) == Box.BLACK && isNum(new Coord(3, 1)))
            map.set(new Coord(3, 1), goodNumber(new Coord(3, 1)));

        if (map.get(new Coord(0, 4)) == Box.BLACK && map.get(new Coord(1, 3)) == Box.BLACK && map.get(new Coord(2, 0)) == Box.BLACK
                && map.get(new Coord(3, 1)) == Box.BLACK && isNum(new Coord(2, 2)))
            map.set(new Coord(2, 2), goodNumber(new Coord(2, 2)));

        if (map.get(new Coord(0, 4)) == Box.BLACK && map.get(new Coord(2, 0)) == Box.BLACK && map.get(new Coord(2, 2)) == Box.BLACK
                && map.get(new Coord(3, 1)) == Box.BLACK && isNum(new Coord(1, 3)))
            map.set(new Coord(1, 3), goodNumber(new Coord(1, 3)));

        if (map.get(new Coord(2, 0)) == Box.BLACK && map.get(new Coord(1, 3)) == Box.BLACK && map.get(new Coord(2, 2)) == Box.BLACK
                && map.get(new Coord(3, 1)) == Box.BLACK && isNum(new Coord(0, 4)))
            map.set(new Coord(0, 4), goodNumber(new Coord(0, 4)));


        if (map.get(new Coord(0, 2)) == Box.BLACK && map.get(new Coord(1, 3)) == Box.BLACK && map.get(new Coord(2, 2)) == Box.BLACK
                && map.get(new Coord(3, 1)) == Box.BLACK && isNum(new Coord(4, 0)))
            map.set(new Coord(4, 0), goodNumber(new Coord(4, 0)));

        if (map.get(new Coord(0, 2)) == Box.BLACK && map.get(new Coord(1, 3)) == Box.BLACK && map.get(new Coord(2, 2)) == Box.BLACK
                && map.get(new Coord(4, 0)) == Box.BLACK && isNum(new Coord(3, 1)))
            map.set(new Coord(3, 1), goodNumber(new Coord(3, 1)));

        if (map.get(new Coord(0, 2)) == Box.BLACK && map.get(new Coord(1, 3)) == Box.BLACK && map.get(new Coord(4, 0)) == Box.BLACK
                && map.get(new Coord(3, 1)) == Box.BLACK && isNum(new Coord(2, 2)))
            map.set(new Coord(2, 2), goodNumber(new Coord(2, 2)));

        if (map.get(new Coord(0, 2)) == Box.BLACK && map.get(new Coord(4, 0)) == Box.BLACK && map.get(new Coord(2, 2)) == Box.BLACK
                && map.get(new Coord(3, 1)) == Box.BLACK && isNum(new Coord(1, 3)))
            map.set(new Coord(1, 3), goodNumber(new Coord(1, 3)));

        if (map.get(new Coord(4, 0)) == Box.BLACK && map.get(new Coord(1, 3)) == Box.BLACK && map.get(new Coord(2, 2)) == Box.BLACK
                && map.get(new Coord(3, 1)) == Box.BLACK && isNum(new Coord(0, 2)))
            map.set(new Coord(0, 2), goodNumber(new Coord(0, 2)));

        if (map.get(new Coord(2, 4)) == Box.BLACK && map.get(new Coord(1, 3)) == Box.BLACK && map.get(new Coord(2, 2)) == Box.BLACK
                && map.get(new Coord(3, 1)) == Box.BLACK && isNum(new Coord(4, 0)))
            map.set(new Coord(4, 0), goodNumber(new Coord(4, 0)));

        if (map.get(new Coord(2, 4)) == Box.BLACK && map.get(new Coord(1, 3)) == Box.BLACK && map.get(new Coord(2, 2)) == Box.BLACK
                && map.get(new Coord(4, 0)) == Box.BLACK && isNum(new Coord(3, 1)))
            map.set(new Coord(3, 1), goodNumber(new Coord(3, 1)));

        if (map.get(new Coord(2, 4)) == Box.BLACK && map.get(new Coord(1, 3)) == Box.BLACK && map.get(new Coord(4, 0)) == Box.BLACK
                && map.get(new Coord(3, 1)) == Box.BLACK && isNum(new Coord(2, 2)))
            map.set(new Coord(2, 2), goodNumber(new Coord(2, 2)));

        if (map.get(new Coord(2, 4)) == Box.BLACK && map.get(new Coord(4, 0)) == Box.BLACK && map.get(new Coord(2, 2)) == Box.BLACK
                && map.get(new Coord(3, 1)) == Box.BLACK && isNum(new Coord(1, 3)))
            map.set(new Coord(1, 3), goodNumber(new Coord(1, 3)));

        if (map.get(new Coord(4, 0)) == Box.BLACK && map.get(new Coord(1, 3)) == Box.BLACK && map.get(new Coord(2, 2)) == Box.BLACK
                && map.get(new Coord(3, 1)) == Box.BLACK && isNum(new Coord(2, 4)))
            map.set(new Coord(2, 4), goodNumber(new Coord(2, 4)));


        //3 diagonal + 1

        if (map.get(new Coord(1, 0)) == Box.BLACK && map.get(new Coord(2, 1)) == Box.BLACK
                && map.get(new Coord(3, 2)) == Box.BLACK && isNum(new Coord(4, 1)))
            map.set(new Coord(4, 1), goodNumber(new Coord(4, 1)));

        if (map.get(new Coord(1, 0)) == Box.BLACK && map.get(new Coord(2, 1)) == Box.BLACK
                && map.get(new Coord(4, 1)) == Box.BLACK && isNum(new Coord(3, 2)))
            map.set(new Coord(3, 2), goodNumber(new Coord(3, 2)));

        if (map.get(new Coord(1, 0)) == Box.BLACK && map.get(new Coord(4, 1)) == Box.BLACK
                && map.get(new Coord(3, 2)) == Box.BLACK && isNum(new Coord(2, 1)))
            map.set(new Coord(2, 1), goodNumber(new Coord(2, 1)));

        if (map.get(new Coord(4, 1)) == Box.BLACK && map.get(new Coord(2, 1)) == Box.BLACK
                && map.get(new Coord(3, 2)) == Box.BLACK && isNum(new Coord(1, 0)))
            map.set(new Coord(1, 0), goodNumber(new Coord(1, 0)));


        if (map.get(new Coord(0, 1)) == Box.BLACK && map.get(new Coord(1, 2)) == Box.BLACK
                && map.get(new Coord(2, 3)) == Box.BLACK && isNum(new Coord(1, 4)))
            map.set(new Coord(1, 4), goodNumber(new Coord(1, 4)));

        if (map.get(new Coord(0, 1)) == Box.BLACK && map.get(new Coord(1, 2)) == Box.BLACK
                && map.get(new Coord(1, 4)) == Box.BLACK && isNum(new Coord(2, 3)))
            map.set(new Coord(2, 3), goodNumber(new Coord(2, 3)));

        if (map.get(new Coord(0, 1)) == Box.BLACK && map.get(new Coord(1, 4)) == Box.BLACK
                && map.get(new Coord(2, 3)) == Box.BLACK && isNum(new Coord(1, 2)))
            map.set(new Coord(1, 2), goodNumber(new Coord(1, 2)));

        if (map.get(new Coord(1, 4)) == Box.BLACK && map.get(new Coord(1, 2)) == Box.BLACK
                && map.get(new Coord(2, 3)) == Box.BLACK && isNum(new Coord(0, 1)))
            map.set(new Coord(0, 1), goodNumber(new Coord(0, 1)));


        //folytatom csak rovidebben
        Coord a = (new Coord(3, 0));
        Coord b = (new Coord(2, 1));
        Coord c = (new Coord(3, 2));
        Coord d = (new Coord(4, 3));
        if (sok_Black_egy_num(a, b, c, d)) {
            map.set(findNumCoordOf4(a, b, c, d), goodNumber(findNumCoordOf4(a, b, c, d)));
        }

        Coord a1 = (new Coord(0, 3));
        Coord b1 = (new Coord(1, 2));
        Coord c1 = (new Coord(2, 3));
        Coord d1 = (new Coord(3, 4));
        if (sok_Black_egy_num(a1, b1, c1, d1)) {
            map.set(findNumCoordOf4(a1, b1, c1, d1), goodNumber(findNumCoordOf4(a1, b1, c1, d1)));
        }

        Coord a2 = (new Coord(3, 0));
        Coord b2 = (new Coord(2, 1));
        Coord c2 = (new Coord(1, 2));
        Coord d2 = (new Coord(0, 1));

        if (sok_Black_egy_num(a2, b2, c2, d2)) {
            map.set(findNumCoordOf4(a2, b2, c2, d2), goodNumber(findNumCoordOf4(a2, b2, c2, d2)));
        }

        Coord a3 = (new Coord(4, 1));
        Coord b3 = (new Coord(3, 2));
        Coord c3 = (new Coord(2, 3));
        Coord d3 = (new Coord(3, 4));

        if (sok_Black_egy_num(a3, b3, c3, d3)) {
            map.set(findNumCoordOf4(a3, b3, c3, d3), goodNumber(findNumCoordOf4(a3, b3, c3, d3)));
        }

        Coord a4 = (new Coord(1, 0));
        Coord b4 = (new Coord(2, 1));
        Coord c4 = (new Coord(1, 2));
        Coord d4 = (new Coord(0, 3));

        if (sok_Black_egy_num(a4, b4, c4, d4)) {
            map.set(findNumCoordOf4(a4, b4, c4, d4), goodNumber(findNumCoordOf4(a4, b4, c4, d4)));
        }

        Coord a5 = (new Coord(1, 4));
        Coord b5 = (new Coord(2, 3));
        Coord c5 = (new Coord(3, 2));
        Coord d5 = (new Coord(4, 3));

        if (sok_Black_egy_num(a5, b5, c5, d5)) {
            map.set(findNumCoordOf4(a5, b5, c5, d5), goodNumber(findNumCoordOf4(a5, b5, c5, d5)));
        }


        //3 diagonal + 2

        Coord a7 = new Coord(1, 0);
        Coord b7 = new Coord(2, 1);
        Coord c7 = new Coord(3, 2);
        Coord d7 = new Coord(2, 3);
        Coord e7 = new Coord(1, 4);
        if (sok_Black_egy_num(a7, b7, c7, d7, e7)) {
            map.set(findNumCoordOf5(a7, b7, c7, d7, e7), goodNumber(findNumCoordOf5(a7, b7, c7, d7, e7)));
        }

        Coord a6 = new Coord(3, 0);
        Coord b6 = new Coord(2, 1);
        Coord c6 = new Coord(1, 2);
        Coord d6 = new Coord(2, 3);
        Coord e6 = new Coord(3, 4);
        if (sok_Black_egy_num(a6, b6, c6, d6, e6)) {
            map.set(findNumCoordOf5(a6, b6, c6, d6, e6), goodNumber(findNumCoordOf5(a6, b6, c6, d6, e6)));
        }

        Coord a8 = new Coord(0, 1);
        Coord b8 = new Coord(1, 2);
        Coord c8 = new Coord(2, 3);
        Coord d8 = new Coord(3, 2);
        Coord e8 = new Coord(4, 1);
        if (sok_Black_egy_num(a8, b8, c8, d8, e8)) {
            map.set(findNumCoordOf5(a8, b8, c8, d8, e8), goodNumber(findNumCoordOf5(a8, b8, c8, d8, e8)));
        }

        Coord a9 = new Coord(0, 3);
        Coord b9 = new Coord(1, 2);
        Coord c9 = new Coord(2, 1);
        Coord d9 = new Coord(3, 2);
        Coord e9 = new Coord(4, 3);
        if (sok_Black_egy_num(a9, b9, c9, d9, e9)) {
            map.set(findNumCoordOf5(a9, b9, c9, d9, e9), goodNumber(findNumCoordOf5(a9, b9, c9, d9, e9)));
        }


    }

    private Coord findNumCoordOf4(Coord a, Coord b, Coord c, Coord d) {
        if (isNum(a))
            return a;
        if (isNum(b))
            return b;
        if (isNum(c))
            return c;
        if (isNum(d))
            return d;
        return null;
    }

    private Coord findNumCoordOf5(Coord a, Coord b, Coord c, Coord d, Coord e) {
        if (isNum(a))
            return a;
        if (isNum(b))
            return b;
        if (isNum(c))
            return c;
        if (isNum(d))
            return d;
        if (isNum(e))
            return e;
        return null;
    }

    private boolean sok_Black_egy_num(Coord a, Coord b, Coord c, Coord d) {
        if (map.get(a) == Box.BLACK && map.get(b) == Box.BLACK && map.get(c) == Box.BLACK && isNum(d))
            return true;
        if (map.get(a) == Box.BLACK && map.get(b) == Box.BLACK && map.get(d) == Box.BLACK && isNum(c))
            return true;
        if (map.get(a) == Box.BLACK && map.get(d) == Box.BLACK && map.get(c) == Box.BLACK && isNum(b))
            return true;
        if (map.get(d) == Box.BLACK && map.get(b) == Box.BLACK && map.get(c) == Box.BLACK && isNum(a))
            return true;

        return false;
    }

    private boolean sok_Black_egy_num(Coord a, Coord b, Coord c, Coord d, Coord e) {
        if (map.get(a) == Box.BLACK && map.get(b) == Box.BLACK && map.get(c) == Box.BLACK && map.get(d) == Box.BLACK && isNum(e))
            return true;
        if (map.get(a) == Box.BLACK && map.get(b) == Box.BLACK && map.get(c) == Box.BLACK && map.get(e) == Box.BLACK && isNum(d))
            return true;
        if (map.get(a) == Box.BLACK && map.get(b) == Box.BLACK && map.get(e) == Box.BLACK && map.get(d) == Box.BLACK && isNum(c))
            return true;
        if (map.get(a) == Box.BLACK && map.get(e) == Box.BLACK && map.get(c) == Box.BLACK && map.get(d) == Box.BLACK && isNum(b))
            return true;
        if (map.get(e) == Box.BLACK && map.get(b) == Box.BLACK && map.get(c) == Box.BLACK && map.get(d) == Box.BLACK && isNum(a))
            return true;

        return false;
    }

    public void checkStatus() {
        if (good())
            state = State.SOLVED;
        else
            state = State.UNSOLVED;
    }

    public void trySolve() {

        matrixcpy(tmp, map);
        //try with 1 black
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (isNum(new Coord(i, j))) {
                    map.set(new Coord(i, j), goodNumber(new Coord(i, j)));
                    do {
                        matrixcpy(last, map);
                        mainAlgoritm();
                        //System.out.println("do while" + i + " " + j);
                    }
                    while (!matrixEquals(last, map));

                    if (good())
                        return;
                    matrixcpy(map, tmp);
                }
            }
        }
        System.out.println("minimum 2 black kell");


    }

    private boolean matrixEquals(Matrix a, Matrix b) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (a.get(new Coord(i, j)) != b.get(new Coord(i, j)))
                    return false;
            }
        }
        return true;
    }

    public void solve_tricky_corner_problem() {
        if (isNum(new Coord(4, 0)) && isNum(new Coord(3, 0)) && isNum(new Coord(4, 1)))
            if (hasSameInRow(new Coord(4, 0)) && hasSameInColumn(new Coord(4, 0)))
                if (hasSameInRow(new Coord(4, 1)) && hasSameInColumn(new Coord(3, 0))) {
                    map.set(new Coord(3, 0), goodNumber(new Coord(3, 0)));
                    map.set(new Coord(4, 1), goodNumber(new Coord(4, 1)));
                }


        if (isNum(new Coord(0, 0)) && isNum(new Coord(1, 0)) && isNum(new Coord(0, 1)))
            if (hasSameInRow(new Coord(0, 0)) && hasSameInColumn(new Coord(0, 0)))
                if (hasSameInRow(new Coord(0, 1)) && hasSameInColumn(new Coord(1, 0))) {
                    map.set(new Coord(1, 0), goodNumber(new Coord(1, 0)));
                    map.set(new Coord(0, 1), goodNumber(new Coord(0, 1)));
                }


        if (isNum(new Coord(0, 4)) && isNum(new Coord(0, 3)) && isNum(new Coord(1, 4)))
            if (hasSameInRow(new Coord(0, 4)) && hasSameInColumn(new Coord(0, 4)))
                if (hasSameInRow(new Coord(0, 3)) && hasSameInColumn(new Coord(1, 4))) {
                    map.set(new Coord(0, 3), goodNumber(new Coord(0, 3)));
                    map.set(new Coord(1, 4), goodNumber(new Coord(1, 4)));
                }


        if (isNum(new Coord(4, 4)) && isNum(new Coord(3, 4)) && isNum(new Coord(4, 3)))
            if (hasSameInRow(new Coord(4, 4)) && hasSameInColumn(new Coord(4, 4)))
                if (hasSameInRow(new Coord(4, 3)) && hasSameInColumn(new Coord(3, 4))) {
                    map.set(new Coord(3, 4), goodNumber(new Coord(3, 4)));
                    map.set(new Coord(4, 3), goodNumber(new Coord(4, 3)));
                }


    }

    private Box circleToNum(Coord coord) {
        if (map.get(coord) == Box.C_NUM1)
            return Box.NUM1;
        if (map.get(coord) == Box.C_NUM2)
            return Box.NUM2;
        if (map.get(coord) == Box.C_NUM3)
            return Box.NUM3;
        if (map.get(coord) == Box.C_NUM4)
            return Box.NUM4;
        if (map.get(coord) == Box.C_NUM5)
            return Box.NUM5;
        return null;
    }


    public void matrixcpy(Matrix tmp, Matrix map) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                tmp.set(new Coord(i, j), map.get(new Coord(i, j)));
            }
        }
    }


    private boolean isCircle(Coord coord) {
        if (map.get(coord) == Box.C_NUM1 || map.get(coord) == Box.C_NUM2 || map.get(coord) == Box.C_NUM3
                || map.get(coord) == Box.C_NUM4 || map.get(coord) == Box.C_NUM5)
            return true;
        else return false;
    }


    private boolean isNum(Coord coord) {
        if (map.get(coord) == Box.NUM1 || map.get(coord) == Box.NUM2 || map.get(coord) == Box.NUM3
                || map.get(coord) == Box.NUM4 || map.get(coord) == Box.NUM5)
            return true;
        else
            return false;
    }


    private Box goodNumber(Coord coord) {
        if (map.get(coord) == Box.NUM1)
            return Box.C_NUM1;
        if (map.get(coord) == Box.NUM2)
            return Box.C_NUM2;
        if (map.get(coord) == Box.NUM3)
            return Box.C_NUM3;
        if (map.get(coord) == Box.NUM4)
            return Box.C_NUM4;
        if (map.get(coord) == Box.NUM5)
            return Box.C_NUM5;
        return null;
    }

    public boolean good() {
        if (hasNum())
            return false;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Coord coord = new Coord(i, j);
                if (isCircle(coord))
                    if (hasSameInColumn(coord) || hasSameInRow(coord))
                        return false;

                if (map.get(coord) == Box.BLACK)
                    if (!canIBlackit(coord))
                        return false;
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Coord coord = new Coord(i, j);
                for (int k = 0; k < 5; k++) {
                    for (int l = 0; l < 5; l++) {
                        if (i == k && j == l)
                            continue;
                        Coord coord1 = new Coord(k, l);
                        if (isCircle(coord) && isCircle(coord1))
                            if (!hasRoad(coord, coord1))
                                return false;
                    }
                }
            }
        }

        return true;
    }

    public boolean hasNum() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (isNum(new Coord(i, j)))
                    return true;
            }
        }
        return false;
    }

    private boolean canIBlackit(Coord coord) {
        if (Ranges.inRange(new Coord(coord.x + 1, coord.y)))
            if (map.get(new Coord(coord.x + 1, coord.y)) == Box.BLACK)
                return false;

        if (Ranges.inRange(new Coord(coord.x - 1, coord.y)))
            if (map.get(new Coord(coord.x - 1, coord.y)) == Box.BLACK)
                return false;

        if (Ranges.inRange(new Coord(coord.x, coord.y + 1)))
            if (map.get(new Coord(coord.x, coord.y + 1)) == Box.BLACK)
                return false;

        if (Ranges.inRange(new Coord(coord.x, coord.y - 1)))
            if (map.get(new Coord(coord.x, coord.y - 1)) == Box.BLACK)
                return false;

        return true;
    }

    private boolean hasSameInColumn(Coord coord) {
        for (int i = -4; i < 5; i++) {
            if (i == 0)
                continue;
            if (Ranges.inRange(new Coord(coord.x + i, coord.y)))
                if (map.get(coord) == map.get(new Coord(coord.x + i, coord.y)))
                    return true;
        }

        return false;
    }

    private Boolean hasSameInRow(Coord coord) {
        for (int i = -4; i < 5; i++) {
            if (i == 0)
                continue;
            if (Ranges.inRange(new Coord(coord.x, coord.y + i)))
                if (map.get(coord) == map.get(new Coord(coord.x, coord.y + i)))
                    return true;
        }

        return false;
    }

    private boolean hasRoad(Coord coord, Coord coord1) {
        ArrayList<Coord> list = new ArrayList<>();

        list.add(coord);
        int tmp = 0;

        while (tmp != list.size()) {
            tmp = list.size();
            for (Coord item :
                    list) {
                if (Ranges.inRange(item) && isCircle(item))
                    if (Ranges.inRange(new Coord(item.x + 1, item.y)) && isCircle(new Coord(item.x + 1, item.y))) {
                        if (!list.contains(new Coord(item.x + 1, item.y))) {
                            list.add(new Coord(item.x + 1, item.y));
                            break;
                        }

                    }

                if (Ranges.inRange(item) && isCircle(item))
                    if (Ranges.inRange(new Coord(item.x - 1, item.y)) && isCircle(new Coord(item.x - 1, item.y))) {
                        if (!list.contains(new Coord(item.x - 1, item.y))) {
                            list.add(new Coord(item.x - 1, item.y));
                            break;
                        }

                    }

                if (Ranges.inRange(item) && isCircle(item))
                    if (Ranges.inRange(new Coord(item.x, item.y + 1)) && isCircle(new Coord(item.x, item.y + 1))) {
                        if (!list.contains(new Coord(item.x, item.y + 1))) {
                            list.add(new Coord(item.x, item.y + 1));
                            break;
                        }
                    }

                if (Ranges.inRange(item) && isCircle(item))
                    if (Ranges.inRange(new Coord(item.x, item.y - 1)) && isCircle(new Coord(item.x, item.y - 1))) {
                        if (!list.contains(new Coord(item.x, item.y - 1))) {
                            list.add(new Coord(item.x, item.y - 1));
                            break;
                        }
                    }


                if (list.contains(coord1))
                    return true;
            }

        }


        return false;
    }

    public void mainAlgoritm() {
        findAllPosibleCircle();
        solve_singlesep();//... num1 num2 num1 ... => ...num1 c_num2 num1 ...

        solver_op_circle();

        solve_doubles();//black solo if has doubles
        solve_corners();//L

        solve_triangle();
        solve_big_triangle();
        solve_diagonal();
        solve_big_figure();
        solver_op_blacken();

        solve_tricky_corner_problem();
    }
}
