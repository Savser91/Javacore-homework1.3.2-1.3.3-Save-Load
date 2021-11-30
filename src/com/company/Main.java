package com.company;

import com.company.gameProgress.*;
import com.company.zip.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        String path = "D:/SERZH/Programming/Games/savegames/gameProgress_";
        List<GameProgress> list = List.of(new GameProgress[]{
                new GameProgress(80, 3, 5, 11.1),
                new GameProgress(10, 1, 3, 3.4),
                new GameProgress(90, 5, 6, 13.0)
        });

        // Задача №2 В цикле архивируем файлы и удаляем исходники
        for (int i = 0; i < list.size(); i++) {
            String gpPath = path + i + ".pgs";
            String zipPath = path + i + ".zip";
            GameProgressOperations.saveGame(gpPath, list.get(i));
            Zip.zipFiles(zipPath, gpPath);
            GameProgressOperations.deleteFiles(gpPath);
        }

        // Задача №3 разархивируем файлы и выводим в консоль прогресс
        for (int i = 0; i < list.size(); i++) {
            String gpPath = path + i + ".pgs";
            String zipPath = path + i + ".zip";
            Zip.openZip(zipPath, gpPath);
            System.out.println(GameProgressOperations.openProgress(gpPath).toString());
        }
        // В консоли после вывода:
        //GameProgress{health=80, weapons=3, lvl=5, distance=11.1}
        //GameProgress{health=10, weapons=1, lvl=3, distance=3.4}
        //GameProgress{health=90, weapons=5, lvl=6, distance=13.0}
    }
}
