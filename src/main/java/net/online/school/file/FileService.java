package net.online.school.file;

import net.online.school.colors.Color;
import net.online.school.colors.ColorException;
import net.online.school.figures.v3.Rectangle;
import net.online.school.ttschool.Trainee;
import net.online.school.ttschool.TrainingException;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.google.gson.Gson;

import java.io.*;


public class FileService {
    public static void writeByteArrayToBinaryFile(String fileName, byte[] array) throws IOException {
        try (FileOutputStream fileWrite = new FileOutputStream(fileName)) {
            fileWrite.write(array);
        }
    }

    public static void writeByteArrayToBinaryFile(File file, byte[] array) throws IOException {
        writeByteArrayToBinaryFile(file.getPath(), array);
    }

    public static byte[] readByteArrayFromBinaryFile(String fileName) throws IOException {
        try (FileInputStream fileRead = new FileInputStream(fileName)) {
            byte[] array;
            array = new byte[fileRead.available()];
            fileRead.read(array);
            return array;
        }
    }

    public static byte[] readByteArrayFromBinaryFile(File file) throws IOException {
        return readByteArrayFromBinaryFile(file.getPath());
    }

    public static byte[] writeAndReadByteArrayUsingByteStream(byte[] array) throws IOException {
        byte[] fileArray;
        try (ByteArrayOutputStream fileWrite = new ByteArrayOutputStream()) {
            fileWrite.write(array);
            fileArray = fileWrite.toByteArray();
        }
        try (ByteArrayInputStream fileRead = new ByteArrayInputStream(fileArray)) {
            byte[] result;
            if (fileRead.available() % 2 == 0) {
                result = new byte[fileRead.available() / 2];
            } else {
                result = new byte[fileRead.available() / 2 + 1];
            }
            int count = 0;
            while (fileRead.read(result, count, 1) != -1 && count < fileRead.available()) {
                count++;
                fileRead.skip(1);
            }
            return result;
        }
    }

    public static void writeByteArrayToBinaryFileBuffered(String fileName, byte[] array) throws IOException {
        try (BufferedOutputStream fileWrite = new BufferedOutputStream(new FileOutputStream(fileName))) {
            fileWrite.write(array);
        }
    }

    public static void writeByteArrayToBinaryFileBuffered(File file, byte[] array) throws IOException {
        writeByteArrayToBinaryFileBuffered(file.getPath(), array);
    }

    public static byte[] readByteArrayFromBinaryFileBuffered(String fileName) throws IOException {
        try (BufferedInputStream fileRead = new BufferedInputStream(new FileInputStream(fileName))) {
            byte[] array;
            array = new byte[fileRead.available()];
            fileRead.read(array);
            return array;
        }
    }

    public static byte[] readByteArrayFromBinaryFileBuffered(File file) throws IOException {
        return readByteArrayFromBinaryFileBuffered(file.getPath());
    }

    public static void writeRectangleToBinaryFile(File file, Rectangle rect) throws IOException {
        try (DataOutputStream fileWrite = new DataOutputStream(new FileOutputStream(file))) {
            fileWrite.writeInt(rect.getTopLeft().getX());
            fileWrite.writeInt(rect.getTopLeft().getY());
            fileWrite.writeInt(rect.getBottomRight().getX());
            fileWrite.writeInt(rect.getBottomRight().getY());
        }
    }

    public static Rectangle readRectangleFromBinaryFile(File file) throws IOException, ColorException {
        try (DataInputStream fileRead = new DataInputStream(new FileInputStream(file))) {
            return new Rectangle(fileRead.readInt(), fileRead.readInt(), fileRead.readInt(), fileRead.readInt(), Color.RED);
        }
    }

    public static void writeRectangleArrayToBinaryFile(File file, Rectangle[] rects) throws IOException {
        try (DataOutputStream rectsWrite = new DataOutputStream((new FileOutputStream(file)))) {
            for (Rectangle rect : rects) {
                rectsWrite.writeInt(rect.getTopLeft().getX());
                rectsWrite.writeInt(rect.getTopLeft().getY());
                rectsWrite.writeInt(rect.getBottomRight().getX());
                rectsWrite.writeInt(rect.getBottomRight().getY());
            }
        }
    }

    public static Rectangle[] readRectangleArrayFromBinaryFileReverse(File file) throws IOException, ColorException {
        Rectangle[] rects;
        try (DataInputStream rectRead = new DataInputStream((new FileInputStream(file)))) {
            rects = new Rectangle[rectRead.available() / 16];
            for (int i = rects.length - 1; i >= 0; i--) {
                rects[i] = new Rectangle(rectRead.readInt(), rectRead.readInt(), rectRead.readInt(), rectRead.readInt(), Color.RED);
            }
        }
        return rects;
    }

