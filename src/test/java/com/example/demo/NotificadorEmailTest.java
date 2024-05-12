package com.example.demo;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
public class NotificadorEmailTest {

    @Mock
    private EmailCliente emailClienteMock;

    @Test
    public void testNotificar() {
        NotificadorEmail notificador = new NotificadorEmail(emailClienteMock);
        notificador.notificar("ejemplo@test.com", "Hola Mundo");

        // Verificar que emailClienteMock.enviarCorreo se llamó con los argumentos correctos
        verify(emailClienteMock).enviarCorreo("ejemplo@test.com", "Hola Mundo");
    }

    // Test para verificar que no se envía correo con dirección vacía
    @Test
    public void testNotificarConDireccionVacia() {
        NotificadorEmail notificador = new NotificadorEmail(emailClienteMock);
        notificador.notificar("", "Mensaje");

        // Verificar que no se realiza el envío si la dirección es vacía
        verify(emailClienteMock, times(0)).enviarCorreo(anyString(), anyString());
    }

    // Test para verificar el comportamiento con mensaje nulo
    @Test
    public void testNotificarConMensajeNulo() {
        NotificadorEmail notificador = new NotificadorEmail(emailClienteMock);
        notificador.notificar("ejemplo@test.com", null);

        // Verificar que se maneja adecuadamente un mensaje nulo
        verify(emailClienteMock, never()).enviarCorreo(anyString(), anyString());
    }

    // Test para verificar el comportamiento con mensaje vacío
    @Test
    public void testNotificarConMensajeVacio() {
        NotificadorEmail notificador = new NotificadorEmail(emailClienteMock);
        notificador.notificar("ejemplo@test.com", "");

        // Verificar que no se realiza el envío si el mensaje es vacío
        verify(emailClienteMock, never()).enviarCorreo(anyString(), anyString());
    }

    // Test para verificar el comportamiento con dirección nula
    @Test
    public void testNotificarConDireccionNula() {
        NotificadorEmail notificador = new NotificadorEmail(emailClienteMock);
        notificador.notificar(null, "Mensaje");

        // Verificar que no se realiza el envío si la dirección es nula
        verify(emailClienteMock, never()).enviarCorreo(anyString(), anyString());
    }

    // Test para verificar el comportamiento con dirección y mensaje nulos
    @Test
    public void testNotificarConDireccionYMensajeNulos() {
        NotificadorEmail notificador = new NotificadorEmail(emailClienteMock);
        notificador.notificar(null, null);

        // Verificar que no se realiza el envío si la dirección y el mensaje son nulos
        verify(emailClienteMock, never()).enviarCorreo(anyString(), anyString());
    }

    // Test para verificar el comportamiento con dirección y mensaje vacíos
    @Test
    public void testNotificarConDireccionYMensajeVacios() {
        NotificadorEmail notificador = new NotificadorEmail(emailClienteMock);
        notificador.notificar("", "");

        // Verificar que no se realiza el envío si la dirección y el mensaje son vacíos
        verify(emailClienteMock, never()).enviarCorreo(anyString(), anyString());
    }
}
