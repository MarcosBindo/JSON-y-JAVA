package model;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Playlist {
    private String titulo;
    private Cancion cancion;
    private ArrayList<Cancion> canciones;
    private static final AtomicInteger count = new AtomicInteger();
    private int Id;


    public Playlist(String titulo){
        this.titulo = titulo;
        this.cancion =cancion;
        this.canciones= new ArrayList<Cancion>();
        Id = count.incrementAndGet();
    }

    public void addSong(Cancion cancion){
        this.canciones.add(cancion);
    }

    public void setCanciones(ArrayList<Cancion> canciones) {
        this.canciones = canciones;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public ArrayList<Cancion> getCanciones() {
        return canciones;
    }
    public String getTitulo() {
        return titulo;
    }
    public Cancion getCancion() {
        return cancion;
    }
    public void setCancion(Cancion cancion) {
        this.cancion = cancion;
    }

    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }
}
