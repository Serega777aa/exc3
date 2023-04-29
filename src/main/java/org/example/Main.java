package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] data = input();
        User user = new User();
        parsData(data, user);
        System.out.println(user);
        writeFile(user);

    }

    public static void writeFile(User user) {
        try {
            File file = new File(user.getLastName());
            if (!file.exists())
                file.createNewFile();
            FileWriter fw = new FileWriter(file, true);
            fw.write(user.toString());
            fw.append('\n');
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean valideDate(String date) {
        if (date.matches("\\d{1,2}\\.\\d{1,2}\\.\\d{4}")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean valideFio(String name) {
        if (name.chars()
                .mapToObj(Character.UnicodeBlock::of)
                .anyMatch(b -> b.equals(Character.UnicodeBlock.CYRILLIC))) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean validePhone(String phone) {
        if (phone.matches("[0-9]+")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean valideSex(String sex) {
        if (sex.equals("f") || sex.equals("m")) {
            return true;
        } else {
            return false;
        }
    }

    public static String[] input() {
        Scanner sc = new Scanner(System.in);
        int len = 0;
        while (true) {
            System.out.println(" Введите: Фамилия Имя Отчество датарождения номертелефона пол");
            String[] data = (sc.nextLine()).split(" ");
            len = data.length;
            if (len == 6) {
                return data;
            } else if (len > 6) {
                System.out.println(" Входных данных больше, чем должно быть!");
            } else {
                System.out.println(" Входных данных меньше, чем должно быть!");
            }
        }
    }

    public static void parsData(String[] data, User user) {
        if (valideFio(data[0])) {
            user.setLastName(data[0]);
        } else {
            try {
                throw new DataFormatException();
            } catch (DataFormatException e) {
                e.dataException(data[0] + " date format exception");
            }
        }

        if (valideFio(data[1])) {
            user.setFirstName(data[1]);
        } else {
            try {
                throw new DataFormatException();
            } catch (DataFormatException e) {
                e.dataException(data[1] + " date format exception");
            }
        }
        if (valideFio(data[2])) {
            user.setPatronymic(data[2]);
        } else {
            try {
                throw new DataFormatException();
            } catch (DataFormatException e) {
                e.dataException(data[2] + " date format exception");
            }
        }
        if (valideDate(data[3])) {
            user.setBirthDate(data[3]);
        } else {
            try {
                throw new DataFormatException();
            } catch (DataFormatException e) {
                e.dataException(data[3] + " date format exception");
            }
        }
        if (validePhone(data[4])) {
            user.setPhone(data[4]);
        } else {
            try {
                throw new DataFormatException();
            } catch (DataFormatException e) {
                e.dataException(data[4] + " date format exception");
            }
        }
        if (valideSex(data[5])) {
            user.setSex(data[5]);
        } else {
            try {
                throw new DataFormatException();
            } catch (DataFormatException e) {
                e.dataException(data[5] + " date format exception");
            }
        }
    }
}


