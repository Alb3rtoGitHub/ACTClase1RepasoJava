package validadorCorrelativas;

import java.util.ArrayList;
import java.util.List;

public class Materia {
    private String nombre;
    private List<Materia> correlativas;

    public Materia(String nombre) {
        this.nombre = nombre;
        this.correlativas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Materia> getCorrelativas() {
        return correlativas;
    }

    public void setCorrelativas(List<Materia> correlativas) {
        this.correlativas = correlativas;
    }

    public void agregarCorrelativa(Materia correlativa) {
        this.correlativas.add(correlativa);
    }

    public boolean puedeCursar(Alumno alumno) {
        //El alumno puede cursar si las materias correlativas están aprobadas
        return this.correlativas.stream().allMatch(materiaCorrelativa -> alumno.tieneAprobadaCorrelativa(materiaCorrelativa));
    }

    public boolean tieneCorrelativas() {
        return !this.correlativas.isEmpty();
    }

    @Override
    public String toString() {
        return "Materia: \'" + nombre + "\'";
    }
}
