classDiagram
direction BT
class Alumno {
  + Alumno(String, String) 
  - String nombre
  - String legajo
  - List~Materia~ materiasAprobadas
  + getNombre() String
  + getLegajo() String
  + getMateriasAprobadas() List~Materia~
  + agregarMateriaAprobada(Materia) void
  + toString() String
  + tieneAprobadaCorrelativa(Materia) boolean
  + setLegajo(String) void
  + setNombre(String) void
  + setMateriasAprobadas(List~Materia~) void
}
class Inscripcion {
  + Inscripcion(Alumno, Materia) 
  - Alumno alumno
  - Materia materia
  - LocalDate fecha
  + setMateria(Materia) void
  + getAlumno() Alumno
  + aprobada() boolean
  + getMateria() Materia
  + setAlumno(Alumno) void
  + setFecha(LocalDate) void
  + getFecha() LocalDate
}
class Main {
  + Main() 
  + main(String[]) void
}
class Materia {
  + Materia(String) 
  - String nombre
  - List~Materia~ correlativas
  + setNombre(String) void
  + getCorrelativas() List~Materia~
  + puedeCursar(Alumno) boolean
  + getNombre() String
  + tieneCorrelativas() boolean
  + agregarCorrelativa(Materia) void
  + setCorrelativas(List~Materia~) void
  + toString() String
}

Alumno "1" *--> "materiasAprobadas *" Materia 
Inscripcion "1" *--> "alumno 1" Alumno 
Inscripcion "1" *--> "materia 1" Materia 
Main  ..>  Alumno : «create»
Main  ..>  Inscripcion : «create»
Main  ..>  Materia : «create»
