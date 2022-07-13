package org.sofka.software.utilities;

public class Email {

    private final String email;
    private Boolean state;

    public Email(String email, Boolean state) {
        this.email = email;
        this.state = state;
    }

    public String email() {
        return email;
    }

    public Boolean state() {
        return state;
    }

    public void state(Boolean state) {
        this.state = state;
    }

    @Override
    public String toString(){
        if(state){
            return ("Correo: ").concat(email()).concat("  Correo enviado: Si.");
        }
        return ("Correo: ").concat(email()).concat("  Correo enviado: No.");
    }
}
