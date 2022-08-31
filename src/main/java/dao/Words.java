package dao;

import javax.swing.plaf.PanelUI;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Words {
    public static List<String> words = new ArrayList<>();

    public Words() throws IOException {
        setWords();
    }

    void setWords() throws IOException {
        Stream<String> lines = Files.lines(Paths.get("src/main/resources/words.txt"));
        words = lines.filter(e -> e.length() > 5).collect(Collectors.toList());
    }


}