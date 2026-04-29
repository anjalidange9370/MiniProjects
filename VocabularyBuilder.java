import java.util.*;
import java.io.*;

// Class to store word and meaning
class Word implements Serializable {
    String word;
    String meaning;

    Word(String word, String meaning) {
        this.word = word;
        this.meaning = meaning;
    }

    public String toString() {
        return word + " : " + meaning;
    }
}

public class VocabularyBuilder {
    static ArrayList<Word> words = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static final String FILE_NAME = "vocab.dat";

    public static void main(String[] args) {
        loadFromFile();

        int choice;
        do {
            System.out.println("\n===== Vocabulary Builder =====");
            System.out.println("1. Add Word");
            System.out.println("2. View Words");
            System.out.println("3. Quiz Mode");
            System.out.println("4. Word of the Day");
            System.out.println("5. Search Word");
            System.out.println("6. Save & Exit");
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.print("Invalid input! Enter number: ");
                sc.next();
            }
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1: addWord(); break;
                case 2: viewWords(); break;
                case 3: quizMode(); break;
                case 4: wordOfTheDay(); break;
                case 5: searchWord(); break;
                case 6: saveToFile();
                        System.out.println("Data saved. Exiting...");
                        break;
                default: System.out.println("Invalid choice!");
            }

        } while (choice != 6);
    }

    // Add Word
    static void addWord() {
        System.out.print("Enter word: ");
        String word = sc.nextLine();

        System.out.print("Enter meaning: ");
        String meaning = sc.nextLine();

        words.add(new Word(word, meaning));
        System.out.println("Word added successfully!");
    }

    // View Words
    static void viewWords() {
        if (words.isEmpty()) {
            System.out.println("No words available.");
            return;
        }

        System.out.println("\n--- Word List ---");
        for (Word w : words) {
            System.out.println(w);
        }
    }

    // Quiz Mode
    static void quizMode() {
        if (words.isEmpty()) {
            System.out.println("No words for quiz.");
            return;
        }

        Random rand = new Random();
        Word w = words.get(rand.nextInt(words.size()));

        System.out.println("What is the meaning of: " + w.word + "?");
        String answer = sc.nextLine();

        if (answer.equalsIgnoreCase(w.meaning)) {
            System.out.println("Correct! 🎉");
        } else {
            System.out.println("Wrong! Correct answer: " + w.meaning);
        }
    }

    // Word of the Day
    static void wordOfTheDay() {
        if (words.isEmpty()) {
            System.out.println("No words available.");
            return;
        }

        Random rand = new Random();
        Word w = words.get(rand.nextInt(words.size()));

        System.out.println("\n🌟 Word of the Day:");
        System.out.println(w);
    }

    // Search Word
    static void searchWord() {
        System.out.print("Enter word or meaning to search: ");
        String search = sc.nextLine().toLowerCase();

        boolean found = false;

        for (Word w : words) {
            if (w.word.toLowerCase().contains(search) ||
                w.meaning.toLowerCase().contains(search)) {
                System.out.println(w);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching results found.");
        }
    }

    // Save to File
    static void saveToFile() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
            oos.writeObject(words);
            oos.close();
        } catch (Exception e) {
            System.out.println("Error saving data.");
        }
    }

    // Load from File
    static void loadFromFile() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME));
            words = (ArrayList<Word>) ois.readObject();
            ois.close();
        } catch (Exception e) {
            // File may not exist first time
        }
    }
}