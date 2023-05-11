package second;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Schreiben Sie ein Programm Inspector, das mithilfe von Reflection
 * eine beliebige Klasse, deren Name zur Laufzeit vom Benutzer angefordert
 * wird, analysiert. Jede Methode der Klasse soll mit ihren Modifizierern, dem
 * Return-Wert, Namen sowie mit sämtlichen Argument-Typen ausgegeben
 * werden. Sowohl die Superklasse als auch die implementierten Interfaces
 * sollen berichtet werden.
 *
 * @author Dennis Mayer
 * @version 1, 11.05.2023
 */
public class Inspector {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Geben sie eine Klasse zum Analysieren an");
            System.out.println("Exit zum verlassen des Programms");
            String input = scan.nextLine();
            if (input.equals("Exit")) {
                break;
            }
            try {
                Class<?> testedClass = Class.forName(input);
                Method[] methods = testedClass.getMethods();
                System.out.println(testedClass.getName());
                Class<?>[] interFaces = testedClass.getInterfaces();
                System.out.println("Class: " + testedClass.getName());
                System.out.print("Implemented Interfaces: ");
                Arrays.stream(interFaces).forEach(printer -> System.out.print(printer.getSimpleName() + " "));
                System.out.println("");
                System.out.println("Super Class: " + testedClass.getSuperclass().getSimpleName());
                System.out.println("Methods: ");
                for (Method m : methods) {
                    String name = m.getName();
                    Class<?>[] parameters = m.getParameterTypes();
                    int modifier = m.getModifiers();
                    Class<?> returnValue = m.getReturnType();
                    Class<?> superClass = testedClass.getSuperclass();
                    String modifierString = Modifier.toString(modifier);
                    System.out.println("-----------------------");
                    System.out.println("Name of the Method : " + name);
                    System.out.println("Modifier: " + modifierString);
                    System.out.println("Return Value: " + returnValue.toString());
                    System.out.print("Parameters: ");
                    Arrays.stream(parameters).forEach(printer -> System.out.print(printer.getSimpleName() + " "));
                    System.out.println("");
                    System.out.println("_______________________");
                }
            } catch (ClassNotFoundException e) {
                e.toString();

            }


        }
    }

}
