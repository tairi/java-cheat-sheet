package com.javarush.task.task31.task3101;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.EnumSet;
import java.util.Map;
import java.util.TreeMap;

/* 
Проход по дереву файлов
*/

public class Solution {
    public static void main(String[] args) {
        String path = args[0];
        String resultFileAbsolutePath = args[1];

        try {
            File resultFile = new File(resultFileAbsolutePath);
            File dest = new File(resultFile.getParentFile() + "/allFilesContent.txt");
            FileUtils.renameFile(resultFile, dest); //переименовали файл

            Map<String, byte[]> fileTree = getFileTree(path);
            try (FileOutputStream fileOutputStream = new FileOutputStream(dest)){
                for (byte [] bytes : fileTree.values()) {
                    fileOutputStream.write(bytes);
                    fileOutputStream.write("\n".getBytes());
                }
            }
        } catch (IOException i){

        }
    }
    public static Map<String, byte[]> getFileTree(String root) throws IOException {
        Map<String, byte[]> result = new TreeMap<>();
        EnumSet<FileVisitOption> options = EnumSet.of(FileVisitOption.FOLLOW_LINKS); //Она идет обязательной, но у нее всего один вариант выбора. Но без нее не получается указать глубину обхода директорий, а это необходимо.
        Files.walkFileTree(Paths.get(root), options, 20, new GetFiles(result)); //непонятная строка
        return result;
    }

    private static class GetFiles extends SimpleFileVisitor<Path> {
        private Map<String, byte[]> result;


        public GetFiles(Map<String, byte[]> result) {
            this.result = result;
        }

        public FileVisitResult visitFile(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
            File file = path.toFile(); //перевели путь в формат файл
            if (file.isFile()) { //если файл = файл
                if (file.length()<=50) { //если его размер <=50
                    result.put(path.getFileName().toString(), Files.readAllBytes(path)); //добавить в результирующий список
                }
            }
//Files.readAllBytes(path) - размер файла в байтах
            return super.visitFile(path, basicFileAttributes);
        }
    }
}

/*1. На вход метода main() подаются два параметра.
Первый - path - путь к директории, второй - resultFileAbsolutePath - имя (полный путь) существующего файла,
который будет содержать результат.
2. Переименовать resultFileAbsolutePath в allFilesContent.txt (используй метод FileUtils.renameFile(), и,
если понадобится, FileUtils.isExist()).
3. Для каждого файла в директории path и в ее всех вложенных поддиректориях выполнить следующее:
Если у файла длина в байтах НЕ больше 50, то для всех таких файлов:
3.1. Отсортировать их по имени файла в возрастающем порядке, путь не учитывать при сортировке.
3.2. В allFilesContent.txt последовательно записать содержимое всех файлов из п. 3.1.
После каждого тела файла записать "\n".
Все файлы имеют расширение txt.
В качестве разделителя пути используй "/".
Для создания файлов используй конструктор File(String pathname).


Требования:
1. Файл, который приходит вторым параметром в main, должен быть переименован в allFilesContent.txt.
2. Нужно создать поток для записи в переименованный файл.
3. Содержимое всех файлов, размер которых не превышает 50 байт, должно быть записано в файл
allFilesContent.txt в отсортированном по имени файла порядке.
4. Поток для записи в файл нужно закрыть.
5. Не используй статические переменные.*/

/*Прошел достаточно быстро. Опишу алгоритм с учетом проверок валидатора:
1. Для 2го параметра main создаем отдельные переменные File для поступившего параметра и
File для "allFilesContent.txt" при создании нужно добавить весь путь
(это обязательно валидатор просит именно объекты File)
2. Переименовываем (можно добавить проверку isExist и удалять файл перед переименованием,
 но валик принимает и без этого. У меня стояла проверка на то, что если файл существует,
  то тогда не переименовываем, но в таком виде валик не принимает)
3. Создаем класс от  SimpleFileVisitor (если не понимаете о чем речь смотрите в самом конце
ссылку https://javarush.ru/groups/posts/2275-files-path и можно сначала решить третью задачу):
3.1. в нем объявляем TreeMap<String, String> (Имя файла и содержимое + "\n")
3.2. Реализуем проверку размера:
byte[] content = Files.readAllBytes(file);
int size = content.length;
3.3. Добавляем информацию в Map если подходит
4. в main после переименования используя п. 3. создаем объект SimpleFileVisitor и реализуем
метод Files.walkFileTree с 1 параметром main и этим объектом
5. Создаем объем FileWriter через try с ресурсами и добавляем  в него Value из Map*/