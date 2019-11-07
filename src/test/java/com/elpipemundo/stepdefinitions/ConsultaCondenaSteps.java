package com.elpipemundo.stepdefinitions;

import com.elpipemundo.interaction.Esperar;
import com.elpipemundo.page.RamaJudicialInicioPage;
import com.elpipemundo.question.DelitoCondena;
import com.elpipemundo.question.FechaCondena;
import com.elpipemundo.question.Texto;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.Set;

import static com.elpipemundo.page.ConsultaCondenaJuzgadoPage.*;
import static com.elpipemundo.page.ConsultaProcesoPage.*;
import static com.elpipemundo.page.ListadoProcesosJuzgadoPage.pathDinamicoCondena;
import static com.elpipemundo.page.RamaJudicialInicioPage.BTN_CONSULTAR_PROCESO;
import static com.elpipemundo.page.ResumenProcesoJuzgadoPage.LNK_DETALLE_RADICADO;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.hamcrest.CoreMatchers.containsString;

public class ConsultaCondenaSteps {
   // public WebDriver driver;

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }
    /********************************************************CONDENA********************************************************/
    @Dado("que \"(.*)\" cuenta con proceso judicial en la ciudad de \"(.*)\"")
    public void consultarCondena(String actor, String ciudad) throws InterruptedException {

        theActorCalled(actor).attemptsTo(
                Open.browserOn().the(RamaJudicialInicioPage.class),
                Scroll.to(BTN_CONSULTAR_PROCESO).andAlignToBottom(),
                Click.on(BTN_CONSULTAR_PROCESO)
        );

        theActorInTheSpotlight().attemptsTo(
                SelectFromOptions.byVisibleText(ciudad).from(SELECT_CIUDAD_JUZGADO),
                Click.on(BTN_JUZGADO)
        );
        /*El paso anterior del actor genera una nueva pestaña dodne continua el flujo, por lo que es necesario moverse a
        dicha pestaña para continuar con la prueba*/
        Set<String> handles = getDriver().getWindowHandles();
        String firstWinHandle = getDriver().getWindowHandle();
        handles.remove(firstWinHandle);
        String winHandle=handles.iterator().next();
        getDriver().switchTo().window(winHandle);

    }



    @Cuando("se consulta el expediente por \"(.*)\" para el documento \"(.*)\" y selecciona el radicado \"(.*)\"")
    public void ConsultarExpedientePorParaElDocumentoYSeleccionaElRadicado(String opcionBusqueda, String documento, String radicado) {

        theActorInTheSpotlight().attemptsTo(
                SelectFromOptions.byVisibleText(opcionBusqueda).from(SELECT_OPCION_BUSQUEDA),
                Enter.theValue(documento).into(TEXT_DATO_FILTRO),
                Click.on(BTN_BUSCAR)
        );

        theActorInTheSpotlight().attemptsTo(
                Click.on(pathDinamicoCondena(radicado)),/*Seleccionar el elemento adecuado de acuerdo al radicado*/
                Click.on(LNK_DETALLE_RADICADO)
        );

    }

    @Entonces("^debe contar con condena del \"(.*)\" por el delito de \"(.*)\"$")
    public void verificarFechaYDelitoCondena(String fechaCondena, String delitoCondena) {

        theActorInTheSpotlight().should(seeThat(
                "Validar fecha de condena",
                FechaCondena.fechaCondena(),containsString(fechaCondena)),
                seeThat(
                        "Validar delito de condena",
                        DelitoCondena.delitoCondena(),containsString(delitoCondena))
        );


    }

}
