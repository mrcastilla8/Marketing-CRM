package pe.unmsm.crm.marketing.segmentacion.domain.builder;

import pe.unmsm.crm.marketing.segmentacion.domain.model.*;

public class CriterioAtributoBuilder {

    private String entidad;
    private String campo;
    private String operador;
    private Object valor;

    public CriterioAtributoBuilder entidad(String entidad) {
        this.entidad = entidad;
        return this;
    }

    public CriterioAtributoBuilder campo(String campo) {
        this.campo = campo;
        return this;
    }

    public CriterioAtributoBuilder operador(String operador) {
        this.operador = operador;
        return this;
    }

    public CriterioAtributoBuilder valor(Object valor) {
        this.valor = valor;
        return this;
    }

    public CriterioAtributo build() {
        return new CriterioAtributo(entidad, campo, operador, valor, null, null);
    }
}
