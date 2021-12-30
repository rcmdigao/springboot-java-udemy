package com.educandoweb.cursojava.entities.enums;

import com.educandoweb.cursojava.entities.Order;

public enum OrderStatus {

    AGUARDANDO_PAGAMENTO(1),
    PAGO(2),
    ENVIADO(3),
    ENTREGUE(4),
    CANCELADO(5);

    private int code;

    private OrderStatus(int code) {
        this.code = code;
    }

    // Deixar acessivel ao mundo
    public int getCode() {
        return code;
    }

    //Todo Meetodo statico para converter valor numerico para o tipo Enumerado
    public static OrderStatus valueof(int code) {
        for (OrderStatus value : OrderStatus.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Código Inválido");
    }


}
