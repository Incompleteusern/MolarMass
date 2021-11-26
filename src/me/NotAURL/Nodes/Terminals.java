package me.NotAURL.Nodes;

import java.util.HashMap;
public class Terminals {
    public static HashMap<String, Double> elements = new HashMap<>();
    static {

        elements.put("H", 1.008d);
        elements.put("He", 4.0026d);
        elements.put("Li", 6.94d);
        elements.put("Be", 9.0122d);
        elements.put("B", 10.81d);
        elements.put("C", 12.011d);
        elements.put("N", 14.007d);
        elements.put("O", 15.999d);
        elements.put("F", 18.998d);
        elements.put("Ne", 20.180d);
        elements.put("Na", 22.990d);
        elements.put("Mg", 24.305d);
        elements.put("Al", 26.982d);
        elements.put("Si", 28.085d);
        elements.put("P", 30.974d);
        elements.put("S", 32.06d);
        elements.put("Cl", 35.45d);
        elements.put("Ar", 39.95d);
        elements.put("K", 39.098d);
        elements.put("Ca", 40.078d);
        elements.put("Sc", 44.956d);
        elements.put("Ti", 47.867d);
        elements.put("V", 50.942d);
        elements.put("Cr", 51.996d);
        elements.put("Mn", 54.938d);
        elements.put("Fe", 55.845d);
        elements.put("Co", 58.933d);
        elements.put("Ni", 58.693d);
        elements.put("Cu", 63.546d);
        elements.put("Zn", 65.38d);
        elements.put("Ga", 69.723d);
        elements.put("Ge", 72.630d);
        elements.put("As", 74.922d);
        elements.put("Se", 78.971d);
        elements.put("Br", 79.904d);
        elements.put("Kr", 83.798d);
        elements.put("Rb", 85.468d);
        elements.put("Sr", 87.62d);
        elements.put("Y", 88.906d);
        elements.put("Zr", 91.224d);
        elements.put("Nb", 92.906d);
        elements.put("Mo", 95.95d);
        elements.put("Tc", 97d);
        elements.put("Ru", 101.07d);
        elements.put("Rh", 102.91d);
        elements.put("Pd", 106.42d);
        elements.put("Ag", 107.87d);
        elements.put("Cd", 112.41d);
        elements.put("In", 114.82d);
        elements.put("Sn", 118.71d);
        elements.put("Sb", 121.76d);
        elements.put("Te", 127.60d);
        elements.put("I", 126.90d);
        elements.put("Xe", 131.29d);
        elements.put("Cs", 132.91d);
        elements.put("Ba", 137.33d);
        elements.put("Lu", 174.97d);
        elements.put("Hf", 178.49d);
        elements.put("Ta", 180.95d);
        elements.put("W", 183.84d);
        elements.put("Re", 186.21d);
        elements.put("Os", 190.23d);
        elements.put("Ir", 192.22d);
        elements.put("Pt", 195.08d);
        elements.put("Au", 196.97d);
        elements.put("Hg", 200.59d);
        elements.put("Tl", 204.38d);
        elements.put("Pb", 207.2d);
        elements.put("Bi", 208.98d);
        elements.put("Po", 209d);
        elements.put("At", 210d);
        elements.put("Rn", 222d);
        elements.put("Fr", 223d);
        elements.put("Ra", 226d);
        elements.put("Lr", 266d);
        elements.put("Rf", 267d);
        elements.put("Db", 268d);
        elements.put("Sg", 269d);
        elements.put("Bh", 270d);
        elements.put("Hs", 269d);
        elements.put("Mt", 278d);
        elements.put("Ds", 281d);
        elements.put("Rg", 282d);
        elements.put("Cn", 285d);
        elements.put("Nh", 286d);
        elements.put("Fl", 289d);
        elements.put("Mc", 290d);
        elements.put("Lv", 293d);
        elements.put("Ts", 294d);
        elements.put("Og", 294d);
        elements.put("La", 138.91d);
        elements.put("Ce", 140.12d);
        elements.put("Pr", 140.91d);
        elements.put("Nd", 144.24d);
        elements.put("Pm", 145d);
        elements.put("Sm", 150.36d);
        elements.put("Eu", 151.96d);
        elements.put("Gd", 157.25d);
        elements.put("Tb", 158.93d);
        elements.put("Dy", 162.50d);
        elements.put("Ho", 164.93d);
        elements.put("Er", 167.26d);
        elements.put("Tm", 168.93d);
        elements.put("Yb", 173.05d);
        elements.put("Ac", 227d);
        elements.put("Th", 232.04d);
        elements.put("Pa", 231.04d);
        elements.put("U", 238.03d);
        elements.put("Np", 237d);
        elements.put("Pu", 244d);
        elements.put("Am", 243d);
        elements.put("Cm", 247d);
        elements.put("Bk", 247d);
        elements.put("Cf", 251d);
        elements.put("Es", 252d);
        elements.put("Fm", 257d);
        elements.put("Md", 258d);
        elements.put("No", 259d);
    }

    public static String getElement(String input, int m) {
        String first = "" + input.charAt(m);

        String firstResult = elements.containsKey(first) ? first : "";

        if (input.length() == m + 1) return firstResult;

        String second = input.charAt(m) + "" + input.charAt(m + 1);

        return elements.containsKey(second) ? second : firstResult;
    }

    public static String getDigit(String input, int m) {
        StringBuilder output = new StringBuilder();

        while (m < input.length() && "1234567890".contains("" + input.charAt(m))) {
            output.append(input.charAt(m));
            m++;
        }

        return output.toString();
    }
}
