package com.clases;

import java.util.List;

public class BeneficiosCovid19 {
    //Debe ser el numero entero aleatorio puedes usar la funcion ramdom para esto
    private Integer id;
    private String nombre;
    private Float valorSubsidio;

    public String getId() {
        return id.toString();
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getValorSubsidio() {
        return valorSubsidio.intValue();
    }

    public void setValorSubsidio(Integer valorSubsidio) {
        this.valorSubsidio = valorSubsidio.floatValue();
    }

    @Override
    public String toString() {
        return "BeneficiosCovid {" + "id=" + id + ", nombre='" + nombre + '\'' + ", valorSubsidio=" + valorSubsidio + '}';
    }

    //Implementar un metodo que retorne el mejor beneficio comparando los valores de todos los beneficios
    public BeneficiosCovid19 getMejorbeneficios(List<BeneficiosCovid19> list) {
        BeneficiosCovid19 mejorMeneficiosCovid19 = new BeneficiosCovid19();
        mejorMeneficiosCovid19.setValorSubsidio(0);
        for (BeneficiosCovid19 beneficiosCovid19 : list) {
            if (beneficiosCovid19.getValorSubsidio() > mejorMeneficiosCovid19.getValorSubsidio()) {
                mejorMeneficiosCovid19 = beneficiosCovid19;
            }
        }
        return mejorMeneficiosCovid19;
    }
}
