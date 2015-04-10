/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author kevin
 */
public class RegistroLogin {
    
    private ArrayList<Usuario> usuarios;
    Usuario usuario1=new Usuario("1","1");
    Usuario usuario2=new Usuario("2","2");
    Usuario usuario3=new Usuario("3","3");
    
    public RegistroLogin(){
        usuarios=new ArrayList<Usuario>();
    }
    
    public void llenarUsuarios(){
        usuarios.add(usuario1);
        usuarios.add(usuario2);
        usuarios.add(usuario3);
    }
}
