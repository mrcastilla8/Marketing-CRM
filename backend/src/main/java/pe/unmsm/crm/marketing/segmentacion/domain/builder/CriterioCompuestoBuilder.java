package pe.unmsm.crm.marketing.segmentacion.domain.builder;

import pe.unmsm.crm.marketing.segmentacion.domain.model.*;

import java.util.ArrayList;
import java.util.List;

public class CriterioCompuestoBuilder {

    private ConectorLogico conector;
    private List<Criterio> hijos = new ArrayList<>();

    public CriterioCompuestoBuilder conector(ConectorLogico con) {
        this.conector = con;
        return this;
    }

    public CriterioCompuestoBuilder add(Criterio criterio) {
        this.hijos.add(criterio);
        return this;
    }

    public CriterioCompuestoBuilder addAll(List<Criterio> criterios) {
        this.hijos.addAll(criterios);
        return this;
    }

    public CriterioCompuesto build() {
        return new CriterioCompuesto(conector, hijos);
    }
}
