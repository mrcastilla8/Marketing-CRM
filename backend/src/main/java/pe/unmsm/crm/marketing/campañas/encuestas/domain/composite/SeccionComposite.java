package composite;

import java.util.ArrayList;
import java.util.List;

public class SeccionComposite implements EncuestaComponent {

    private String tituloSeccion;
    private boolean habilitada;
    private List<EncuestaComponent> componentes = new ArrayList<>();

    public SeccionComposite(String tituloSeccion) {
        this.tituloSeccion = tituloSeccion;
        this.habilitada = true;
    }

    public void add(EncuestaComponent componente) {
        componentes.add(componente);
    }

    public void remove(EncuestaComponent componente) {
        componentes.remove(componente);
    }

    @Override
    public void deshabilitar() {
        this.habilitada = false;
        System.out.println("Sección deshabilitada: " + this.tituloSeccion);

        for (EncuestaComponent componente : componentes) {
            componente.deshabilitar();
        }
    }

    @Override
    public boolean validar() {
        System.out.println("Validando Sección: " + this.tituloSeccion);
        
        boolean esValido = true;

        for (EncuestaComponent componente : componentes) {
            if (!componente.validar()) {
                esValido = false;
            }
        }
        
        if (componentes.isEmpty()) {
            System.out.println("Error: La sección '" + this.tituloSeccion + "' no tiene preguntas.");
            esValido = false;
        }

        return esValido;
    }
}