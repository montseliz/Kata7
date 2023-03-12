package kata7;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Introdueix la longitud el password:");
        int passwordLength = input.nextInt();

        System.out.println("El teu password generat aleatòriament és: " + generatePassword(passwordLength));

    }

    public static String generatePassword(int passwordLength) {
        String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCase = "abcdefghijklmnopqrstuvwxyz";
        String symbols = "!@#$%^&*(){}[]=<>";
        String password = "";
        Random random = new Random();

        for (int i = 0; i < passwordLength; i++) {
            int type = random.nextInt(3);
            if (type == 0) { //Majúscula
                password += upperCase.charAt(random.nextInt(upperCase.length()));
            } else if (type == 1) { //Minúscula
                password += lowerCase.charAt(random.nextInt(lowerCase.length()));
            } else { //Símbol
                password += symbols.charAt(random.nextInt(symbols.length()));
            }
        }

        return password;
    }

    /**
     * Per generar la majúscula o la minúscula aleatòria, s'utilitza la funció random.nextInt(26),
     * que retorna un número aleatori entre 0 i 25 (ja que hi ha 26 lletres a l'alfabet).
     * Aquest número aleatori es suma a 'A' (per a majúscules) o a 'a' (per a minúscules)
     * per obtenir el codi ASCII de la lletra corresponent.
     */
    public static String generatePassword2(int passwordLength) {
        String symbols = "!@#$%^&*(){}[]=<>";
        String password = "";
        Random random = new Random();

        for (int i = 0; i < passwordLength; i++) {
            int type = random.nextInt(3);
            if (type == 0) { //Majúscula
                password += (char) (random.nextInt(26) + 'A');
            } else if (type == 1) { //Minúscula
                password += (char) (random.nextInt(26) + 'a');
            } else { //Símbol
                password += symbols.charAt(random.nextInt(symbols.length()));
            }
        }

        return password;
    }

}