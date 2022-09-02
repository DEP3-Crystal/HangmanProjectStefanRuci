package dao;

import junit.framework.TestCase;
import org.junit.Assert;

import java.io.IOException;

public class WordsTest extends TestCase {

    public void testSetWords() throws IOException {
        Words words = new Words();
        Assert.assertArrayEquals(words.words.toArray(), new String[]{"abandon", "ability", "abortion"});
    }
}