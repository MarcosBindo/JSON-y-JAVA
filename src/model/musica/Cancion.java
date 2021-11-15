package model.musica;
public class Cancion {
    private String nombre, artista, album;
    private double duracion;

    public Cancion(String nombre, String artista, String album, double duracion){
        this.album = album;
        this.nombre = nombre;
        this.artista = artista;
        this.duracion = duracion;

    }

    public String getAlbum() {
        return album;
    }
    public String getArtista() {
        return artista;
    }
    public double getDuracion() {
        return duracion;
    }
    public String getNombre() {
        return nombre;
    }
    public void setAlbum(String album) {
        this.album = album;
    }
    public void setArtista(String artista) {
        this.artista = artista;
    }
    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
