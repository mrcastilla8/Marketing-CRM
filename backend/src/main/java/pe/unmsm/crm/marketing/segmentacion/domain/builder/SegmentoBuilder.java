package pe.unmsm.crm.marketing.segmentacion.domain.builder;

import pe.unmsm.crm.marketing.segmentacion.domain.model.*;

import java.util.ArrayList;
import java.util.List;

public class SegmentoBuilder {

    private Long idSegmento;
    private String nombre;
    private String tipoAudiencia;
    private String descripcion;

    private final List<Criterio> criterios = new ArrayList<>();
    private final CatalogoFiltros catalogoFiltros;

    public SegmentoBuilder(CatalogoFiltros catalogoFiltros) {
        this.catalogoFiltros = catalogoFiltros;
    }

    public SegmentoBuilder withId(Long id) {
        this.idSegmento = id;
        return this;
    }

    public SegmentoBuilder withNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public SegmentoBuilder withDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public SegmentoBuilder withTipoAudiencia(String tipoAudiencia) {
        this.tipoAudiencia = tipoAudiencia;
        return this;
    }

    // =============================
    //  CRITERIOS SIMPLES
    // =============================
    public SegmentoBuilder addCriterioSimple(
            String entidad,
            String campo,
            String operador,
            Object valor
    ) {
        CriterioAtributo c = new CriterioAtributo(entidad, campo, operador, valor, null, null);

        if (!c.validarContra(catalogoFiltros)) {
            throw new IllegalArgumentException(
                    "Criterio inválido según catálogo: " + entidad + "." + campo);
        }

        criterios.add(c);
        return this;
    }

    // =============================
    //  GRUPOS (AND / OR)
    // =============================
    public SegmentoBuilder addGrupoAND(List<Criterio> hijos) {
        CriterioCompuesto grupo = new CriterioCompuesto(ConectorLogico.AND, hijos);
        criterios.add(grupo);
        return this;
    }

    public SegmentoBuilder addGrupoOR(List<Criterio> hijos) {
        CriterioCompuesto grupo = new CriterioCompuesto(ConectorLogico.OR, hijos);
        criterios.add(grupo);
        return this;
    }

    // =============================
    //   BUILD FINAL
    // =============================
    public Segmento build() {

        Segmento seg = new Segmento(
                idSegmento,
                nombre,
                tipoAudiencia,
                descripcion
        );

        for (Criterio c : criterios) {
            seg.agregarCriterio(c);
        }

        seg.validarInvariantes();

        return seg;
    }
}
