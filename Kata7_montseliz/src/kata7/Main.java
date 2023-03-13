package kata7;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Introdueix la longitud el password:");
        int passwordLength = input.nextInt();

        System.out.println("El teu password generat aleatòriament és: " + generatePassword(passwordLength));
        System.out.println("\nEl teu password generat aleatòriament és: " + generatePassword2(passwordLength));

    }

    public static String generatePassword(int passwordLength) {
        String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCase = "abcdefghijklmnopqrstuvwxyz";
        String symbols = "!@#$%^&*(){}[]=<>";
        String numbers = "0123456789";
        String password = "";
        Random random = new Random();

        for (int i = 0; i < passwordLength; i++) {
            int type = random.nextInt(4);
            if (type == 0) { //Majúscula
                password += upperCase.charAt(random.nextInt(upperCase.length()));
            } else if (type == 1) { //Minúscula
                password += lowerCase.charAt(random.nextInt(lowerCase.length()));
            } else if (type == 2){ //Símbol
                password += symbols.charAt(random.nextInt(symbols.length()));
            } else { //Números
                password += numbers.charAt(random.nextInt(numbers.length()));
            }
        }

        return password;
    }

    /**
     * Per generar la majúscula o la minúscula aleatòria, s'utilitza la funció random.nextInt(26),
     * que retorna un número aleatori entre 0 i 25 (ja que hi ha 26 lletres a l'alfabet).
     * En el cas dels números s'utilitza random.nextInt(10) perquè són 10 els caràcters numèrics possibles.
     * Aquest número aleatori es suma a 'A' (per a majúscules), a 'a' (per a minúscules), o a '0' per números
     * per obtenir el codi ASCII corresponent.
     */
    public static String generatePassword2(int passwordLength) {
        String symbols = "!@#$%^&*(){}[]=<>";
        String password = "";
        Random random = new Random();

        for (int i = 0; i < passwordLength; i++) {
            int type = random.nextInt(4);
            if (type == 0) { //Majúscula
                password += (char) (random.nextInt(26) + 'A');
            } else if (type == 1) { //Minúscula
                password += (char) (random.nextInt(26) + 'a');
            } else if (type == 2){ //Símbol
                password += symbols.charAt(random.nextInt(symbols.length()));
            } else { //Números
                password += (char) (random.nextInt(10) + '0');
            }
        }

        return password;
    }

}