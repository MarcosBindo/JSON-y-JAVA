package adaptadores.secundarios;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import model.musica.Cancion;
import model.musica.Playlist;
import model.usuarios.Usuario;
import model.usuarios.UsuarioBasico;
import model.usuarios.UsuarioPremiun;

public class manipuladorJSON {



    private static JSONObject playlists = new JSONObject();
    private static JSONObject mainJSON = new JSONObject();

    private static JSONObject usuarios = new JSONObject();



    public static JSONObject agregarCancion(Cancion cancion){
        JSONObject cancionDATA = new JSONObject();
        cancionDATA.put("Nombre", cancion.getNombre());
        cancionDATA.put("Artista", cancion.getArtista());
        cancionDATA.put("Album", cancion.getAlbum());
        cancionDATA.put("Duracion", cancion.getDuracion());

        JSONObject objCancion = new JSONObject();
        objCancion.put(cancion.getNombre(), cancionDATA);

        return objCancion;
    }

    public static void addPlaylist(Playlist pl){
        JSONArray playlist = new JSONArray();
        JSONObject estructura = new JSONObject();
        
        for (Cancion cancion : pl.getCanciones()) {
            JSONObject objCancion = agregarCancion(cancion);
            playlist.add(objCancion);
        }
        
        playlists.put(pl.getId(), playlist);
        escribirJSON(mainJSON);
    }


    public static JSONObject agregarUsuario(Usuario usuario){
        JSONObject userData = new JSONObject();
        userData.put("ID", usuario.getId());
        userData.put("Username", usuario.getNombreUsuario());
        userData.put("Pass", usuario.getPass());
        userData.put("Type", usuario.getTipoUsuario().getClass().getName());
        userData.put("Cant. Playlists", usuario.getContenedorPlaylist().size());

        return userData;
    } 

    public static void addUser(Usuario user){
        JSONObject estructura = new JSONObject();
        JSONObject objUser = agregarUsuario(user);
        
        usuarios.put(user.getId(), objUser);
        escribirJSON(mainJSON);
    }

    private static void escribirJSON(JSONObject objeto){
        objeto.clear();
        objeto.put("Playlists",playlists);
        objeto.put("Usuarios",usuarios);
        try (FileWriter file = new FileWriter("Reproductor/src/adaptadores/BD.json", false)) {
            file.write(objeto.toString()); 
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    } 

    public static void leerJSON(){
        JSONParser parser = new JSONParser();

        try(FileReader file = new FileReader("Reproductor/src/adaptadores/BD.json")){
            Object obj = parser.parse(file);
            JSONObject json = (JSONObject) obj;
            playlists = (JSONObject) json.get("Playlists");
            usuarios =  (JSONObject) json.get("Usuarios");

            for(int i = 0; i < playlists.size(); i++){
                JSONObject playlist = (JSONObject) usuarios.get(i);
                Playlist actual = new Playlist((String) playlist.get("titulo"));
            }
            int count = 1;

            for (int i = 0; i < usuarios.size(); i++) {

                JSONObject user =(JSONObject) usuarios.get(count);
                String userType = (String) user.get("Type");
                if(userType.contains("UsuarioBasico")){
                    Usuario temp = new Usuario((String) user.get("Username"), (String) user.get("Pass"), new UsuarioBasico());
                    System.out.println(temp);
                } else {
                    Usuario temp = new Usuario((String) user.get("Username"), (String) user.get("Pass"), new UsuarioPremiun());
                }   
                count++;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}



    

    

