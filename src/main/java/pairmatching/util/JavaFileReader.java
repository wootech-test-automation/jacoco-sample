package pairmatching.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JavaFileReader {
    public static List<String> getLinesFromFile(String path) {
        List<String> lines = new ArrayList<>();
        try {
            File file = getFile(path);
            lines = getLines(file);
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
        return lines;
    }

    private static List<String> getLines(File file) throws IOException {
        List<String> lines = new ArrayList<>();
        // 입력 스트림 및 버퍼 생성
        FileReader filereader = new FileReader(file);
        BufferedReader bufReader = new BufferedReader(filereader);
        // 파일 읽기
        String line = "";
        while ((line = bufReader.readLine()) != null) {
            lines.add(line);
        }
        bufReader.close();

        return lines;
    }

    private static File getFile(String path) throws FileNotFoundException {
        //파일 객체 생성
        return new File(path);
    }
}
