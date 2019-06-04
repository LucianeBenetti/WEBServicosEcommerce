package controle.VO;

import java.util.Date;

public class PedidoCompra {

    private int codigoPedido;
    private Usuario usuario;
    private Date dataPedido;

    public PedidoCompra() {
    }

    public PedidoCompra(int codigoPedido, Usuario usuario, Date dataPedido) {
        this.codigoPedido = codigoPedido;
        this.usuario = usuario;
        this.dataPedido = dataPedido;
    }

    public int getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(int codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    @Override
    public String toString() {
        return "PedidoCompra{" + "codigoPedido=" + codigoPedido + ", usuario=" + usuario + ", dataPedido=" + dataPedido + '}';
    }

    
}