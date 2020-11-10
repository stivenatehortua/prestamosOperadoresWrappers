package com.clientes;

import com.clases.BeneficiosCovid19;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        ArrayList<BeneficiosCovid19> beneficiosCovid19List1 = new ArrayList<>();
        llenarLista(beneficiosCovid19List1);
        ArrayList<BeneficiosCovid19> beneficiosCovid19List2 = new ArrayList<>();
        llenarLista(beneficiosCovid19List2);

        System.out.println("Empresa 1 (lista 1): ");
        imprimirLista(beneficiosCovid19List1);
        System.out.println("\nEmpresa 2 (lista 2): ");
        imprimirLista(beneficiosCovid19List2);
        System.out.println("\nBeneficios que hay en empresa 1 que no hay en empresa 2:");
        compararListas(beneficiosCovid19List1, beneficiosCovid19List2);
        System.out.println("\nBeneficios que hay en empresa 2 que no hay en empresa 1:");
        compararListas(beneficiosCovid19List2, beneficiosCovid19List1);
        mejoresBeneficios(beneficiosCovid19List1, beneficiosCovid19List2);
    }

    //Implementa un metodo que te entregue un numero aletorio para el ide de los beneficios usar el wrapper de Integer
    private static String getIdBeneficio(List<BeneficiosCovid19> beneficiosCovid19) {
        Integer id = (int) (Math.random() * 20000) + 1;
        for (int i = 0; i < beneficiosCovid19.size(); i++) {
            if (Integer.parseInt(beneficiosCovid19.get(i).getId()) == id) {
                id = (int) (Math.random() * 20000) + 1;
                i = -1;
            }
        }
        return id.toString();
    }

    private static String getNombreBeneficio(List<BeneficiosCovid19> beneficiosCovid19) {
        String[] nombresBeneficios = {"Beneficiados que perdieron su trabajo por COVID19",
                "Beneficios para persona tercera edad dagnificados por COVID19",
                "Beneficio para personas diagnosticadas con COVID19",
                "Beneficio para personas con familiares que diagnosticaron con COVID19"};
        Random random = new Random();
        String nombreBeneficio = nombresBeneficios[random.nextInt(4)];
        for (int i = 0; i < beneficiosCovid19.size(); i++) {
            if (beneficiosCovid19.get(i).getNombre().equals(nombreBeneficio)) {
                nombreBeneficio = nombresBeneficios[random.nextInt(4)];
                i = -1;
            }
        }
        return nombreBeneficio;
    }

    private static String getValorBeneficio(List<BeneficiosCovid19> beneficiosCovid19) {
        Integer[] valoresBeneficios = {150000, 200000, 250000, 300000, 350000};
        Random random = new Random();
        Integer valorBeneficio = valoresBeneficios[random.nextInt(5)];
        for (int i = 0; i < beneficiosCovid19.size(); i++) {
            if (beneficiosCovid19.get(i).getValorSubsidio().equals(valorBeneficio)) {
                valorBeneficio = valoresBeneficios[random.nextInt(5)];
                i = -1;
            }
        }
        return valorBeneficio.toString();
    }

    private static void llenarLista(ArrayList<BeneficiosCovid19> list) {
        for (int i = 0; i < 3; i++) {
            BeneficiosCovid19 beneficiosCovid19 = new BeneficiosCovid19();
            beneficiosCovid19.setId(Integer.parseInt(getIdBeneficio(list)));
            beneficiosCovid19.setNombre(getNombreBeneficio(list));
            beneficiosCovid19.setValorSubsidio(Integer.parseInt(getValorBeneficio(list)));
            list.add(beneficiosCovid19);
        }
    }

    private static void imprimirLista(ArrayList<BeneficiosCovid19> list) {
        for (BeneficiosCovid19 beneficiosCovid19 : list) {
            System.out.println(beneficiosCovid19.toString());
        }
    }

    private static void compararListas(ArrayList<BeneficiosCovid19> list1, ArrayList<BeneficiosCovid19> list2) {
        for (BeneficiosCovid19 beneficiosCovid19List1 : list1) {
            boolean existencia = false;
            for (BeneficiosCovid19 beneficiosCovid19List2 : list2) {
                if (beneficiosCovid19List1.getNombre().equals(beneficiosCovid19List2.getNombre())) {
                    existencia = true;
                    break;
                }
            }
            if (!existencia) {
                System.out.println(beneficiosCovid19List1.toString());
            }
        }
    }

    private static void mejoresBeneficios
            (ArrayList<BeneficiosCovid19> list1, ArrayList<BeneficiosCovid19> list2) {
        ArrayList<BeneficiosCovid19> mejoresBeneficios = new ArrayList<>();
        ArrayList<BeneficiosCovid19> mejorBeneficio = new ArrayList<>();

        System.out.println("\nMejor Beneficio Empresa 1 (lista 1): ");
        mejoresBeneficios.add(list1.get(0).getMejorbeneficios(list1));
        System.out.println(mejoresBeneficios.get(0).toString());
        System.out.println("\nMejor Beneficio Empresa 2 (lista 2): ");
        mejoresBeneficios.add(list2.get(0).getMejorbeneficios(list2));
        System.out.println(mejoresBeneficios.get(1).toString());

        Integer mayorBeneficio = mejoresBeneficios.get(1).getValorSubsidio();
        for (int i = 0; i < mejoresBeneficios.size(); i++) {
            if (mejoresBeneficios.get(i).getValorSubsidio() >= mayorBeneficio) {
                mayorBeneficio = mejoresBeneficios.get(i).getValorSubsidio();
                mejorBeneficio.add(mejoresBeneficios.get(i));
            }
        }
        System.out.println("\nEl(Los) mejor(es) beneficio(s) es(son): ");
        imprimirLista(mejorBeneficio);
    }
}
