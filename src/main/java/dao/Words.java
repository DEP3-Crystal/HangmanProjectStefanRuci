package dao;

import javax.swing.plaf.PanelUI;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Words {
    public List<String> words = new ArrayList<>();


    public Words() throws IOException {
        try {
            Path p = Paths.get("src/main/resources/words.txt");
            Stream<String> lines = Files.lines(p);
            words = lines.filter(e -> e.length() > 5).collect(Collectors.toList());
        } catch (InvalidPathException e) {
            e.printStackTrace();
        }
    }
}