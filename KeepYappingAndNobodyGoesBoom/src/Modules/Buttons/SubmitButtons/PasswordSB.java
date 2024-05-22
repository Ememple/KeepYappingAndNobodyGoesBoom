package Modules.Buttons.SubmitButtons;

import Frames.Bomb;
import Modules.Module;
import Modules.Password;

import java.awt.event.ActionEvent;

public class PasswordSB extends SubmitButton {
    Password password;

    public PasswordSB(Password password){
        super();
        this.password = password;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean match = true;
        for (int i = 0; i < password.getPassword().length(); i++) {
            if (password.getChars()[i] != i){
                match = false;
            }
        }
        if (match){
            password.state = Module.State.SUCCsesful;
            password.disable();
        } else {
            password.state = Module.State.unSUCCsesful;
            Bomb.strikePlus();
        }
    }
}
