package com.archu.gussoapintegration.regon.fullreport;

import java.util.List;

public interface FullReportVisitor<T, J> {
    T visitOsFizycznaDaneOgolne(J data);

    T visitOsFizycznaDzialalnoscCeidg(J data);

    T visitOsFizycznaDzialalnoscRolnicza(J data);

    T visitOsFizycznaDzialalnoscPozostala(J data);

    T visitOsFizycznaDzialalnoscSkreslonaDo20141108(J data);

    T visitOsFizycznaPkd(J data);

    T visitOsFizycznaListaJednLokalnych(J data);

    T visitJednLokalnaOsFizycznej(J data);

    T visitJednLokalnaOsFizycznejPkd(J data);

    T visitOsPrawna(J data);

    T visitOsPrawnaPkd(J data);

    T visitOsPrawnaListaJednLokalnych(J data);

    T visitJednLokalnaOsPrawnej(J data);

    T visitJednLokalnaOsPrawnejPkd(J data);

    T visitOsPrawnaSpCywilnaWspolnicy(J data);

    T visitTypPodmiotu(J data);
}