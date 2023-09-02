import java.util.Random;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

// kiem tra 2 file properties
public class TIENPHONGBANK {
    String password = "123456ab";
    String accountNumberDefault = "0123456789";
    String locale;
    String accountAsk;
    String accountWrong;
    String passAsk;
    String passWrong;
    String capchaAsk;
    String capchaWrong;

    public void setLocale() {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("-------------Login Program------------");
            System.out.println("1. Vietnamese");
            System.out.println("2. English");
            System.out.println("3. Exit");
            System.out.println("Please choice one option: ");
            locale = input.next();
            if (locale.compareTo("1") == 0) {
                try (FileInputStream fileInputStream = new FileInputStream(
                        "C:\\Users\\sf\\OneDrive\\Documents\\LAB101\\B36_TIENPHONGBANK_150LOC\\src\\Vi.properties")) {
                    Properties properties = new Properties();
                    properties.load(fileInputStream);
                    accountAsk = properties.getProperty("accountAsk");
                    accountWrong = properties.getProperty("accountWrong");
                    passAsk = properties.getProperty("passAsk");
                    passWrong = properties.getProperty("passWrong");
                    capchaAsk = properties.getProperty("capchaAsk");
                    capchaWrong = properties.getProperty("capchaWrong");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            } else if (locale.compareTo("2") == 0) {
                try (FileInputStream fileInputStream = new FileInputStream(
                        "/src/En.properties")) {
                    Properties properties = new Properties();
                    properties.load(fileInputStream);
                    accountAsk = properties.getProperty("accountAsk");
                    accountWrong = properties.getProperty("accountWrong");
                    passAsk = properties.getProperty("passAsk");
                    passWrong = properties.getProperty("passWrong");
                    capchaAsk = properties.getProperty("capchaAsk");
                    capchaWrong = properties.getProperty("capchaWrong");

                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            } else if (locale.compareTo("3") == 0) {
                System.exit(0);
            } else {
                System.out.println("Vui long nhap dung chuc nang:");
            }
        }
    }

    public boolean checkAccountNumber(String AccountNumber) {
        if (AccountNumber.length() != 10) {
            return false;
        } else if (!AccountNumber.matches("\\d+")) {
            return false;
        } else if (AccountNumber.compareTo(accountNumberDefault) != 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean checkPassword(String pass) {
        if (pass.length() < 8 || pass.length() > 31) {
            return false;
        } else if (!pass.matches("[a-zA-Z0-9]+")) {
            return false;
        } else if (pass.compareTo(password) != 0) {
            return false;
        } else {
            return true;
        }
    }

    public String generateCaptcha(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            stringBuilder.append(characters.charAt(index));
        }
        return stringBuilder.toString();
    }

    public boolean checkCapcha(String key, String capcha) {
        if (key.compareTo(capcha) == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void start() {
        setLocale();
        String account;
        String pass;

        String captcha_in;
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print(accountAsk);
            account = input.nextLine();
            if (checkAccountNumber(account)) {
                break;
            } else {
                System.out.println(accountWrong);
            }
        }

        while (true) {
            System.out.print(passAsk);
            pass = input.nextLine();
            if (checkPassword(pass)) {
                break;
            } else {
                System.out.println(passWrong);
            }
        }

        while (true) {
            String captcha = generateCaptcha(6);
            System.out.println("Captcha " + captcha);
            System.out.print(capchaAsk);
            captcha_in = input.nextLine();
            if (checkCapcha(captcha, captcha_in)) {
                break;
            } else {
                System.out.println(capchaWrong);
            }
        }
    }
}
