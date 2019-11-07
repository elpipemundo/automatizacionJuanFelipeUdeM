# language: es
Característica: Proceso Judicial
    Felipe como ciudadano
    Quiere consultar sus procesos judiciales
    Para ver los avances de su proceso judicial

    Escenario: Consultar el proceso judicial 0000000000
        Dado que "Felipe" esta consultando el proceso judicial
        Cuando selecciona Ciudad "MEDELLIN" , entidad "TRIBUNAL ADMINISTRATIVO DE ANTIOQUIA (ESCRITURAL)" y numero radicado "0000000000"
        Entonces debe poder seleccionar la consulta
