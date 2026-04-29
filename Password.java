import java.io.*;
import java.security.SecureRandom;
import java.util.*;

// ---------------- PASSWORD GENERATOR ----------------
class PasswordGenerator {
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SYMBOLS = "!@#$%^&*";

    private SecureRandom random = new SecureRandom();

    public String generatePassword(int length, boolean useUpper, boolean useLower,
                                   boolean useDigits, boolean useSymbols) {

        if (length < 4) {
            throw new IllegalArgumentException("Password length must be at least 4");
        }

        StringBuilder charPool = new StringBuilder();

        if (useUpper) charPool.append(UPPER);
        if (useLower) charPool.append(LOWER);
        if (useDigits) charPool.append(DIGITS);
        if (useSymbols) charPool.append(SYMBOLS);

        if (charPool.length() == 0) {
            throw new IllegalArgumentException("At least one character type must be selected");
        }

        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(charPool.length());
            password.append(charPool.charAt(index));
        }

        return password.toString();
    }

    public List<String> generateMultiple(int count, int length, boolean u, boolean l, boolean d, boolean s) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(generatePassword(length, u, l, d, s));
        }
        return list;
    }
}

// ---------------- PASSWORD STRENGTH CHECKER ----------------
class PasswordStrengthChecker {

    public String checkStrength(String password) {
        int score = 0;

        if (password.length() >= 8) score++;
        if (password.matches(".*[A-Z].*")) score++;
        if (password.matches(".*[a-z].*")) score++;
        if (password.matches(".*[0-9].*")) score++;
        if (password.matches(".*[!@#$%^&*].*")) score++;

        if (score <= 2) return "Weak ❌";
        else if (score == 3 || score == 4) return "Medium ⚠️";
        else return "Strong ✅";
    }
}

// ---------------- FILE HANDLER ----------------
class FileHandler {
    private static final String FILE_NAME = "passwords.txt";

    public void savePasswords(List<String> passwords) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            for (String pwd : passwords) {
                writer.write(pwd);
                writer.newLine();
            }
            System.out.println("💾 Passwords saved successfully!");
        } catch (IOException e) {
            System.out.println("❌ Error saving passwords!");
        }
    }

    public void viewPasswords() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("\n📂 Saved Passwords:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("❌ No saved passwords found!");
        }
    }
}

// ---------------- MAIN CLASS ----------------
public class Password {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PasswordGenerator generator = new PasswordGenerator();
        PasswordStrengthChecker checker = new PasswordStrengthChecker();
        FileHandler fileHandler = new FileHandler();

        List<String> generatedPasswords = new ArrayList<>();

        while (true) {
            System.out.println("\n===== PASSWORD GENERATOR MENU =====");
            System.out.println("1. Generate Password");
            System.out.println("2. Check Password Strength");
            System.out.println("3. Generate Multiple Passwords");
            System.out.println("4. Save Passwords to File");
            System.out.println("5. View Saved Passwords");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice;
            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                System.out.println("❌ Invalid input!");
                sc.nextLine();
                continue;
            }

            switch (choice) {

                case 1:
                    try {
                        System.out.print("Enter length: ");
                        int length = sc.nextInt();

                        System.out.print("Include Uppercase? (true/false): ");
                        boolean u = sc.nextBoolean();

                        System.out.print("Include Lowercase? (true/false): ");
                        boolean l = sc.nextBoolean();

                        System.out.print("Include Digits? (true/false): ");
                        boolean d = sc.nextBoolean();

                        System.out.print("Include Symbols? (true/false): ");
                        boolean s = sc.nextBoolean();

                        String pwd = generator.generatePassword(length, u, l, d, s);
                        generatedPasswords.add(pwd);

                        System.out.println("🔐 Generated Password: " + pwd);

                    } catch (Exception e) {
                        System.out.println("❌ Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    sc.nextLine(); // clear buffer
                    System.out.print("Enter password: ");
                    String inputPwd = sc.nextLine();

                    System.out.println("Strength: " + checker.checkStrength(inputPwd));
                    break;

                case 3:
                    try {
                        System.out.print("How many passwords?: ");
                        int count = sc.nextInt();

                        System.out.print("Length: ");
                        int length = sc.nextInt();

                        System.out.print("Include Uppercase? (true/false): ");
                        boolean u = sc.nextBoolean();

                        System.out.print("Include Lowercase? (true/false): ");
                        boolean l = sc.nextBoolean();

                        System.out.print("Include Digits? (true/false): ");
                        boolean d = sc.nextBoolean();

                        System.out.print("Include Symbols? (true/false): ");
                        boolean s = sc.nextBoolean();

                        List<String> list = generator.generateMultiple(count, length, u, l, d, s);
                        generatedPasswords.addAll(list);

                        System.out.println("\nGenerated Passwords:");
                        for (String p : list) {
                            System.out.println(p);
                        }

                    } catch (Exception e) {
                        System.out.println("❌ Error: " + e.getMessage());
                    }
                    break;

                case 4:
                    fileHandler.savePasswords(generatedPasswords);
                    break;

                case 5:
                    fileHandler.viewPasswords();
                    break;

                case 6:
                    System.out.println("👋 Exiting program...");
                    return;

                default:
                    System.out.println("❌ Invalid choice!");
            }
        }
    }
}