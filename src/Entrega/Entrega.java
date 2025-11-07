package Entrega;
import Cliente.Cliente;

public class Entrega {

    private Cliente destinatario = new Cliente();
    private Cliente remetente = new Cliente();
    private int idCliente;

    public Cliente getDestinatario() {
        return destinatario;
    }
    public void setDestinatario(Cliente destinatario) {
        this.destinatario = destinatario;
    }
    public Cliente getRemetente() {
        return remetente;
    }
    public void setRemetente(Cliente remetente) {
        this.remetente = remetente;
    }
    public int getId_cliente() {
        return idCliente;
    }

}