    public static void writeRectangleToTextFileOneLine(File file, Rectangle rect) throws IOException {
        try (FileWriter fileWrite = new FileWriter(file)) {
            fileWrite.write(rect.getTopLeft().getX() + " " + rect.getTopLeft().getY() + " "
                    + rect.getBottomRight().getX() + " " + rect.getBottomRight().getY());
        }
    }

    public static Rectangle readRectangleFromTextFileOneLine(File file) throws IOException, ColorException {
        try (BufferedReader fileRead = new BufferedReader(new FileReader(file))) {
            String[] array = fileRead.readLine().split("[ ]");
            return new Rectangle(Integer.parseInt(array[0]), Integer.parseInt(array[1]), Integer.parseInt(array[2]),
                    Integer.parseInt(array[3]), Color.RED);
        }

    }

    public static void writeRectangleToTextFileFourLines(File file, Rectangle rect) throws IOException {
        try (BufferedWriter fileWrite = new BufferedWriter(new FileWriter(file))) {
            fileWrite.write(Integer.toString(rect.getTopLeft().getX()));
            fileWrite.newLine();
            fileWrite.write(Integer.toString(rect.getTopLeft().getY()));
            fileWrite.newLine();
            fileWrite.write(Integer.toString(rect.getBottomRight().getX()));
            fileWrite.newLine();
            fileWrite.write(Integer.toString(rect.getBottomRight().getY()));
        }
    }

    public static Rectangle readRectangleFromTextFileFourLines(File file) throws IOException, ColorException {
        try (BufferedReader fileRead = new BufferedReader(new FileReader(file))) {
            return new Rectangle(Integer.parseInt(fileRead.readLine()), Integer.parseInt(fileRead.readLine()),
                    Integer.parseInt(fileRead.readLine()), Integer.parseInt(fileRead.readLine()), Color.RED);
        }
    }

    public static void writeTraineeToTextFileOneLine(File file, Trainee trainee) throws IOException {
        try (OutputStreamWriter fileWrite = new OutputStreamWriter(new FileOutputStream(file), "UTF-8")) {
            fileWrite.write(trainee.getFirstName() + " " + trainee.getLastName() + " " + trainee.getRating());
        }
    }

    public static Trainee readTraineeFromTextFileOneLine(File file) throws IOException, TrainingException {
        try (BufferedReader fileRead = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"))) {
            String[] array = fileRead.readLine().split("[ ]");
            return new Trainee(array[0], array[1], Integer.parseInt(array[2]));
        }

    }

    public static void writeTraineeToTextFileThreeLines(File file, Trainee trainee) throws IOException {
        try (BufferedWriter fileWrite = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"))) {
            fileWrite.write(trainee.getFirstName());
            fileWrite.newLine();
            fileWrite.write(trainee.getLastName());
            fileWrite.newLine();
            fileWrite.write(Integer.toString(trainee.getRating()));
        }
    }

    public static Trainee readTraineeFromTextFileThreeLines(File file) throws IOException, TrainingException {
        try (BufferedReader fileRead = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"))) {
            return new Trainee(fileRead.readLine(), fileRead.readLine(), Integer.parseInt(fileRead.readLine()));
        }

    }

    public static void serializeTraineeToBinaryFile(File file, Trainee trainee) throws IOException {
        try (ObjectOutputStream objWrite = new ObjectOutputStream(new FileOutputStream(file))) {
            objWrite.writeObject(trainee);
        }
    }

    public static Trainee deserializeTraineeFromBinaryFile(File file) throws IOException, ClassNotFoundException {
        Trainee trainee;
        try (ObjectInputStream objRead = new ObjectInputStream(new FileInputStream(file))) {
            trainee = (Trainee) objRead.readObject();
        }
        return trainee;
    }

    public static String serializeTraineeToJsonString(Trainee trainee) {
        Gson gson = new Gson();
        return gson.toJson(trainee);
    }

    public static Trainee deserializeTraineeFromJsonString(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Trainee.class);
    }

    public static void serializeTraineeToJsonFile(File file, Trainee trainee) throws IOException {
        Gson gson = new Gson();
        try (BufferedWriter gsonWrite = new BufferedWriter(new FileWriter(file))) {
            gson.toJson(trainee, gsonWrite);
        }
    }

    public static Trainee deserializeTraineeFromJsonFile(File file) throws IOException {
        try (BufferedReader gsonRead = new BufferedReader(new FileReader(file))) {
            Gson gson = new Gson();
            return gson.fromJson(gsonRead, Trainee.class);
        }
    }
}
