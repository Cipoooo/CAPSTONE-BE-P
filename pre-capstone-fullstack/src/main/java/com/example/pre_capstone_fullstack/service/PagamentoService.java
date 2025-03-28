package com.example.pre_capstone_fullstack.service;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PagamentoService {

    @Value("${stripe.secret.key}")
    private String stripeSecretKey;

    public String createCheckoutSession(List<String> items, double totale) throws StripeException {
        Stripe.apiKey = stripeSecretKey;

        SessionCreateParams.Builder builder = SessionCreateParams.builder()
                .setMode(SessionCreateParams.Mode.PAYMENT)
                .setSuccessUrl("http://localhost:5173/success")
                .setCancelUrl("http://localhost:5173/cancel");

        for (String item : items) {
            builder.addLineItem(
                    SessionCreateParams.LineItem.builder()
                            .setPriceData(SessionCreateParams.LineItem.PriceData.builder()
                                    .setCurrency("eur")
                                    .setUnitAmount((long) (totale * 100))
                                    .setProductData(SessionCreateParams.LineItem.PriceData.ProductData.builder()
                                            .setName(item)
                                            .build())
                                    .build())
                            .setQuantity(1L)
                            .build()
            );
        }

        Session session = Session.create(builder.build());
        return session.getUrl(); // Restituisce l'URL della pagina di pagamento Stripe
    }
}