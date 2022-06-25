package ru.vsu.cs.cource1;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public List moved;
    public SimpleLinkedListQueue queue;
    public Cell cellF;
    public List list;
    public int[][] doneMoves;

    public class Cell {
        int x;
        int y;

        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public Utils(int cellX, int cellY, int cellXF, int cellYF) {
        this.queue = new SimpleLinkedListQueue();
        this.queue.add(new Cell(cellX, cellY));
        this.cellF = new Cell(cellXF, cellYF);
        this.list = new ArrayList<>();
        this.moved = new ArrayList<>();
        this.doneMoves = new int[64][2];
    }



    public boolean calcF() throws Exception {
        boolean bool = calc();
        if (!bool) {
            calcF();
        } else {
            return true;
        }
        return false;
    }


    public boolean calc() throws Exception {
        Cell cell = (Cell) queue.element();
        int x = cell.x;
        int y = cell.y;
        this.list.add(queue.element());
        this.queue.remove();

        if (x + 2 < 8 && y + 1 < 8) {
            if (this.cellF.x == x + 2 && this.cellF.y == y + 1)
                return true;
            else {
                this.queue.add(new Cell(x + 2, y + 1));
            }

        }
        if (x + 1 < 8 && y + 2 < 8) {
            if (this.cellF.x == x + 1 && this.cellF.y == y + 2)
                return true;
            else
                this.queue.add(new Cell(x + 1, y + 2));
        }
        if (x - 2 >= 0 && y + 1 < 8) {
            if (this.cellF.x == x - 2 && this.cellF.y == y + 1)
                return true;
            else
                this.queue.add(new Cell(x - 2, y + 1));
        }
        if (x + 1 < 8 && y - 2 >= 0) {
            if (this.cellF.x == x + 1 && this.cellF.y == y - 2)
                return true;
            else
                this.queue.add(new Cell(x + 1, y - 2));
        }
        if (x + 2 < 8 && y - 1 >= 0) {
            if (this.cellF.x == x + 2 && this.cellF.y == y - 1)
                return true;
            else
                this.queue.add(new Cell(x + 2, y - 1));
        }
        if (x - 1 >= 0 && y + 2 < 8) {
            if (this.cellF.x == x - 1 && this.cellF.y == y + 2)
                return true;
            else
                this.queue.add(new Cell(x - 1, y + 2));
        }
        if (x - 2 >= 0 && y - 1 >= 0) {
            if (this.cellF.x == x - 2 && this.cellF.y == y - 1)
                return true;
            else
                this.queue.add(new Cell(x - 2, y - 1));
        }
        if (x - 1 >= 0 && y - 2 >= 0) {
            if (this.cellF.x == x - 1 && this.cellF.y == y - 2)
                return true;
            else
                this.queue.add(new Cell(x - 1, y - 2));
        }
        return false;
    }
}
