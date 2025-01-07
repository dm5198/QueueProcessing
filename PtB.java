package homework1;

import java.util.ArrayList;
import java.util.Random;

public class PtB {
    private Random random = new Random();

    public int testB(MySinglyLinkedList<String> processes) {
        int cycles = 0;
        int len = processes.size();
        boolean[] resourcesUsed = new boolean[3]; // A, B, C

        while (!processes.isEmpty() && cycles < 1000) {
            cycles++;

            for (int i = 0; i < len; i++) {
                String process = processes.removeFirst();

                if (process == null) {
                    break;
                }

                // Extract letters in each individual process
                String subStr = process.substring(process.indexOf("(") + 1, process.indexOf(")"));
                String[] letters = subStr.split(",");

                // Check if resources are available
                boolean resourcesAvailable = true;
                for (String letter : letters) {
                    char resource = letter.charAt(0);
                    int index = resource - 'A';

                    if (resourcesUsed[index]) {
                        resourcesAvailable = false;
                        break;
                    }
                }

                if (resourcesAvailable) {
                    // Mark resources as used
                    for (String letter : letters) {
                        char resource = letter.charAt(0);
                        int index = resource - 'A';
                        resourcesUsed[index] = true;
                    }
                } else {
                    // Re-add the process to the end of the list
                    processes.addLast(process);
                }
            }

            if (cycles % 100 == 0) {
                System.out.println("Length of processes at cycle " + cycles + ": " + processes.size());
            }

            // Add two new processes with random resources
            for (int k = 0; k < 2; k++) {
                ArrayList<String> randLetters = new ArrayList<>();
                int numLetters = random.nextInt(1, 4);

                for (int l = 0; l < numLetters; l++) {
                    int indexLetter = random.nextInt(3); // Random index from 0 to 2

                    if (indexLetter == 0)
                        randLetters.add("A");
                    else if (indexLetter == 1)
                        randLetters.add("B");
                    else if (indexLetter == 2)
                        randLetters.add("C");
                }

                StringBuilder processBuilder = new StringBuilder("P");
                processBuilder.append(len + k + 1).append("(");
                processBuilder.append(String.join(",", randLetters)).append(");");
                processes.addLast(processBuilder.toString());
            }

            for (int i = 0; i < 3; i++) {
                resourcesUsed[i] = false;
            }
        }

        if (!processes.isEmpty()) {
            //System.out.println("Length of processes at cycle 1000: " + processes.size());
        }

        return cycles;
    }
}



