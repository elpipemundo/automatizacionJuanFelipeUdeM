package com.elpipemundo.stepdefinitions;

import com.elpipemundo.interaction.Esperar;
import com.elpipemundo.page.ConsultaProcesoPage;
import com.elpipemundo.page.RamaJudicialInicioPage;
import com.elpipemundo.question.DelitoCondena;
import com.elpipemundo.question.FechaCondena;
import com.elpipemundo.question.Texto;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.core.annotations.findby.By;
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
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isSelected;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.hamcrest.CoreMatchers.containsString;

public class ConsultaProcesosSteps {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("que \"(.*)\" esta consultando el proceso judicial")
    public void consultarProcesoJudicial(String actor) {
        theActorCalled(actor).attemptsTo(
                Open.browserOn().the(RamaJudicialInicioPage.class),
                Scroll.to(BTN_CONSULTAR_PROCESO).andAlignToBottom(),
                Click.on(BTN_CONSULTAR_PROCESO)
        );
    }

    @Cuando("selecciona Ciudad \"(.*)\" , entidad \"(.*)\" y numero radicado \"(.*)\"")
    public void seleccionaCiudadEntidadYNumeroRadicado(String ciudad, String entidad, String nroRadicado) {
        theActorInTheSpotlight().attemptsTo(
                SelectFromOptions.byVisibleText(ciudad).from(SELECT_CIUDAD),
                WaitUntil.the(SELECT_CIUDAD,isClickable()),
                Esperar.unMomento(1000),/* Se requiere una pausa ya que a veces la velocidad de carga de la página no es muy buena*/
                SelectFromOptions.byVisibleText(entidad).from(SELECT_ENTIDAD),
                WaitUntil.the(SELECT_ENTIDAD,isClickable()),
               Enter.theValue(nroRadicado).into(TEXT_RADICADO)
        );

    }

    @Entonces("debe poder seleccionar la consulta")
    public void verificarActivacionConsulta() {
       theActorInTheSpotlight().should(seeThat(
               "Validar si existe el texto que pide deslizar barra",
               Texto.barra(),containsString("Deslice la barra a la derecha para iniciar la consulta."))
       );
    }


}
