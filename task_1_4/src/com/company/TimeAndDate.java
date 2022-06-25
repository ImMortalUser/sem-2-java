package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimeAndDate {
    private int days = 1;
    private int seconds = 0;
    private static String dataFormat = "dmy";

    public TimeAndDate() {

    }

    public TimeAndDate(int days, int seconds) {
        this.days = days;
        this.seconds = seconds;
    }

    public void addDay(int n) {
        this.days += n;
    }

    public void addMonth(int n) {
        this.days += 30 * n;
    }

    public void addYear(int n) {
        this.days += n * 365;
    }


    public void compareDates(TimeAndDate data) {
        if (this.days > data.days) {
            System.out.print("Дата ");
            this.getData();
            System.out.print(" больше");
        } else if (this.days < data.days) {
            System.out.print("Дата ");
            data.getData();
            System.out.print(" больше");
        } else {
            System.out.print("Даты одинаковы");
        }
    }

    public static void changeDataFormat() {
        String s;
        System.out.println("Введите формат даты по шаблону *.*.*");
        Scanner scanner = new Scanner(System.in);
        s = scanner.nextLine();
        char first = s.charAt(0);
        char second = s.charAt(2);
        char third = s.charAt(4);
        dataFormat = Character.toString(first) + Character.toString(second) + Character.toString(third);
    }

    public static void changeDataFormat(String s) {
        char first = s.charAt(0);
        char second = s.charAt(2);
        char third = s.charAt(4);
        dataFormat = Character.toString(first) + Character.toString(second) + Character.toString(third);
    }

    public static int getDataFromString(String s) {
        String pattern = "(\\d{1,2})(\\W)(\\d{1,2})(\\W)(\\d{1,4})";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(s);
        if (m.find()) {
            System.out.println("Found value: " + m.group(0));
        }
        String temp = m.group(0);
        String cur = "";
        int cvat = 1;
        int cur1 = 0;
        int cur2 = 0;
        int cur3 = 0;
        for (int i = 0; i < temp.length(); i++) {
            if (temp.charAt(i) != '.' && cvat == 1) {
                cur += Character.toString(temp.charAt(i));
            } else if (temp.charAt(i) == '.' && cvat == 1) {
                cur1 = Integer.parseInt(cur);
                cvat += 1;
                cur = "";
            } else if (temp.charAt(i) != '.' && cvat == 2) {
                cur += Character.toString(temp.charAt(i));

            } else if (temp.charAt(i) == '.' && cvat == 2) {
                cur2 = Integer.parseInt(cur);
                cvat += 1;
                cur = "";
            } else if (cvat == 3) {
                cur += Character.toString(temp.charAt(i));
            }
        }
        cur3 = Integer.parseInt(cur);
        int days = cur1 + cur2 * 30 + cur3;
        return days;
    }

    public void getData() {
        int y = this.days / 365;
        int m = (this.days - y * 365) / 30;
        int d = this.days - y * 365 - m * 30;
        for (int i = 0; i < 3; i++) {
            if (dataFormat.charAt(i) == 'd') {
                if (d + 1 < 10) {
                    System.out.print("0" + (d + 1));
                } else {
                    System.out.print(d + 1);
                }
            } else if (dataFormat.charAt(i) == 'm') {
                if (m + 1 < 10) {
                    System.out.print("0" + (m + 1));
                } else {
                    System.out.print(m + 1);
                }
            } else if (dataFormat.charAt(i) == 'y') {
                if (y + 1 < 10) {
                    System.out.print("000" + (y + 1));
                } else if (y + 1 < 100) {
                    System.out.print("00" + (y + 1));
                } else if (y + 1 < 1000) {
                    System.out.print("0" + (y + 1));
                } else {
                    System.out.print(y + 1);
                }
            }
            if (i < 2) {
                System.out.print(".");
            }
        }
        System.out.println();
    }

    public static void getDataFormat() {
        System.out.println(dataFormat.charAt(0) + "." + dataFormat.charAt(1) + "." + dataFormat.charAt(2));
    }

    private void update() {
        if (this.seconds / 3600 >= 24) {
            this.seconds -= 3600 * 24;
            this.update();
        }
    }

    public void addHours(int n) {
        this.seconds += n * 3600;
        this.update();
    }

    public void addMinutes(int n) {
        this.seconds += n * 60;
        this.update();
    }

    public void addSeconds(int n) {
        this.seconds += n;
        this.update();
    }

    public void compareTime(TimeAndDate time) {
        if (this.seconds > time.seconds) {
            System.out.print("Время ");
            this.getTime();
            System.out.print(" больше, чем");
            time.getTime();
            System.out.println();
        } else if (this.seconds < time.seconds) {
            System.out.print("Время ");
            time.getTime();
            System.out.print(" больше, чем");
            this.getTime();
            System.out.println();
        } else {
            System.out.print("Время одинаково");
        }
    }

    public void getTime() {
        int h = this.seconds / 3600;
        int m = (this.seconds - h * 3600) / 60;
        int s = (this.seconds - h * 3600 - m * 60);
        /*
        System.out.println(m + "m");
        System.out.println(h + "h");
        System.out.println(s + "s");
        */
        if (h < 10) {
            System.out.print("0" + h);
        } else {
            System.out.print(h);
        }
        System.out.print(":");
        if (m < 10) {
            System.out.print("0" + m);
        } else {
            System.out.print(m);
        }
        System.out.print(":");
        if (s < 10) {
            System.out.print("0" + s);
        } else {
            System.out.print(s);
        }

        System.out.println();
    }


    public void getTimeAndDate() {
        int y = this.days / 365;
        int m = (this.days - y * 365) / 30;
        int d = this.days - y * 365 - m * 30;
        for (int i = 0; i < 3; i++) {
            if (dataFormat.charAt(i) == 'd') {
                if (d + 1 < 10) {
                    System.out.print("0" + (d + 1));
                } else {
                    System.out.print(d + 1);
                }
            } else if (dataFormat.charAt(i) == 'm') {
                if (m + 1 < 10) {
                    System.out.print("0" + (m + 1));
                } else {
                    System.out.print(m + 1);
                }
            } else if (dataFormat.charAt(i) == 'y') {
                if (y + 1 < 10) {
                    System.out.print("000" + (y + 1));
                } else if (y + 1 < 100) {
                    System.out.print("00" + (y + 1));
                } else if (y + 1 < 1000) {
                    System.out.print("0" + (y + 1));
                } else {
                    System.out.print(y + 1);
                }
            }
            if (i < 2) {
                System.out.print(".");
            }
        }
        System.out.print(" ");
        this.getTime();
        System.out.println();
    }

}
