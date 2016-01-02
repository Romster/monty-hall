package ru.romster;

/**
 * Created by r0m5t3r on 1/1/16.
 */
public class Stage {
    final boolean[] doorStatus = new boolean[3];
    final int prizeDoor;
    int openedDoor = -1;

    public Stage(int prizeDoor) {
        if (prizeDoor < 0 || prizeDoor > 2) {
            throw new IllegalArgumentException("There is only 3 doors: from 0 to 2");
        }
        this.prizeDoor = prizeDoor;
    }

    public int getPrizeDoor() {
        return prizeDoor;
    }

    /**
     * открываем дверь без приза, отличную от выбранной в первый раз.
     *
     * @param exceptDoor
     * @return
     */
    public int openEmptyDoor(int exceptDoor) {
        if (prizeDoor == exceptDoor) {
            openedDoor = UtilsBase3.randomExcept(exceptDoor);
        } else {
            openedDoor = UtilsBase3.getMissingValue(exceptDoor, prizeDoor);
        }
        return openedDoor;
    }

}
