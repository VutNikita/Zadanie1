
package org.example;
import java.time.LocalDate;
import java.util.Scanner;

public class Zodiac {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your birthdate (day month year):");
        int day = scanner.nextInt();
        int month = scanner.nextInt();
        int year = scanner.nextInt();

        String zodiacSign = getZodiacSign(day, month, year);

        System.out.println("Your zodiac sign is " + zodiacSign);
    }

    public static String getZodiacSign(int day, int month, int year) {
        LocalDate birthdate = LocalDate.of(year, month, day);

        String[] zodiacSigns = {
                "Aquarius", "Pisces", "Aries", "Taurus", "Gemini", "Cancer",
                "Leo", "Virgo", "Libra", "Scorpio", "Sagittarius", "Capricorn"
        };

        LocalDate[] signStartDates = {
                LocalDate.of(year, 1, 20), LocalDate.of(year, 2, 19), LocalDate.of(year, 3, 21),
                LocalDate.of(year, 4, 20), LocalDate.of(year, 5, 21), LocalDate.of(year, 6, 21),
                LocalDate.of(year, 7, 23), LocalDate.of(year, 8, 23), LocalDate.of(year, 9, 23),
                LocalDate.of(year, 10, 23), LocalDate.of(year, 11, 22), LocalDate.of(year, 12, 22)
        };

        int zodiacIndex = -1;
        for (int i = 0; i < 12; i++) {
            if (birthdate.isBefore(signStartDates[i])) {
                zodiacIndex = i - 1;
                break;
            }
        }
        if (zodiacIndex == -1) {
            zodiacIndex = 11;
        }

        return zodiacSigns[zodiacIndex];
    }
}