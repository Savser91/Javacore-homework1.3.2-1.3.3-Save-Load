package com.company.zip;

import java.io.*;
import java.util.zip.*;

public class Zip {
    public static void zipFiles(String zipPath, String filePath) {
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipPath));
             FileInputStream fis = new FileInputStream(filePath)) {
            ZipEntry entry = new ZipEntry(new File(filePath).getName());
            zos.putNextEntry(entry);
            byte[] array = new byte[fis.available()];
            fis.read(array);
            zos.write(array);
            zos.closeEntry();
            System.out.println("Файл " + filePath + " добавлен а архив");
        }
        catch (Exception exception) {
            System.out.println("Ошибка архивирования " + exception);
        }
    }

    public static void openZip(String zipPath, String path) {
        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(zipPath))) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                FileOutputStream fos = new FileOutputStream(path);
                int value;
                while ((value = zis.read()) != -1) {
                    fos.write(value);
                }
                fos.flush();
                zis.closeEntry();
                fos.close();
            }
        } catch (Exception exception) {
            System.out.println("Ошибка разорхивирования файла " + exception);
        }
    }
}
