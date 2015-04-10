/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.RegistroLogin;
import vista.GUIPrincipal;
import vista.Login;

/**
 *
 * @author kevin
 */
public class ControlLogin implements ActionListener{

    private int contador=0;
    private RegistroLogin registro;
    private Login login;
    
    public ControlLogin(Login login){
        this.registro=new RegistroLogin();
        this.login=login;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equalsIgnoreCase(Login.BTN_ACEPTAR)){
            if(registro.verificar(login.getTxtUsuario(), login.getContraseña())){
                GUIPrincipal guiPrincipal=new GUIPrincipal();
                guiPrincipal.show();
            }else{
                if(contador>=5){
                    Login.mensaje("El numero de intentos fue superado");
                    login.editable();
                }else{
                    contador++;
                    Login.mensaje("Usuario o contraseña incorrectos");
                    login.limpiar();
                }
            }
        }
        
        if(e.getActionCommand().equalsIgnoreCase(Login.BTN_SALIR)){
            System.exit(0);
        }
    }
    
}
