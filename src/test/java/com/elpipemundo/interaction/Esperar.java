package com.elpipemundo.interaction;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import org.awaitility.Awaitility;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Esperar implements Interaction {
    private int tiempo;

    public Esperar(int tiempo) {
        this.tiempo = tiempo;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            Awaitility.await().forever().pollInterval(tiempo, TimeUnit.MILLISECONDS).until(new Callable<Boolean>() {
                @Override
                public Boolean call() throws Exception {
                    return true;
                }
            });
        } catch (Exception e) {
            Logger.getLogger("Esperar").log(Level.INFO, "Error " + e);
        }
    }

    public static Esperar unMomento(int tiempo) {
        return instrumented(Esperar.class, tiempo);
    }
}