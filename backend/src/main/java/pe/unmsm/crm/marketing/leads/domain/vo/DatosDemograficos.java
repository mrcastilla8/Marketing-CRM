package pe.unmsm.crm.marketing.leads.domain.vo;

import lombok.Value;

@Value
public class DatosDemograficos {
    Integer edad;
    String genero;
    String nivelEducativo;
    String estadoCivil;
    String distrito;

    public DatosDemograficos(Integer edad, String genero, String distrito) {
        this.edad = edad;
        this.genero = genero;
        this.distrito = distrito;
        this.nivelEducativo = null;
        this.estadoCivil = null;
    }
}