package com.archu.gussoapintegration.regon.summaryreport;

public interface SummaryReportVisitor<T, J> {
    T visitNowePodmiotyPrawneOrazDzialalnosciOsFizycznych(J data);

    T visitAktualizowanePodmiotyPrawneOrazDzialalnosciOsFizycznych(J data);

    T visitSkreslonePodmiotyPrawneOrazDzialalnosciOsFizycznych(J data);

    T visitNoweJednostkiLokalne(J data);

    T visitAktualizowaneJednostkiLokalne(J data);

    T visitJednostkiLokalneSkreslone(J data);
}