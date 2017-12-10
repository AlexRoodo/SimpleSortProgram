package com.company;

import java.io.*;
import java.util.*;

public class SimpleSortProgram {
    private int searchKeyValue = 0;

    private void sort() {
        String SOURCE_FILE_NAME = "/home/roodo/IdeaProjects/SimpleSortProgram/SourceFile.txt";

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(SOURCE_FILE_NAME)))) {

            LinkedList<String> lineLinkedList = createLinkedList(reader);
            lineLinkedList.sort(String::compareToIgnoreCase);

            printSortedList(lineLinkedList);

        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

    private LinkedList<String> createLinkedList(BufferedReader reader) throws IOException {
        LinkedList<String> lineLinkedList = new LinkedList<>();
        while (reader.ready()) {
            String s = reader.readLine().toLowerCase();
            lineLinkedList.add(s);
        }

        return lineLinkedList;
    }

    private void printSortedList(LinkedList<String> lineLinkedList) {
        for (String s : lineLinkedList) {
            System.out.println(s);
        }
    }

    private void setSearchKeyValue() {
        System.out.printf("Current key word is %s. Do you want set new value? (Y or N)", (searchKeyValue + 1));
        Scanner scanner = new Scanner(System.in);
        if (scanner.nextLine().toUpperCase().equals("Y")) {
            System.out.println("Please enter value in range 1 to 6");
            int i = scanner.nextInt();
            if ((i > 0) && (i < 7)) {
                searchKeyValue = i;
            } else {
                System.out.println("Please enter correct value in range 1 to 6");
                setSearchKeyValue();
            }
        }
    }

    public static void main(String[] args) {
        SimpleSortProgram simpleSortProgram = new SimpleSortProgram();

        simpleSortProgram.setSearchKeyValue();
        simpleSortProgram.sort();
    }
}
