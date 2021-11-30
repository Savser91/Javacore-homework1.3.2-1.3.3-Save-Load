package com.company.gameProgress;

import java.io.*;

public class GameProgressOperations {
    public static void saveGame(String path, GameProgress progress) {
        try (ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(path))) {
            obj.writeObject(progress);
            System.out.println("Сохранено: " + path);
        } catch (Exception exception) {
            System.out.println("Ошибка сохранения " + exception);
        }
    }

    public static void deleteFiles(String path) {
        File file = new File(path);
        if (file.delete())
            System.out.println("Файл сохранения " + path + " удален");
        else
            System.out.println("Не удалось удалить файл сохранения " + path);
    }

    public static GameProgress openProgress(String path) {
        try (ObjectInputStream obj = new ObjectInputStream(new FileInputStream(path))) {
            return (GameProgress) obj.readObject();
        } catch (Exception exception) {
            System.out.println("Ошибка открытия файла " + exception);
        }
        return null;
    }
}
