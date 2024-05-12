package com.example.demo;

public class NotificadorEmail {
    private EmailCliente emailCliente;

    public NotificadorEmail(EmailCliente emailCliente) {
        this.emailCliente = emailCliente;
    }

    public void notificar(String direccion, String mensaje) {
        // Validar que la dirección y el mensaje no sean nulos o vacíos
        if (direccion == null || direccion.isEmpty() || mensaje == null || mensaje.isEmpty()) {
            return;
        }

        //si envio el correo si cumple el if
        emailCliente.enviarCorreo(direccion, mensaje);
    }
}
