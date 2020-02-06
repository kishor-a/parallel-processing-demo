package com.akishor;

import lombok.*;

@Setter
@Getter
@Builder
@ToString
@EqualsAndHashCode
public class Order {

    private String orderId;
    private String description;
    private boolean paymentDone;
    private boolean mailSent;
    private boolean dispatch;

}
