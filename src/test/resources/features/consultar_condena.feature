# language: es
Característica: Proceso Judicial
    Felipe como ciudadano
    Quiere consultar sus procesos judiciales
    Para ver los avances de su proceso judicial

    Escenario: Consultar expediente de penas para SERGIO ELIECER - MARTINEZ PEREZ
      Dado  que "SERGIO ELIECER - MARTINEZ PEREZ" cuenta con proceso judicial en la ciudad de "MEDELLIN"
      Cuando se consulta el expediente por "Documento de identificación del sujeto" para el documento "71984905" y selecciona el radicado "76892600019120090015901"
      Entonces debe contar con condena del "17/9/2013" por el delito de "INASISTENCIA ALIMENTARIA ART. 233 C.P. -"
