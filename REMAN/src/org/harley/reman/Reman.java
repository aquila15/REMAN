package org.harley.reman;

import org.harley.reman.clases.*;
import org.harley.reman.conversion.XMLConverter;
import org.harley.reman.conversion.XMLReader;

/**
 *
 * @author Gonzalo
 */
public class Reman {

     public static LibroEduccion crearEduccion() {
        LibroEduccion nuevo = new LibroEduccion();
        Educcion edu = new Educcion();
        Nombre nom = new Nombre();
        Version ver = new Version();
        
        nom.setCodigo("0001");
        nom.setNombre("Nombre del requisito");
        
        edu.setActor("Christian");
        edu.setCargo("Usuario");
        edu.setEspecialista("Gonzalo Luna");
        edu.setEspecialEspecial("Ing Requisitos");
        edu.setEspecialTipo("Programador");
        edu.setEspecialExp("Experiencia");
        edu.setEduccionTipo("Primario");
        edu.setEduccionObj("Objeto del Requisito");
        edu.setEduccionFecha("23/09/2015");
        edu.setDescripcion("Descripcion de requerimiento a educcionar");
        edu.setObservaciones("Observaciones del requisito");
        
        ver.setvMax(1);
        ver.setvMin(2);
        edu.setEduccionNombre(nom);
        edu.setVersion(ver);
        nuevo.setTitulo("Libro de Educcion");
        nuevo.setIntro("Plantilla de Educción de Requisitos");
        nuevo.addEduccion(edu);
        nuevo.addEduccion(edu);
        return nuevo;
    }
    
    public static LibroActores crearActor(){
        LibroActores nuevo = new LibroActores();
        Actor act = new Actor();
        Nombre nom = new Nombre();
        nom.setCodigo("0001");
        nom.setNombre("Gonzalo");
        act.setOrg("Harley");
        act.setCargo("Jefe de oficina");
        act.setTipo("Desarrollador");
        act.setCorreo("glunaluza@gmail.com");
        act.setComentarios("Comentarios");
        act.setActorNombre(nom);
        nuevo.setIntro("Libro de Actores");
        nuevo.addActor(act);
        return nuevo;
    }
    
    public static LibroHistorico crearHistorico(){
        LibroHistorico nuevo = new LibroHistorico();
        Historico hist = new Historico();
        hist.setVersion("1.2");
        hist.setFecha("03/09/2015");
        hist.setRazon("Cambio 1");
        hist.setAutor("Gonzalo");
        nuevo.setTitulo("Libro Histórico");
        nuevo.setIntro("Plantilla de Libro Histórico");
        nuevo.addHistorico(hist);
        return nuevo;
    }
    
    public static LibroEspecificacion crearEspecificacion(){
        LibroEspecificacion libro = new LibroEspecificacion();
        Especificacion esp = new Especificacion();
        Nombre nom = new Nombre();
        Version ver = new Version();
        Elemento excep = new Elemento(); 
        nom.setCodigo("001");
        nom.setNombre("especificacion ads");

        ver.setvMax(1);
        ver.setvMin(2);

        libro.setTitulo("Libro de Especificación");
        //libro.setIntro("Plantilla de especificación");
        libro.addEspecificacion(esp);

        excep.setEleNumero(1);
        excep.setEleDescripcion("el sistema");
        esp.addExcepcion(excep);

        esp.setEspecificacionNombre(nom);
        esp.setEliNombre("ELI001");
        esp.setVersion(ver);
        esp.setAutor("Gonzalo");
        esp.setFuente("Jose");
        esp.setDependencias("dependencia");
        esp.setDescripcion("Descripcion");
        esp.addPrecondicion("precondicion1");
        esp.addPostcondicion("postcondicion1");
        esp.setComentarios("comentarios dasdsada");
        
        return libro;
    }
    
    public static void probarEduccion(){
        String archivo = "libroEduccion";
        XMLReader<LibroEduccion> reader = new XMLReader(LibroEduccion.class);
        reader.writeXML(archivo, crearEduccion());
        LibroEduccion abierto = reader.openXML(archivo);
        XMLConverter factory = new XMLConverter();
        factory.convert(archivo,"Educcion2.3");
    }
    
    public static void probarActor(){
        String archivo = "actores";
        XMLReader<LibroActores> reader = new XMLReader(LibroActores.class);
        reader.writeXML(archivo, crearActor());
        LibroActores abierto = reader.openXML(archivo);
        XMLConverter factory = new XMLConverter();
        factory.convert(archivo,"Actores1.2");
    }
    
    public static void probarHistorico(){
        String archivo = "historico";
        XMLReader<LibroHistorico> reader = new XMLReader(LibroHistorico.class);
        reader.writeXML(archivo, crearHistorico());
        LibroHistorico abierto = reader.openXML(archivo);
        XMLConverter factory = new XMLConverter();
        factory.convert(archivo,"Historico1");
    }
    
    public static void escribirEspecificacion(String archivo, LibroEspecificacion obj){
        XMLReader<LibroEspecificacion> reader = new XMLReader(LibroEspecificacion.class);
        reader.writeXML(archivo, obj);
    }
    
    private static LibroEspecificacion cargarEspecificacion(String archivo) {
        XMLReader<LibroEspecificacion> reader = new XMLReader(LibroEspecificacion.class);
        LibroEspecificacion esp = reader.openXML(archivo);
        return esp;
    }

    private static void exportarEspecificacionPDF(String archivo) {
        XMLConverter factory = new XMLConverter();
        factory.convert("libroEspecificacion", archivo);
    }
    
    public static void main(String[] args) {
        //probarEduccion();
        //probarActor();
        //probarHistorico();
        escribirEspecificacion("Educcion1.2", crearEspecificacion());
        cargarEspecificacion("Educcion1.2");
        exportarEspecificacionPDF("Educcion1.2");
        //String educcion = "libroEduccion";
        //String elicitacion = "libroElicitacion";
        /*String actores = "actores";
        String proyecto = "proyecto";
        String historico = "historico";
        String organizacion = "organizacion";*/
        //factory.convert(educcion);
        //factory.convert(elicitacion);
        //factory.convert(actores);
        //factory.convert(proyecto);
        //factory.convert(historico);
        //factory.convert(organizacion);       
    }

   
}
