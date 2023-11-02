package com.ControleDePedidos.api.entities.enums;

public enum OrderStatus {

    ESPERANDO_PAGAMENTO(1),
    PAGO(2),
    ENVIADO(3),
    ENTREGUE(4),
    CANCELADO(5);

    private int codigo;

    private OrderStatus(int codigo){
        this.codigo=codigo;
    }

    public int getCodigo(){
        return codigo;
    }
    public static OrderStatus valueOf(int codigo) throws IllegalAccessException {
        for (OrderStatus valor : OrderStatus.values()){
            if(valor.getCodigo() == codigo){
                return valor;
            }
        }
        throw new IllegalAccessException("Código inválido");
    }
}
