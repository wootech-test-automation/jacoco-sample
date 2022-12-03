package pairmatching;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CrewNameReader {

    public List<String> readBackendCrewNames() throws IOException {
        File file = new File(
                "C:\\Users\\A\\Desktop\\Spring\\java-pairmatching-precourse-practice\\src\\main\\resources\\backend-crew.md");
        FileReader fileReader = new FileReader(file);
        Scanner scanner = new Scanner(file);
        List<String> crewNames = new ArrayList<>();
        while (scanner.hasNextLine()) {
            crewNames.add(scanner.nextLine());
        }
        return crewNames;
    }
}
