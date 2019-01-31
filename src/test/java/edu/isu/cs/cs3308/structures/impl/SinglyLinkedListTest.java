package edu.isu.cs.cs3308.structures.impl;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


    /**
     * @author Isaac Griffith
     */
    public class SinglyLinkedListTest {

        @Test
        public void testIndexOf() {
            CircularlyLinkedList<Integer> list = new CircularlyLinkedList<>();
            list.addLast(1);
            list.addLast(2);
            list.addLast(3);

            assertEquals(list.indexOf(1), 0);
            assertEquals(list.indexOf(2), 1);
            assertEquals(list.indexOf(3), 2);
            assertEquals(list.indexOf(null), -1);
            assertEquals(list.indexOf(4), -1);
        }
    }
