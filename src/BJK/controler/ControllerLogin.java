/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BJK.controler;
import BJK.form.FormLogin;

/**
 *
 * @author Salman Alfarissy
 */
public class ControllerLogin {
    private FormLogin login;

    public ControllerLogin(FormLogin login) {
        this.login = login;
    }

    public void onKeyPresstxtidkasir(){
        login.getTxtpasswd().requestFocus();
    }
    public void onKeyPresstxtpasswd(){
        login.getBtnlogin().requestFocus();
    }
    
}
