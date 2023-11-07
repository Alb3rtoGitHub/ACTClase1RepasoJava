import validadorCorrelativas.Alumno;
import validadorCorrelativas.Inscripcion;
import validadorCorrelativas.Materia;

/**
 * Repaso Java
 * Validador de Inscripciones según Correlatividades
 * Nos han solicitado el diseño y el desarrollo de un Validador de Inscripciones según materias
 * correlativas.
 * En las carreras terciarias y universitarias, para ordenar el plan de estudios y asegurar que
 * cuando se inicia una materia se tienen todos los conocimientos necesarios para entenderla, se
 * establece lo que se llama comúnmente “materias correlativas”. Básicamente, son materias que
 * hay que tener aprobadas antes de cursar la materia en cuestión. Por ejemplo, antes de cursar
 * Diseño de Sistemas hay que cursar Paradigmas de Programación y antes de esta hay que
 * cursar Algoritmos y Estructuras de Datos, donde esta última no tiene correlativas.
 * Teniendo en cuenta que el método principal del presente módulo debe ser el método
 * “boolean aprobada( )” de la clase Inscripción, y teniendo como restricción que solamente se
 * podrán utilizar, además de la clase Inscripción, la clase Materia y Alumno; se pide:
 * ● Diseñar una solución en el Paradigma Orientado a Objetos y comunicar la solución
 * mediante un Diagrama de Clases.
 * ● Codificar la solución (lenguaje a elección o pseudo-código)
 */


public class Main {
    public static void main(String[] args) {

        //Instanciar 2 alumnos Pedro y Pablo:
        Alumno alumno1 = new Alumno("Pedro Picapiedra", "181539");
        Alumno alumno2 = new Alumno("Pablo Mármol", "172691");

        //Instanciar 3 materias:
        Materia materia1 = new Materia("1:Algoritmos y Estructuras de Datos");
        Materia materia2 = new Materia("2:Paradigmas de Programación");
        Materia materia3 = new Materia("3:Diseño de Sistemas");

        //Cargar las materias aprobadas de los alumnos:
        alumno1.agregarMateriaAprobada(materia1);
        alumno1.agregarMateriaAprobada(materia2);

        alumno2.agregarMateriaAprobada(materia1);

        System.out.println("\nMaterias aprobadas por alumno:");
        System.out.println(alumno1 + ", tiena aprobradas: " + alumno1.getMateriasAprobadas());
        System.out.println(alumno2 + ", tiena aprobradas: " + alumno2.getMateriasAprobadas());
        System.out.println("");

        //Cargar las correlatividades de las materias:
        materia2.agregarCorrelativa(materia1);
        materia3.agregarCorrelativa(materia1);
        materia3.agregarCorrelativa(materia2);

        System.out.println("La materia: " + materia1.getNombre() + ", tiene las correlativas: " + materia1.getCorrelativas());
        System.out.println("La materia: " + materia2.getNombre() + ", tiene las correlativas: " + materia2.getCorrelativas());
        System.out.println("La materia: " + materia3.getNombre() + ", tiene las correlativas: " + materia3.getCorrelativas());
        System.out.println("");

        //Instanciar Inscripciones
        Inscripcion inscripcion1 = new Inscripcion(alumno1, materia3);
        Inscripcion inscripcion2 = new Inscripcion(alumno2, materia2);
        Inscripcion inscripcion3 = new Inscripcion(alumno2, materia3);

        if (inscripcion1.aprobada()){
            System.out.println("Inscripción exitosa de " + alumno1.getNombre() + ", en Materia: " + materia3);
        } else {
            System.out.println("Inscripción fallida el Alumno " + alumno1.getNombre() + "no tiene la correlativa aprobada");
        }

        if (inscripcion2.aprobada()){
            System.out.println("Inscripción exitosa de " + alumno2.getNombre() + ", en Materia: " + materia2);
        } else {
            System.out.println("Inscripción fallida el Alumno " + alumno2.getNombre() + "no tiene la correlativa aprobada");
        }

        if (inscripcion3.aprobada()){
            System.out.println("Inscripción exitosa de " + alumno2.getNombre() + ", en Materia: " + materia3);
        } else {
            System.out.println("Inscripción fallida el Alumno " + alumno2.getNombre() + ", no tiene la correlativa aprobada");
        }

    }
}