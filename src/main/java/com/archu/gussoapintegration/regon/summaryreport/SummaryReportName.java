package com.archu.gussoapintegration.regon.summaryreport;

public enum SummaryReportName {
    BIR11NowePodmiotyPrawneOrazDzialalnosciOsFizycznych {
        @Override
        public <T, J> T visit(SummaryReportVisitor<T, J> visitor, J data) {
            return visitor.visitNowePodmiotyPrawneOrazDzialalnosciOsFizycznych(data);
        }
    },
    BIR11AktualizowanePodmiotyPrawneOrazDzialalnosciOsFizycznych {
        @Override
        public <T, J> T visit(SummaryReportVisitor<T, J> visitor, J data) {
            return visitor.visitAktualizowanePodmiotyPrawneOrazDzialalnosciOsFizycznych(data);
        }
    },
    BIR11SkreslonePodmiotyPrawneOrazDzialalnosciOsFizycznych {
        @Override
        public <T, J> T visit(SummaryReportVisitor<T, J> visitor, J data) {
            return visitor.visitSkreslonePodmiotyPrawneOrazDzialalnosciOsFizycznych(data);
        }
    },
    BIR11NoweJednostkiLokalne {
        @Override
        public <T, J> T visit(SummaryReportVisitor<T, J> visitor, J data) {
            return visitor.visitNoweJednostkiLokalne(data);
        }
    },
    BIR11AktualizowaneJednostkiLokalne {
        @Override
        public <T, J> T visit(SummaryReportVisitor<T, J> visitor, J data) {
            return visitor.visitAktualizowaneJednostkiLokalne(data);
        }
    },
    BIR11JednostkiLokalneSkreslone {
        @Override
        public <T, J> T visit(SummaryReportVisitor<T, J> visitor, J data) {
            return visitor.visitJednostkiLokalneSkreslone(data);
        }
    };

    public abstract <T, J> T visit(SummaryReportVisitor<T, J> visitor, J data);

}
