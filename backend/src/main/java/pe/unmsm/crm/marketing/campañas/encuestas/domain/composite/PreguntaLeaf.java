package composite;

import java.util.List;

public class PreguntaLeaf implements EncuestaComponent {

    private String idPregunta;
    private String textoPregunta;
    private String tipoPregunta;
    private boolean esObligatoria;
    private boolean habilitada;
    private List<String> opciones;
    private Object reglaAlerta;

    public PreguntaLeaf(String idPregunta, String textoPregunta, String tipoPregunta, boolean esObligatoria) {
        this.idPregunta = idPregunta;
        this.textoPregunta = textoPregunta;
        this.tipoPregunta = tipoPregunta;
        this.esObligatorIA = esObligatoria;
        this.habilitada = true;
    }

    @Override
    public void deshabilitar() {
        this.habilitada = false;
        System.out.println("Pregunta deshabilitada: " + this.textoPregunta);
    }

    @Override
    public boolean validar() {
        if (this.esObligatorIA && (this.textoPregunta == null || this.textoPregunta.trim().isEmpty())) {
            System.out.println("Error: Pregunta obligatoria " + idPregunta + " no tiene texto.");
            return false;
        }

        if (this.tipoPregunta.equals("OPCION_MULTIPLE") && (this.opciones == null || this.opciones.isEmpty())) {
            System.out.println("Error: Pregunta " + idPregunta + " es de opción múltiple pero no tiene opciones.");
            return false;
        }
        
        System.out.println("Pregunta validada: " + this.textoPregunta);
        return true;
    }
    
    public void setOpciones(List<String> opciones) {
        this.opciones = opciones;
    }

    public void setReglaAlerta(Object reglaAlerta) {
        this.reglaAlerta = reglaAlerta;
    }

    public boolean estaHabilitada() {
        return this.habilitada;
    }
}