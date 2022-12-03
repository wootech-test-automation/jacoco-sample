package pairmatching;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CrewNameReader {


    public List<String> readCrewNames(String path){
        File crewNameFile = new File(path);
        Scanner scanner = null;
        try {
            scanner = new Scanner(crewNameFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        List<String> crewNames = new ArrayList<>();
        while (scanner.hasNextLine()) {
            crewNames.add(scanner.nextLine());
        }
        return crewNames;
    }
}
