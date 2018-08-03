package com.epam.se02.enams;

public enum Day {
    SUNDAY,
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY;

    public boolean isWeekend() {
        switch (this) {
            case SUNDAY:
            case SATURDAY:
                return true;
            default:
                return false;
        }
    }

    public static void main(String... __) {
        System.out.println(MONDAY + " isWeekEnd(): " + MONDAY.isWeekend() );
    }
}
