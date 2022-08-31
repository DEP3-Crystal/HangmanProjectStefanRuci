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
    private String path;

    public Words(String path) throws IOException {
        setWords(path);
    }

    void setWords(String path) throws IOException {
        try {
            Path p = Paths.get(path);
            Stream<String> lines = Files.lines(p);
            words = lines.filter(e -> e.length() > 5).collect(Collectors.toList());
        }catch (InvalidPathException e){
            e.printStackTrace();
        }
    }


}